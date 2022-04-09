import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MavenDatabase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/amazon_hr","root","YourDatabasePassword");  
			
			Statement stmt=con.createStatement(); 
			String query = " insert into employees (employee_id, first_name, last_name, job_title, salary, reports_to, office_id)"
			        + " values (?, ?, ?, ?, ?, ?, ?)";
			// create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setInt (1, 12);
		      preparedStmt.setString (2, "Abebe");
		      preparedStmt.setString(3, "Kebede");
		      preparedStmt.setString(4, "Mule Developer");
		      preparedStmt.setInt(5, 1000);
		      preparedStmt.setInt(6, 33391);
		      preparedStmt.setInt(7, 2);
		      

		      // execute the preparedstatement
		      preparedStmt.execute();
			ResultSet rs=stmt.executeQuery("select * from employees");  
			while(rs.next())  
		System.out.println("Employee Id: " + rs.getInt(1)+"  "+ "First Name: " + rs.getString(2)+"  "+ "Last Name: "+rs.getString(3));  	
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}  
	}  
