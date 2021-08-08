package com.iwill.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import java.math.BigInteger;
import java.net.InetSocketAddress;

public class Test {

    public static void main(String[] args) throws Exception {
        CqlSession session = CqlSession.builder().withLocalDatacenter("datacenter1").addContactPoint(new InetSocketAddress("127.0.0.1", 9042)).withKeyspace("test").build();
        ResultSet resultSet = session.execute("select * from user");
        for (Row row : resultSet) {
            System.out.println("id ： " + row.get("id", Integer.class));
            System.out.println("name ： " + row.get("name", String.class));
            System.out.println("address ： " + row.get("address", String.class));
            System.out.println("age ： " + row.get("age", BigInteger.class));
            System.out.println("phone ： " + row.get("phone", BigInteger.class));
        }
        session.close();
    }
}
