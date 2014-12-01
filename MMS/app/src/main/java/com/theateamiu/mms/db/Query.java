package com.theateamiu.mms.db;


public class Query {
    public static final String CREATE_TABLE_MESS = "create table "+Table.MESS+"("+
                                                    Column.ID+" integer primary key,"+
                                                    Column.NAME+" text,"+
            Column.IMAGE_URI+" text,"+
            Column.POSTAL_ADDRESS+" text,"+
            Column.DISTRICT+" text,"+
            Column.REGION+" text,"+
            Column.DATE_START+" text,"+
            Column.DATE_END+" text,"+
            Column.RANK_IN_DIST+" integer,"+
            Column.RANK_IN_COUNTRY+" integer,"+
            Column.EMAIL_MANAGER+" text);";
    public static final String DROP_TABLE_MESS = "drop table if exists "+ Table.MESS;

    public static final String CREATE_TABLE_BOARDERS = "create table "+Table.BOARDERS+"("+
            Column.ID+" integer primary key,"+
            Column.NAME+" text,"+
            Column.PHONE_NO+" text,"+
            Column.EMAIL+" text,"+
            Column.PROFESSION+" text,"+
            Column.DATE_OF_BIRTH+" text,"+
            Column.BLOOD_GROUP+" text,"+
            Column.IMAGE_URI+" text,"+
            Column.MANAGERIAL_ID+" integer);";
    public static final String DROP_TABLE_BOARDERS = "drop table if exists "+Table.BOARDERS;


    public static final String SELECT_ALL_MESS = "select * from "+Table.MESS;
    public static final String SELECT_ALL_BOARDER = "select * from "+Table.BOARDERS;

}
