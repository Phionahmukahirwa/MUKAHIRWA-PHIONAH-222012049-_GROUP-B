package ALLForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import AllEntities.Cattle;

public class CattleForm implements ActionListener{
	JFrame frame;//CattleID	FarmerID	Breed	Age
   
    JLabel cattleid_lb=new JLabel("CattleID");
	JLabel farmid_lb=new JLabel("FarmerID");
	JLabel breed_lb=new JLabel("Breed");
	JLabel age_lb=new JLabel("Age");
	
    JTextField cattleid_txf=new JTextField();
	JTextField farmid_txf=new JTextField();
	JTextField breed_txf=new JTextField();
	JTextField age_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public CattleForm(){
		createForm();
	    }
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
		}
	
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("CATTLE FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		cattleid_lb.setBounds(10,10,130,30);
		farmid_lb.setBounds(10,50,130,30);
		breed_lb.setBounds(10,90,150,30);
		age_lb.setBounds(10,130,200,30);
		
		cattleid_txf.setBounds(150,10,190,30);
		farmid_txf.setBounds(150,50,190,30);
		breed_txf.setBounds(150,90,190,30);
		age_txf.setBounds(150,130,190,30);
		
	
        insert_btn.setBounds(10,220,85,30);
		read_btn.setBounds(110,220,85,30);
		update_btn.setBounds(210,220,85,30);
		delete_btn.setBounds(310,220,85,30);
		
		table.setBounds(500, 10, 600, 240);
		setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		cattleid_lb.setFont(font);
		farmid_lb.setFont(font);
		breed_lb.setFont(font);
		age_lb.setFont(font);
		
		cattleid_txf.setFont(font);
		farmid_txf.setFont(font);
		breed_txf.setFont(font);
		age_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(cattleid_lb);
		frame.add(farmid_lb);
		frame.add(breed_lb);
		frame.add(age_lb);
		
		
		frame.add(cattleid_txf);
		frame.add(farmid_txf);
		frame.add(breed_txf);
		frame.add(age_txf);
		

		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Cattle ct=new Cattle();
		if(e.getSource()==insert_btn) {
			
            ct.setFarmid(farmid_txf.getText());
			ct.setBreed(breed_txf.getText());
			ct.setAge(age_txf.getText());
		    ct.insertData();
			
		}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("CattleID");
            model.addColumn("FarmerID");
            model.addColumn("Breed");
            model.addColumn("Age");
           
     
        	ResultSet resultSet =Cattle.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(cattleid_txf.getText());
			
			ct.setFarmid(farmid_txf.getText());
			ct.setBreed(breed_txf.getText());
			ct.setAge(age_txf.getText());
            ct.update(id);
	    }
	  else {
			int id=Integer.parseInt(cattleid_txf.getText());
			ct.delete(id);}

	  }
	  public static void main(String[] args) {
		      CattleForm ctf= new CattleForm();
		System.out.println(ctf);


	}

}



