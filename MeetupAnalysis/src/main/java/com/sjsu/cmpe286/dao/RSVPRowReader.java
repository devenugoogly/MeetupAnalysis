package com.sjsu.cmpe286.dao;

import java.io.Serializable;

import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.Row;
import com.datastax.spark.connector.ColumnRef;
import com.datastax.spark.connector.cql.TableDef;
import com.datastax.spark.connector.rdd.reader.RowReader;
import com.datastax.spark.connector.rdd.reader.RowReaderFactory;
import com.sjsu.cmpe286.model.RSVP;

import scala.collection.IndexedSeq;

public class RSVPRowReader  extends GenericRowReader<RSVP> implements RowReader<RSVP> {

	private static final long serialVersionUID = 1L;
    private static RowReader<RSVP> reader = new RSVPRowReader();

    public static class RSVPRowReaderFactory implements RowReaderFactory<RSVP>, Serializable{
        private static final long serialVersionUID = 1L;

        @Override
        public RowReader<RSVP> rowReader(TableDef arg0, IndexedSeq<ColumnRef> arg1) {
            return reader;
        }

        @Override
        public Class<RSVP> targetClass() {
            return RSVP.class;
        }
    }

	@Override
	public RSVP read(Row row, String[] arg1, ProtocolVersion arg2) {
		RSVP rsvp = new RSVP();        
		rsvp.setId(row.getInt(0));
		rsvp.setName(row.getString(1));
		rsvp.setMemberName(row.getString(2));
		rsvp.setParents(row.getList(2, Integer.class));
        return rsvp;
	}


}
