package com.sjsu.cmpe286;

import static com.datastax.spark.connector.japi.CassandraJavaUtil.javaFunctions;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.DoubleFunction;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

import com.datastax.driver.core.Session;
import com.datastax.spark.connector.japi.CassandraRow;
import com.datastax.spark.connector.cql.CassandraConnector;
import com.datastax.spark.connector.japi.rdd.CassandraJavaRDD;
import com.google.common.base.Optional;
import com.sjsu.cmpe286.dao.RSVPRowReader.RSVPRowReaderFactory;
import com.sjsu.cmpe286.dao.RSVPRowWriter.RSVPRowWriterFactory;
import com.sjsu.cmpe286.model.RSVP;

public class JavaDemo implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient SparkConf conf;
    private RSVPRowWriterFactory rsvpWriter = new RSVPRowWriterFactory();

    private RSVPRowReaderFactory rsvpReader = new RSVPRowReaderFactory();


    private JavaDemo(SparkConf conf) {
        this.conf = conf;
    }

    private void run() {
        JavaSparkContext sc = new JavaSparkContext(conf);
        
        CassandraJavaRDD<CassandraRow> cassandraRowsRDD = javaFunctions(sc).cassandraTable("meetup", "rsvpstream");	
        //Get event names
        JavaRDD<String> even_name = cassandraRowsRDD.select("event_name")
        		.map(CassandraRow::toMap)
        		.map(entry -> entry.get("event_name").toString());
        
        
        JavaRDD<String> rsvp = cassandraRowsRDD.select("member_name")
        		.map(CassandraRow::toMap)
        		.map(entry -> entry.get("member_name").toString());
        
        
        /* collect sum of peolple attending event in country*/
        JavaPairRDD<String, Integer> counts = rsvp.mapToPair(
        		new PairFunction<String, String, Integer>(){
        		public Tuple2<String, Integer> call(String x){
        		return new Tuple2(x, 1);
        		}}).reduceByKey(new Function2<Integer, Integer, Integer>(){
        		public Integer call(Integer x, Integer y){ return x + y;}});
   
//        javaFunctions(counts).writerBuilder("java_api", "summaries", rsvpWriter).saveToCassandra();
    
        
        sc.stop();
    }
      

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Syntax: com.datastax.spark.demo.JavaDemo <Spark Master URL> <Cassandra contact point>");
            System.exit(1);
        }

        SparkConf conf = new SparkConf();
        conf.setAppName("Java API demo");
        conf.setMaster("local[8]");
        conf.set("spark.cassandra.connection.host", "localhost");

        JavaDemo app = new JavaDemo(conf);
        app.run();
    }
}