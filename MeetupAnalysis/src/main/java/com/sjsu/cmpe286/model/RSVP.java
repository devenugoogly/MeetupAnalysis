package com.sjsu.cmpe286.model;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class RSVP {
	private static final long serialVersionUID = 1L;
    private Integer rsvp_id;
    private String event_name;
    private String member_name;
    private List<Integer> parents;
//    rsvp_id int PRIMARY KEY,
//    event_name text,
//    event_time timestamp,
//    event_url text,
//    group_city text,
//    group_country text,
//    group_id int,
//    group_lat int,
//    group_lon int,
//    group_name text,
//    group_state text,
//    group_topic_names text,
//    guests int,
//    member_id int,
//    member_name text,
//    response text,
//    rsvp_last_modified_time timestamp,
//    venue_id int,
//    venue_lat decimal,
//    venue_lon decimal,
//    venue_name text,
//    visibility text

    
    public RSVP() {
    }

    public RSVP(Integer id, String name,String member_name, List<Integer> parents) {
        this.rsvp_id = id;
        this.event_name = name;
        this.member_name = member_name;
        this.parents = parents;
    }

    public Integer getId() {
        return rsvp_id;
    }

    public void setId(Integer id) {
        this.rsvp_id = id;
    }

    public String getName() {
        return event_name;
    }

    public void setName(String name) {
        this.event_name = name;
    }
    
    public String getMeberName() {
        return member_name;
    }

    public void setMemberName(String name) {
        this.member_name = name;
    }

    public List<Integer> getParents() {
        return parents;
    }

    public void setParents(List<Integer> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return MessageFormat.format("RSVP'{'id={0}, name=''{1}'', parents={2}'}'", rsvp_id, event_name, parents);
    }
    
    public static List<String> columns() {
        List<String> columns = new ArrayList<String>();
        columns.add("rsvp_id");
        columns.add("event_name");
        columns.add("member_name");
        columns.add("parents"); 
        return columns;
    }
}
