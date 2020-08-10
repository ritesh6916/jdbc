package jdbc_oracle;
import java.sql.*;
import java.util.Scanner;
public class Insert_Into 
{

	public static void main(String args[]) 
	{
		try 
		{   
			Scanner s=new Scanner(System.in);
			System.out.println("enter id");
			int id=s.nextInt();
			System.out.println("enter first name");
			String fn=s.next();
			System.out.println("enter last name");
			String ln=s.next();
			s.close();
			String query="insert into Student values ("+id+",'"+fn+"'"+",'"+ln+"')";
			System.out.println(query);
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,"RITESH", "Ritesh6916"); 
			Statement st=con.createStatement();
			int count=st.executeUpdate(query);
			System.out.println(count+" row effected");
			st.close();
			con.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver not loaded");
		}
		catch(SQLException e)
		{
			System.out.println("fail to connect with oracle");
		}
		catch(Exception e)
		{
			System.out.println("other problem");
		}
		
	}
}