package com.sjsu.cmpe286.dao;

import java.io.Serializable;
import com.datastax.spark.connector.ColumnRef;
import com.datastax.spark.connector.cql.TableDef;
import com.datastax.spark.connector.writer.RowWriter;
import com.datastax.spark.connector.writer.RowWriterFactory;
import com.sjsu.cmpe286.model.RSVP;
import scala.collection.IndexedSeq;
import scala.collection.Seq;


public class RSVPRowWriter implements RowWriter<RSVP> {
	
	private static final long serialVersionUID = 1L;
	private static RowWriter<RSVP> writer = new RSVPRowWriter();
	// Factory
	public static class RSVPRowWriterFactory implements RowWriterFactory<RSVP>, Serializable{
	private static final long serialVersionUID = 1L;
	@Override
	public RowWriter<RSVP> rowWriter(TableDef row, IndexedSeq<ColumnRef> arg1) {
		
		return writer;
	}
	}
	@Override
	public Seq<String> columnNames() {
	return scala.collection.JavaConversions.asScalaBuffer(RSVP.columns()).toList();
	}
	@Override
	public void readColumnValues(RSVP product, Object[] buffer) {
	buffer[0] = product.getId();
	buffer[1] = product.getName();
	buffer[2] = product.getParents();
	}
}
