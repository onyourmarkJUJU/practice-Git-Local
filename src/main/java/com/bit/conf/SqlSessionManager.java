package com.bit.conf;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class SqlSessionManager {
    public static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "com/bit/conf/configuration.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            //cher []buf = new char[3000];
            //reader.read(buf);
            //System.out.println(String.valueOf(buf));
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }   //staticBlock

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
