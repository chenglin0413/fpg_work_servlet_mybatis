import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.adrbook.model.AdrbookDaoIMP;
import com.adrbook.model.AdrbookVO;

public class test {

	public static void main(String[] args) throws IOException {
		//�ϥ�sqlSessionFactory���o�s�u��T�C
		//1. Ū���t�m���
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		//2. �Ы�sqlSessionFactory �u�t
		SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = build.build(is);
		//3.�ϥΤu�t�Ͳ�sqlSession ��H
		SqlSession sqlSession = factory.openSession(true);
		//4.�ϥ�SqlSession�Ы�Dao �������N�z��H
		AdrbookDaoIMP abkDao = sqlSession.getMapper(AdrbookDaoIMP.class);
		//5.�ϥΥN�z��H�����k

		AdrbookVO adk_vo = new AdrbookVO();
		String name = "ABC";
    	String tel = "123456";
    	String notes = "test";
    	String type = "�P��";
    	int type_index = 0;
    	String gender = "male";
    	String xuid = "200000065";
    	adk_vo.setName(name);
    	adk_vo.setTel(tel);
    	adk_vo.setGender(gender);
    	adk_vo.setType(type);
    	adk_vo.setType_index(type_index);
    	adk_vo.setNotes(notes);
//    	adk_vo.setXuid(xuid);
    	adk_vo.setIp("0:0:0:0:0:0:0:1");
    	adk_vo.setBrow_ver("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36");
//		abkDao.update(adk_vo);
    	abkDao.insert(adk_vo);
		List<AdrbookVO> adks =abkDao.getAll();
		for(AdrbookVO adk :adks){
			System.out.println(adk);
		}
	}

}
