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

import AllEntities.Customer;
import AllEntities.Farmer;

public class CustomerForm implements ActionListener{
	JFrame frame;////CustomerID	Name	Contact	Address

    JLabel cusid_lb=new JLabel("CustomerID");
	JLabel name_lb=new JLabel("Name");
	JLabel contct_lb=new JLabel("Contact");
	JLabel adrss_lb=new JLabel("Address");
	
    JTextField cusid_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField contct_txf=new JTextField();
	JTextField adrss_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public CustomerForm(){
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
		frame.setTitle("CUSTOMER FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.yellow);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		cusid_lb.setBounds(10,10,130,30);
		name_lb.setBounds(10,50,130,30);
		contct_lb.setBounds(10,90,150,30);
		adrss_lb.setBounds(10,130,200,30);
		
		cusid_txf.setBounds(150,10,190,30);
		name_txf.setBounds(150,50,190,30);
		contct_txf.setBounds(150,90,190,30);
		adrss_txf.setBounds(150,130,190,30);
		
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
		cusid_lb.setFont(font);
		name_lb.setFont(font);
		contct_lb.setFont(font);
		adrss_lb.setFont(font);
		
	    cusid_txf.setFont(font);
		name_txf.setFont(font);
		contct_txf.setFont(font);
		adrss_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(cusid_lb);
		frame.add(name_lb);
		frame.add(contct_lb);
		frame.add(adrss_lb);
		
		
		frame.add(cusid_txf);
		frame.add(name_txf);
		frame.add(contct_txf);
		frame.add(adrss_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Customer cs=new Customer();
		if(e.getSource()==insert_btn) {
			
            cs.setName(name_txf.getText());
			cs.setContct(contct_txf.getText());
			cs.setAdrss(adrss_txf.getText());
		    cs.insertData();
			
		}else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("CustomerID");
            model.addColumn("Name");
            model.addColumn("Contact");
            model.addColumn("Address");
            
           
           ResultSet resultSet =Customer.viewData();
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
			int id=Integer.parseInt(cusid_txf.getText());
			
			cs.setName(name_txf.getText());
			cs.setContct(contct_txf.getText());
			cs.setAdrss(adrss_txf.getText());
			cs.update(id);
	    }
	  else {
			int id=Integer.parseInt(cusid_txf.getText());
			cs.delete(id);}

	  }
	public static void main(String[] args) {
		CustomerForm CSf= new CustomerForm();
		System.out.println(CSf);


	}

}

