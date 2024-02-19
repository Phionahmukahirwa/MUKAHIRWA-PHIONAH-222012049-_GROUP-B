package AllEntities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Animals_Available {//animal_id	animal_name	quantity_available	
    private int anid;
	private String anname;
	private String qtyavlble;
	
public Animals_Available() {
	// constructor
}

public Animals_Available(int anid, String anname, String qtyavlble) {
		super();
		this.anid=anid;
		this.anname=anname;
		this.qtyavlble=qtyavlble;
		}
	
	public int getAnid() {
		return anid;
	}
	public void setAnid(int anid) {
		this.anid = anid;
	}
	public String getAnname() {
		return anname;
	}
	public void setAnname(String anname) {
		this.anname = anname;
	}
	public String getQtyavlble() {
		return qtyavlble;
	}
	public void setQtyavlble(String qtyavlble) {
		this.qtyavlble = qtyavlble;
	}

	public void makeconnection() {
	}
		public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO animals_available (animal_name,	quantity_available) VALUES (?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       //preparedStatement.setString(1, this.actid);
	       
	       preparedStatement.setString(1, this.anname);
	       preparedStatement.setString(2, this.qtyavlble);
	     
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

	        String sql = "SELECT * FROM animals_available";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	public void update(int inputanid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE animals_available SET animal_name=?,	quantity_available=?   WHERE animal_id	=?";

	    try (   
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getAnname());
	          stm.setString(2, this.getQtyavlble());
	         // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(4, inputanid);
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
	public void delete(int inputanid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/phionnah_mukahirwa_cth";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM animals_available WHERE animal_id =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputanid); // Assuming there is a column named 'id' for the WHERE clause

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

