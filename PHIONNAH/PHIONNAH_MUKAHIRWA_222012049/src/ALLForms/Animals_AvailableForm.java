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

import AllEntities.Animals_Available;

public class Animals_AvailableForm implements ActionListener{
	JFrame frame;//FarmerID	Name	Contact	Address
	
	JLabel anid_lb=new JLabel("animal_id");
	JLabel anname_lb=new JLabel("animal_name");
	JLabel qtyavlble_lb=new JLabel("quantity_available");
	
	
    JTextField anid_txf=new JTextField();
	JTextField anname_txf=new JTextField();
	JTextField qtyavlble_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public Animals_AvailableForm(){
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
		frame.setTitle("Animals_Available Form");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		anid_lb.setBounds(10,10,130,30);
		anname_lb.setBounds(10,50,130,30);
		qtyavlble_lb.setBounds(10,90,150,30);
		
		anid_txf.setBounds(150,10,190,30);
		anname_txf.setBounds(150,50,190,30);
		qtyavlble_txf.setBounds(150,90,190,30);
		
		insert_btn.setBounds(10,210,85,30);
		read_btn.setBounds(110,210,85,30);
		update_btn.setBounds(210,210,85,30);
		delete_btn.setBounds(310,210,85,30);
		
		table.setBounds(500, 10, 600, 240);

	    setFontforall();
		addcomponentforFrame();

		}
	
	private void setFontforall() {
		Font font=new Font("Georgia",Font.BOLD,18);
		anid_lb.setFont(font);
		anname_lb.setFont(font);
		qtyavlble_lb.setFont(font);
		
		anid_txf.setFont(font);
		anname_txf.setFont(font);
		qtyavlble_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(anid_lb);
		frame.add(anname_lb);
		frame.add(qtyavlble_lb);
		
		frame.add(anid_txf);
		frame.add(anname_txf);
		frame.add(qtyavlble_txf);
		
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Animals_Available ana=new Animals_Available();
		if(e.getSource()==insert_btn) {
			ana.setAnname(anname_txf.getText());
			ana.setQtyavlble(qtyavlble_txf.getText());
			ana.insertData();
			}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("animal_id");
            model.addColumn("animal_name");
            model.addColumn("quantity_available");
           
           
            ResultSet resultSet =Animals_Available.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

	    else if (e.getSource()==update_btn) {
			int id=Integer.parseInt(anid_txf.getText());
			ana.setAnname(anname_txf.getText());
			ana.setQtyavlble(qtyavlble_txf.getText());
			ana.update(id);
	    }
	  else {
			int id=Integer.parseInt(anid_txf.getText());
			ana.delete(id);}

	  }
	public static void main(String[] args) {
		Animals_AvailableForm anfm= new Animals_AvailableForm();
		System.out.println(anfm);


	}
}
