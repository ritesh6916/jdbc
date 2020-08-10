package jdbc_oracle;
import java.sql.*;
public class Jdbc_Oracle {
	public static void main(String args[])
	{
		try
		{
			String query="select * from Student";
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,"RITESH", "Ritesh6916"); 
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				String userdata="id= "+rs.getInt(1)+" name:- "+rs.getString(2)+" "+rs.getString(3);
				System.out.println(userdata);
			}
			con.close();
			st.close();
		}
		catch(SQLException e)
		{
			System.out.println("connection is not established");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Driver not loaded");
		}
		catch(Exception e)
		{
			System.out.println("Other problem");
		}
	}
}