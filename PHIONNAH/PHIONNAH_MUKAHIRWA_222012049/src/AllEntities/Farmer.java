package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Farmer {//FarmerID	Name	Contact	Address
	private int farmid;
	private String name;
	private String contct;
	private String adrss;
	
	public Farmer() {
	    // Default constructor
      }
	public Farmer(int farmid, String name, String contct,String adrss) {
		super();
		this.farmid=farmid;
		this.name=name;
		this.contct=contct;
		this.adrss=adrss;
		}
	
public int getFarmid() {
		return farmid;
	}
	public void setFarmid(int farmid) {
		this.farmid = farmid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContct() {
		return contct;
	}
	public void setContct(String contct) {
		this.contct = contct;
	}
	public String getAdrss() {
		return adrss;
	}
	public void setAdrss(String adrss) {
		this.adrss = adrss;
	}

  public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO farmer (Name, Contact, Address) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.name);
	       preparedStatement.setString(2, this.contct);
	       preparedStatement.setString(3, this.adrss);
	       
	     
	         // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	        String user = "root";
	        String password = "";

	        String sql = "SELECT * FROM Farmer";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }	public void update(int inputfarmid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/Cphionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE Farmer SET Name=?, Contact=?, Address=?   WHERE FarmerID=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getName());
	          stm.setString(2, this.getContct());
	          stm.setString(3, this.getAdrss()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputfarmid);
	          
	          // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputfarmid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Farmer WHERE FarmerID =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputfarmid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}





