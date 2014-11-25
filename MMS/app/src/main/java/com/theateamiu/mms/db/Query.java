package com.theateamiu.mms.db;


public class Query {
    public static final String CREATE_TABLE_MESS = "create table "+Table.MESS+"("+
                                                    Column.ID+" integer primary key,"+
                                                    Column.NAME+" text,"+
            Column.IMAGE_URL+" text,"+
            Column.POSTAL_ADDRESS+" text,"+
            Column.DISTRICT+" text,"+
            Column.REGION+" text,"+
            Column.DATE_START+" text,"+
            Column.DATE_END+" text,"+
            Column.RANK_IN_DIST+" integer,"+
            Column.RANK_IN_COUNTRY+" integer,"+
            Column.EMAIL_MANAGER+" text);";
    public static final String DROP_TABLE_MESS = "drop table if exists "+ Table.MESS;

    public static final String CREATE_TABLE_BOARDER = "";


    public static final String SELECT_ALL_MESS = "select * from "+Table.MESS;

}
