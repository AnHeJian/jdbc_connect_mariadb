package seu.database.hello;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;

public class connect 
{
	public static void main(String[] args) {
		Connection conn ;
		//����������
		String driver = "com.mysql.jdbc.Driver";
		
		//URLָ��Ҫ���ʵ����ݿ���
		String url = "jdbc:mysql://192.168.99.100:3306/company";
		
		String user = "admin";
		String psw = "123456";
		
		try
		{
			//������������
			Class.forName(driver);
			//getConnection()����������MySQL���ݿ�
			conn = DriverManager.getConnection(url, user, psw);
			
			if(!conn.isClosed())
				System.out.println("���ӳɹ�");
			
			//����statement���������ִ��SQL���
			Statement st = conn.createStatement();
			
			//Ҫִ�е�sql���
			String sql = "SELECT employeeno,ename,job FROM employee ;";
			
			//����������������ȡ�Ľ����
			ResultSet rs = st.executeQuery(sql);
			
			  System.out.println("-----------------");
			  System.out.println("ִ�н��������ʾ:");  
			  System.out.println("-----------------");  
			 
			  System.out.println("���" + "\t" + "����" + "\t" + "����");
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
