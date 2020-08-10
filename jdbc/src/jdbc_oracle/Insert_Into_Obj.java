package jdbc_oracle;
import java.sql.*;
import java.util.Scanner;
class Insert_Object
{
	int id;
	String fn;
	String ln;
	Insert_Object()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("enter id");
		id=s.nextInt();
		System.out.println("enter first name");
		fn=s.next();
		System.out.println("enter last name");
		ln=s.next();
		s.close();
	}
	void getData()
	{
		boolean b;
		try 
		{   
			String query="insert into Student values ("+id+",'"+fn+"'"+",'"+ln+"')";
			String query1="select id from Student where id="+id;
			System.out.println(query);
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,"RITESH", "Ritesh6916"); 
			Statement st1=con.createStatement();
			ResultSet rs=st1.executeQuery(query1);
			b=rs.next();
			if(b==true)
			{
				System.out.println("Id already exist");
				return;
			}
			else
			{
				Statement st=con.createStatement();	
				int count=st.executeUpdate(query);
				System.out.println(count+" row created");
				st.close();
			}
			con.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver not loaded");
		}
		catch(SQLClientInfoException e)
		{
			System.out.println("user information error");
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println("other problem");
		}
	}
}
public class Insert_Into_Obj
{
	public static void main(String args[])
	{
		Insert_Object obj=new Insert_Object();
		obj.getData();
	}
}