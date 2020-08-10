package jdbc_oracle;
import java.util.Scanner;
import java.sql.*;
class Find_Details
{
	int id;
	String name;
	Find_Details(int i)
	{
		id=i;
	}
	public void getDetails()
	{
		boolean b;
		try 
		{
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String query="select * from Student where id="+id;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,"RITESH", "Ritesh6916"); 
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			b=rs.next();
			if(b==false)
			{
				System.out.println("id dont match");
			}
			else
			{
			name=rs.getString(2)+" "+rs.getString(3);
			System.out.println("This id("+id+ ") belongs to "+name);
			}
			con.close();
			st.close();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver is not loaded");
		}
		catch(SQLException e)
		{
			System.out.println("Fail to connect with oracle ");
		}
		catch(Exception e)
		{
			System.out.println("other problems");
		}
	}
}
public class Get_Details_By_Id 
{
	public static void main(String[] args) 
	{
		int id;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter id");
		id=s.nextInt();
		s.close();
		Find_Details f=new Find_Details(id);
		f.getDetails();
	}

}

