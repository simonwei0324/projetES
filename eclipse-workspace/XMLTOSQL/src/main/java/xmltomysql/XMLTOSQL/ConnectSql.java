package xmltomysql.XMLTOSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ConnectSql {
	static String sqlStr = "jdbc:mysql://localhost:3306/publications";
	static String rootName = "root";//数据库名
	static String rootPwd = "";//数据库密码
 
	public static void writeToMysql(Article publication) {
		System.out.println(publication);
		//1.加载driver驱动
		try {
			// 加载MySql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
		//2.建立连接
		//Statement st = null;
		 PreparedStatement st = null;
		//调用DriverManager对象的getConnection()方法，获得一个Connection对象
		Connection con  =null;
		try {
			//建立数据库连接
			con = DriverManager.getConnection(sqlStr, rootName,rootPwd);
			//INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
			int id= Integer.parseInt(publication.getId());
			String title = publication.getTitre();
			String key_word = publication.getKeyword();
			String content = publication.getResume();
			String url = publication.getUrl() ;
			String reply = publication.getReply();
			String source = publication. getSource();
			String postdate = publication.getPostdate();
			//插入语句格式
			String sql = "insert into news(id,title,key_word,content,url,reply,source,postdate) values(?,?,?,?,?,?,?,?)";
			System.out.println(sql);
	             st = con.prepareStatement(sql);
		  		 
	             st.setInt(1, Integer.parseInt(publication.getId()));
	             st.setString(2,publication.getTitre());
	             st.setString(3, publication.getKeyword());
	             st.setString(4, publication.getResume());
	             st.setString(5,publication.getUrl());
	             st.setString(6, publication.getReply());
	             st.setString(7, publication. getSource());
	             st.setString(8, publication.getPostdate());
	             st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
