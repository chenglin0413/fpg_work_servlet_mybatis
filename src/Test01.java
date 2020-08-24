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
			//使用sqlSessionFactory取得連線資訊。
			//1. 讀取配置文件
			is = Resources.getResourceAsStream("mybatis-config.xml");
			//2. 創建sqlSessionFactory 工廠
			SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = build.build(is);
			//3.使用工廠生產sqlSession 對象
			sqlSession = factory.openSession();
			//4.使用SqlSession創建Dao 介面的代理對象
			abkDao = sqlSession.getMapper(AdrbookDaoIMP.class);
		}
		@After
		public  void destory() throws IOException{
			//6. 釋放資源
			sqlSession.close();
			is.close();

		}
		@Test
		public void test() {

					//將資料裝進VO
					AdrbookVO adk_vo = new AdrbookVO();
			    	String xuid = "200000065";
			    	adk_vo.setName("ABC");
			    	adk_vo.setTel("123456");
			    	adk_vo.setGender("male");
			    	adk_vo.setType("同學");
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

