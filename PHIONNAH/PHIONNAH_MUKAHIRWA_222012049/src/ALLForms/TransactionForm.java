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

import AllEntities.Transaction;

public class TransactionForm  implements ActionListener{
	JFrame frame;//TransactionID	CattleID	TransactionType	Price
	
	JLabel trnid_lb=new JLabel("TransactionID");
	JLabel cattleid_lb=new JLabel("CattleID");
	JLabel trntype_lb=new JLabel("TransactionType");
	JLabel price_lb=new JLabel("Price");
	
    JTextField trnid_txf=new JTextField();
	JTextField cattleid_txf=new JTextField();
	JTextField trntype_txf=new JTextField();
	JTextField price_txf=new JTextField();
	
	JButton insert_btn=new JButton("INSERT");
	JButton read_btn=new JButton("VIEW");
	JButton update_btn=new JButton("UPDATE");
	JButton delete_btn=new JButton("DELETE");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public TransactionForm(){
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
		frame.setTitle("TRANSACTION FORM");
		frame.setBounds(0, 0 , w / 2, h / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		
		setLocationandSize();
		}
	
	private void setLocationandSize() {
		trnid_lb.setBounds(10,10,170,30);
		cattleid_lb.setBounds(10,50,170,30);
		trntype_lb.setBounds(10,90,170,30);
		price_lb.setBounds(10,130,210,30);
		
		trnid_txf.setBounds(180,10,190,30);
		cattleid_txf.setBounds(180,50,190,30);
		trntype_txf.setBounds(180,90,190,30);
		price_txf.setBounds(180,130,190,30);
		
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
		trnid_lb.setFont(font);
		cattleid_lb.setFont(font);
		trntype_lb.setFont(font);
		price_lb.setFont(font);
		
		trnid_txf.setFont(font);
	    cattleid_txf.setFont(font);
		trntype_txf.setFont(font);
		price_txf.setFont(font);
		
		Font fonti=new Font("Courier New",Font.ITALIC,10);
		insert_btn.setFont(fonti);
		read_btn.setFont(fonti);
		update_btn.setFont(fonti);
		delete_btn.setFont(fonti);
		}
	
	private void addcomponentforFrame() {
		frame.add(trnid_lb);
		frame.add(cattleid_lb);
		frame.add(trntype_lb);
		frame.add(price_lb);
		
		
		frame.add(trnid_txf);
		frame.add(cattleid_txf);
		frame.add(trntype_txf);
		frame.add(price_txf);
	
		frame.add(insert_btn);
		frame.add(read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		frame.add(table);
		ActionEvent ();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Transaction TR=new Transaction();
		if(e.getSource()==insert_btn) {
			
            TR.setCattleid(cattleid_txf.getText());
		    TR.setTrntype(trntype_txf.getText());
			TR.setPrice(price_txf.getText());
		    TR.insertData();
			}
		else if (e.getSource() == read_btn) {
            model.setColumnCount(0);
            model.setRowCount(1);
            model.addColumn("TransactionID");
            model.addColumn("CattleID");
            model.addColumn("TransactionType");
            model.addColumn("Price");
          
            ResultSet resultSet =Transaction.viewData();
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
			int id=Integer.parseInt(trnid_txf.getText());
			
			TR.setCattleid(cattleid_txf.getText());
		    TR.setTrntype(trntype_txf.getText());
			TR.setPrice(price_txf.getText());
			TR.update(id);
	    }
	  else {
			int id=Integer.parseInt(trnid_txf.getText());
			TR.delete(id);}

	  }
	public static void main(String[] args) {
		TransactionForm TRf= new TransactionForm();
		System.out.println(TRf);


	}

}

	
