package MenU;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ALLForms.Animals_AvailableForm;
import ALLForms.CattleForm;
import ALLForms.CustomerForm;
import ALLForms.FarmerForm;
import ALLForms.PaymentForm;
import ALLForms.TransactionForm;

public class MenuForm extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Animals_Availablemenu;
    private JMenu Cattlemenu;
    private JMenu Customermenu;
    private JMenu Farmermenu;
    private JMenu Paymentmenu;
    private JMenu Transactionmenu;
    private JMenu Logoutmenu;
    
    public MenuForm() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem Animals_AvailableItem;
    private JMenuItem CattleItem;
    private JMenuItem CustomerItem;
    private JMenuItem FarmerItem;
    private JMenuItem PaymentItem;
    private JMenuItem TransactionItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public MenuForm(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Animals_Availablemenu = new JMenu("Animals_Available");
        Cattlemenu = new JMenu("Cattle");
        Customermenu= new JMenu("Customer");
        Farmermenu = new JMenu("Farmer ");
        Paymentmenu = new JMenu("Payment");
        Transactionmenu = new JMenu("Transaction");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(Animals_Availablemenu);
        Animals_AvailableItem = new JMenuItem("Animals_AvailableForm");
        Animals_AvailableItem.addActionListener(this);
        
        menuBar.add(Cattlemenu);
        CattleItem = new JMenuItem("CattleForm");
        CattleItem.addActionListener(this);
        
        menuBar.add(Customermenu);
        CustomerItem = new JMenuItem("CustomerForm");
        CustomerItem.addActionListener(this);
        
        menuBar.add(Farmermenu);
        FarmerItem = new JMenuItem("FarmerForm");
        FarmerItem.addActionListener(this);
        
        menuBar.add(Paymentmenu);
        PaymentItem = new JMenuItem("PaymentForm");
        PaymentItem.addActionListener(this);
        
        menuBar.add(Transactionmenu);
        TransactionItem = new JMenuItem("TransactionForm");
        TransactionItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Animals_Availablemenu.add(Animals_AvailableItem);
        Cattlemenu.add(CattleItem);
        Customermenu.add(CustomerItem);
        Farmermenu.add(FarmerItem);
        Paymentmenu.add(PaymentItem);
        Transactionmenu.add(TransactionItem);
        
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Animals_AvailableItem) {
            new Animals_AvailableForm();
        
        } else if (e.getSource() == CattleItem) {
            new CattleForm();
        
        } else if (e.getSource() == CustomerItem) {
            new CustomerForm();
       
        } else if (e.getSource() == FarmerItem) {
           new FarmerForm();
        
        } else if (e.getSource() == PaymentItem) {
           new PaymentForm();
           
        } else if (e.getSource() == TransactionItem) {
            new TransactionForm();
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuForm("TO CATTLE TRADE HUB SYSTEM"));
    }
}





