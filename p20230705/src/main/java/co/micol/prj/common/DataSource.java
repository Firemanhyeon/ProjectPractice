package co.micol.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {  //싱글톤 class
	private static SqlSessionFactory sqlSessionFactory;
	private DataSource() {}//외부에서 생성하지못하도록 생성자 DataSource datasource= new DataSource()가 안된다.
	
	public static SqlSessionFactory getInstance() {//인스턴스얻어서써야된다 라는ㄴ뜻
		String resource = "config/mybatis-config.xml";
	
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
	
}
