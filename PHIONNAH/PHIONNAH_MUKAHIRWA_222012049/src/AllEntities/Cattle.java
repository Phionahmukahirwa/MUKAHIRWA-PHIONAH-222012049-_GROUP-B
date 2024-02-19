package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Cattle {//CattleID	FarmerID	Breed	Age
	private int cattleid;
	private String farmid;
	private String breed;
	private String age;
	
	public Cattle() {
	    // Default constructor
      }
	public Cattle(int cattleid, String farmid, String breed,String age) {
		super();
		this.cattleid=cattleid;
		this.farmid=farmid;
		this.breed=breed;
		this.age=age;
		}
	public int getCattleid() {
		return cattleid;
	}
	public void setCattleid(int cattleid) {
		this.cattleid = cattleid;
	}
	public String getFarmid() {
		return farmid;
	}
	public void setFarmid(String farmid) {
		this.farmid = farmid;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

    public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO Cattle (FarmerID,	Breed,	Age) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.farmid);
	       preparedStatement.setString(2, this.breed);
	       preparedStatement.setString(3, this.age);
	       
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

	        String sql = "SELECT * FROM Cattle";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	public void update(int inputcattleid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE Cattle SET FarmerID=?, Breed=?, Age=?   WHERE CattleID=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getFarmid());
	          stm.setString(2, this.getBreed());
	          stm.setString(3, this.getAge()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputcattleid);
	      
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
	public void delete(int inputcattleid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Cattle WHERE CattleID =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputcattleid); // Assuming there is a column named 'id' for the WHERE clause

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








