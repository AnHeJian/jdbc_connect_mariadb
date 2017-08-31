package seu.database.hello;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;

public class connect 
{
	public static void main(String[] args) {
		Connection conn ;
		//驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		
		//URL指向要访问的数据库名
		String url = "jdbc:mysql://192.168.99.100:3306/company";
		
		String user = "admin";
		String psw = "123456";
		
		try
		{
			//加载驱动程序
			Class.forName(driver);
			//getConnection()方法，连接MySQL数据库
			conn = DriverManager.getConnection(url, user, psw);
			
			if(!conn.isClosed())
				System.out.println("连接成功");
			
			//创建statement类对象，用来执行SQL语句
			Statement st = conn.createStatement();
			
			//要执行的sql语句
			String sql = "SELECT employeeno,ename,job FROM employee ;";
			
			//结果集，用来保存获取的结果集
			ResultSet rs = st.executeQuery(sql);
			
			  System.out.println("-----------------");
			  System.out.println("执行结果如下所示:");  
			  System.out.println("-----------------");  
			 
			  System.out.println("编号" + "\t" + "姓名" + "\t" + "工作");
			  System.out.println("-----------------"); 
					
			  BigDecimal employeeno ;
			  String ename = null;
			  String job = null;
			  
			  while(rs.next())
			  {
				  employeeno = rs.getBigDecimal("employeeno");
				  ename = rs.getString("ename");
				  job = rs.getString("job");
				  
				  System.out.println(employeeno + "\t" + ename + "\t" + job);
			  }
			  
			  rs.close();
			  conn.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
