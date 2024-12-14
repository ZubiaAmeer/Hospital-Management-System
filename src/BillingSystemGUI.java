import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillingSystemGUI extends JFrame {
    public BillingSystemGUI() {
        // Set up the JFrame properties
        setTitle("Hospital Billing System");
        getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 14));
        setSize(1055, 779); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Title Header
        JLabel titleHeader = new JLabel("Billing System");
        titleHeader.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\bill.png"));
        titleHeader.setFont(new Font("Times New Roman", Font.BOLD, 32));
        titleHeader.setBounds(394, 52, 276, 64);
        getContentPane().add(titleHeader);

        // Home Button
        JButton HomeBtn = new JButton("Home");
        HomeBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\home-Icon.png"));
        HomeBtn.setBackground(new Color(255, 255, 255));
        HomeBtn.setForeground(new Color(0, 0, 0));
        HomeBtn.setFont(new Font("Times New Roman", Font.BOLD, 14));
        HomeBtn.setBounds(25, 14, 100, 30);
        getContentPane().add(HomeBtn);
        HomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the HomeGUI window
                HomeGUI homeFrame = new HomeGUI();
                homeFrame.setVisible(true);
                dispose(); // Close the current BillingSystemGUI window
            }
        });

        // Patient ID
        JLabel lblPatientID = new JLabel("Patient ID:");
        lblPatientID.setForeground(new Color(0, 0, 0));
        lblPatientID.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblPatientID.setBounds(195, 126, 151, 43);
        JTextField txtPatientID = new JTextField(20);
        txtPatientID.setFont(new Font("Times New Roman", Font.BOLD, 14));
        txtPatientID.setBounds(396, 126, 238, 43);
        getContentPane().add(lblPatientID);
        getContentPane().add(txtPatientID);

        // Patient Name
        JLabel lblPatientName = new JLabel("Patient Name:");
        lblPatientName.setForeground(new Color(0, 0, 0));
        lblPatientName.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblPatientName.setBounds(195, 226, 116, 25);
        JTextField txtPatientName = new JTextField(20);
        txtPatientName.setFont(new Font("Times New Roman", Font.BOLD, 14));
        txtPatientName.setBounds(398, 217, 236, 43);
        getContentPane().add(lblPatientName);
        getContentPane().add(txtPatientName);

        // Service Cost
        JLabel lblServiceCost = new JLabel("Service Cost:");
        lblServiceCost.setForeground(new Color(0, 0, 0));
        lblServiceCost.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblServiceCost.setBounds(195, 318, 130, 25);
        JTextField txtServiceCost = new JTextField(10);
        txtServiceCost.setFont(new Font("Times New Roman", Font.BOLD, 14));
        txtServiceCost.setBounds(396, 306, 236, 49);
        getContentPane().add(lblServiceCost);
        getContentPane().add(txtServiceCost);

        // Medication Cost
        JLabel lblMedicationCost = new JLabel("Medication Cost:");
        lblMedicationCost.setForeground(new Color(0, 0, 0));
        lblMedicationCost.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblMedicationCost.setBounds(195, 407, 151, 25);
        JTextField txtMedicationCost = new JTextField(10);
        txtMedicationCost.setFont(new Font("Times New Roman", Font.BOLD, 14));
        txtMedicationCost.setBounds(394, 398, 238, 43);
        getContentPane().add(lblMedicationCost);
        getContentPane().add(txtMedicationCost);

        // Total Cost
        JLabel lblTotalCost = new JLabel("Total Cost:");
        lblTotalCost.setForeground(new Color(0, 0, 0));
        lblTotalCost.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblTotalCost.setBounds(195, 497, 100, 25);
        JTextField txtTotalCost = new JTextField(10);
        txtTotalCost.setFont(new Font("Times New Roman", Font.BOLD, 14));
        txtTotalCost.setBounds(396, 488, 238, 43);
        txtTotalCost.setEditable(false);
        getContentPane().add(lblTotalCost);
        getContentPane().add(txtTotalCost);

        // Calculate Button
        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setForeground(new Color(0, 0, 0));
        btnCalculate.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\calculate.png"));
        btnCalculate.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnCalculate.setBounds(425, 594, 166, 59);
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double serviceCost = Double.parseDouble(txtServiceCost.getText());
                    double medicationCost = Double.parseDouble(txtMedicationCost.getText());
                    double totalCost = serviceCost + medicationCost;
                    txtTotalCost.setText(String.format("PKR %.2f", totalCost));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BillingSystemGUI.this, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        getContentPane().add(btnCalculate);

        // Background Image
        JLabel background = new JLabel("");
        background.setForeground(new Color(255, 255, 255));
        background.setFont(new Font("Times New Roman", Font.BOLD, 14));
        background.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\paymentPage.png"));
        background.setBounds(-8, 7, 1039, 725);
        getContentPane().add(background);

        // Center the window
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Set up and show the BillingSystemGUI frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BillingSystemGUI billingSystem = new BillingSystemGUI();
                billingSystem.setVisible(true);
            }
        });
    }
}
