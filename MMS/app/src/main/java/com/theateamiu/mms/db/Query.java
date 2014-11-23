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
            Column.DATE_END+" text);";
}
