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

import AllEntities.Payment;

public class PaymentForm implements ActionListener{
	JFrame frame;//Payment_id	TransactionID	Payment_method
	
	JLabel pymntid_lb=new JLabel("Payment_id");
	JLabel trnid_lb=new JLabel("TransactionID");
	JLabel pymthd_lb=new JLabel("Payment_method");
	
	JTextField pymntid_txf=new JTextField();
	JTextField trnid_txf=new JTextField();
	JTextField pymthd_txf=new JTextField();
	
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public PaymentForm(){
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
		frame.setTitle("PAYMENT FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.gray);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		pymntid_lb.setBounds(10,10,170,30);
		trnid_lb.setBounds(10,50,170,30);
		pymthd_lb.setBounds(10,90,170,30);
		
		pymntid_txf.setBounds(170,10,190,30);
		trnid_txf.setBounds(170,50,190,30);
		pymthd_txf.setBounds(170,90,190,30);
		
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
		pymntid_lb.setFont(font);
		trnid_lb.setFont(font);
		pymthd_lb.setFont(font);
		
	    pymntid_txf.setFont(font);
		trnid_txf.setFont(font);
		pymthd_txf.setFont(font);
		
	    Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(pymntid_lb);
		frame.add(trnid_lb);
		frame.add(pymthd_lb);
		
		frame.add(pymntid_txf);
		frame.add(trnid_txf);
		frame.add(pymthd_txf);
		
	    frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		
		frame.add(table);
		ActionEvent ();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Payment PY=new Payment();
		if(e.getSource()==insert_btn) {
			
			PY.setTrnid(trnid_txf.getText());
			PY.setPymthd(pymthd_txf.getText());
			PY.insertData();
			}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("Payment_id");
            model.addColumn("TransactionID");
            model.addColumn("Payment_method");
         
            ResultSet resultSet =Payment.viewData();
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
			int id=Integer.parseInt(pymntid_txf.getText());
			
			PY.setTrnid(trnid_txf.getText());
			PY.setPymthd(pymthd_txf.getText());
			PY.update(id);
	    }
	  else {
			int id=Integer.parseInt(pymntid_txf.getText());
			PY.delete(id);}

	  }
	public static void main(String[] args) {
		PaymentForm PYf= new PaymentForm ();
		System.out.println(PYf);


	}

}


