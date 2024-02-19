package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Transaction {//TransactionID	CattleID	TransactionType	Price
	private int trnid;
	private String cattleid;
	private String trntype;
	private String price;
	
	public Transaction() {
	    // Default constructor
      }
	public Transaction(int trnid, String cattleid, String trntype,String price) {
		super();
		this.trnid=trnid;
		this.cattleid=cattleid;
		this.cattleid=trntype;
		this.price=price;
		}
	

	public int getTrnid() {
		return trnid;
	}
	public void setTrnid(int trnid) {
		this.trnid = trnid;
	}
	public String getCattleid() {
		return cattleid;
	}
	public void setCattleid(String cattleid) {
		this.cattleid = cattleid;
	}
	public String getTrntype() {
		return trntype;
	}
	public void setTrntype(String trntype) {
		this.trntype = trntype;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
  public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO Transaction (CattleID,	TransactionType,	Price) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	     
	       preparedStatement.setString(1, this.cattleid);
	       preparedStatement.setString(2, this.trntype);
	       preparedStatement.setString(3, this.price);
	       
	  
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

	        String sql = "SELECT * FROM Transaction";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	public void update(int inputtrnid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE Transaction SET CattleID=?	TransactionType=?	Price=?   WHERE TransactionID=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getCattleid());
	          stm.setString(2, this.getTrntype());
	          stm.setString(3, this.getPrice()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputtrnid);
	          
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
	public void delete(int inputtrnid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Transaction WHERE TransactionID =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputtrnid); // Assuming there is a column named 'id' for the WHERE clause

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

