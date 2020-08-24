import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adrbook.model.AdrbookDaoIMP;
import com.adrbook.model.AdrbookVO;

public class Test01 {



		private  InputStream is ;
		private  SqlSession sqlSession ;
		private  AdrbookDaoIMP abkDao ;
		@Before
		public  void init() throws IOException{
			//�ϥ�sqlSessionFactory���o�s�u��T�C
			//1. Ū���t�m���
			is = Resources.getResourceAsStream("mybatis-config.xml");
			//2. �Ы�sqlSessionFactory �u�t
			SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = build.build(is);
			//3.�ϥΤu�t�Ͳ�sqlSession ��H
			sqlSession = factory.openSession();
			//4.�ϥ�SqlSession�Ы�Dao �������N�z��H
			abkDao = sqlSession.getMapper(AdrbookDaoIMP.class);
		}
		@After
		public  void destory() throws IOException{
			//6. ����귽
			sqlSession.close();
			is.close();

		}
		@Test
		public void test() {

					//�N��Ƹ˶iVO
					AdrbookVO adk_vo = new AdrbookVO();
			    	String xuid = "200000065";
			    	adk_vo.setName("ABC");
			    	adk_vo.setTel("123456");
			    	adk_vo.setGender("male");
			    	adk_vo.setType("�P��");
			    	adk_vo.setType_index(0);
			    	adk_vo.setNotes("test");
			    	//adk_vo.setXuid(xuid);
			    	adk_vo.setIp("0:0:0:0:0:0:0:1");
			    	adk_vo.setBrow_ver("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36");

			    	//abkDao.update(adk_vo);
			    	abkDao.insert(adk_vo);
					List<AdrbookVO> adks =abkDao.getAll();
					for(AdrbookVO adk :adks){
						System.out.println(adk);
					}
		}

	}

