package pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DCode {
	
	//--------------------CONNECTION----------------------
	
	private static Connection con;
	DCode() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/hms","root","Jayakr2002*");
	}
	
	
	//---------------------HOSPITAL----------------------
	
	
	public boolean hlogin(String name,String pass) throws SQLException
	{
		String q="select*from hlogin";
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(q);
		while(rs.next())
		{
			if(name.equals(rs.getString("name")) && pass.equals(rs.getString("pass")))
			{
				return true;
			}
		}
		return false;
		
	}
		
	
	public int insert(int H_ID, String City,String H_Name,int P_ID,int D_ID) throws SQLException
	{
		String q="insert into hospital values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1, H_ID);
		ps.setString(2, City);
		ps.setString(3, H_Name);
		ps.setInt(4, P_ID);
		ps.setInt(5, D_ID);
		
		return ps.executeUpdate();
	}
	public void view() throws SQLException
	{
		String q="select*from hospital";
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(q);
		while(rs.next())
		{
			System.out.println(rs.getInt("H_ID")+"\t"+rs.getString("City")+"\t"+rs.getString("H_Name")+"\t"+rs.getInt("P_ID")+"\t"+rs.getInt("D_ID"));
		}
	}
	public int update(String City,int H_ID) throws SQLException
	{
		String q="update hospital set City=? where H_ID=?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(2,H_ID);
		ps.setString(1, City);
		return ps.executeUpdate();
	}
	public int delete(int H_ID) throws SQLException
	{
		String q="delete from hospital where H_ID=?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setInt(1,H_ID);
		return ps.executeUpdate();
	}
	public void conclose() throws SQLException
	{
		con.close();
	}

	
	
	//-------------------------PATIENT-------------------------
	
	
	
	public boolean plogin(String name,String pass) throws SQLException
	{
		String q="select*from plogin";
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(q);
		while(rs.next())
		{
			if(name.equals(rs.getString("name")) && pass.equals(rs.getString("pass")))
			{
				return true;
			}
		}
		return false;
		
	}
	
	
	public int insert1(int R_ID,String Diagnosis,String P_Name,int P_ID,int Age,String Address) throws SQLException
	{
		String q="insert into patient values(?,?,?,?,?,?)";
		PreparedStatement p=con.prepareStatement(q);
		p.setInt(1,P_ID);
		p.setString(2,P_Name);
		p.setString(3,Address);
		p.setString(4,Diagnosis);
		p.setInt(5,R_ID);
		p.setInt(6,Age);
		return p.executeUpdate();	
	}
	
	public int update1(String Diagnosis,int P_ID) throws SQLException
	{
		String q="update patient set Diagnosis=? where P_ID=?";
		PreparedStatement p=con.prepareStatement(q);
		p.setInt(2,P_ID);
		p.setString(1,Diagnosis);
		return p.executeUpdate();
	}
	
	public void view1() throws SQLException
	{
		String q="select*from patient";
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(q);
		while(rs.next())
		{
			System.out.println(rs.getInt("P_ID")+"\t"+rs.getString("P_Name")+"\t"+rs.getInt("Age")+"\t"+rs.getString("Diagnosis")+"\t"+rs.getString("Address")+"\t"+rs.getInt("R_ID"));
		}
	}
	
	public int delete1(int P_ID) throws SQLException
	{
		String q="delete from patient where P_ID=?";
		PreparedStatement p=con.prepareStatement(q);
		p.setInt(1, P_ID);
		return p.executeUpdate();
	}
	
	public void conclose1() throws SQLException
	{
		con.close();
	}
	
 }




