package com.adrbook.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class GetSqlSessionFactory {


   private static SqlSessionFactory sqlSessionFactory;

   /**
    * �p���c�y��k�A�ϸ������i�Ыطs��H
    */
   private GetSqlSessionFactory(){

   }

   /**
    * �ϥΦP�B��
    * @return sql session �u�t
    */
   synchronized public static SqlSessionFactory getSqlSessionFactory(){
       if (sqlSessionFactory == null){
	    	//�ϥ�sqlSessionFactory���o�s�u��T�C
	   		//1. Ū���t�m���
	   		InputStream is;
			try {
				is = Resources.getResourceAsStream("mybatis-config.xml");
				//2. �Ы�sqlSessionFactory �u�t
		   		SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
		   		sqlSessionFactory = build.build(is);
			} catch (IOException e) {
				e.printStackTrace();
			}

       }
       return sqlSessionFactory;
   }

}
