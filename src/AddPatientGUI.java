import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;

public class AddPatientGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField recieveName;
    private JTextField recieveCNIC;
    private JTextField recieveDOB;
    private JTextField recieveGender;
    private JTextField recieveContact;
    private JTextField recieveHistory;
    private DefaultTableModel tableModel;
    private JTable table;
    private ArrayList<Patient> patientsList = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddPatientGUI frame = new AddPatientGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddPatientGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1029, 712);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Times New Roman", Font.BOLD, 23));
        gender.setBounds(490, 356, 95, 21);
        contentPane.add(gender);

        JButton HomeBtn = new JButton("Home");
        HomeBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\home-Icon.png"));
        HomeBtn.setFont(new Font("Times New Roman", Font.BOLD, 11));
        HomeBtn.setBounds(47, 21, 85, 21);
        contentPane.add(HomeBtn);
        HomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddPatientGUI.this.dispose();
                // Assuming HomeGUI is another frame to navigate back
                HomeGUI homeFrame = new HomeGUI();
                homeFrame.setVisible(true);
            }
        });

        recieveName = new JTextField();
        recieveName.setBounds(633, 178, 146, 33);
        contentPane.add(recieveName);
        recieveName.setColumns(10);

        recieveCNIC = new JTextField();
        recieveCNIC.setColumns(10);
        recieveCNIC.setBounds(633, 235, 146, 33);
        contentPane.add(recieveCNIC);

        recieveDOB = new JTextField();
        recieveDOB.setColumns(10);
        recieveDOB.setBounds(633, 289, 146, 33);
        contentPane.add(recieveDOB);

        recieveGender = new JTextField();
        recieveGender.setColumns(10);
        recieveGender.setBounds(633, 346, 146, 33);
        contentPane.add(recieveGender);

        recieveContact = new JTextField();
        recieveContact.setColumns(10);
        recieveContact.setBounds(633, 397, 146, 33);
        contentPane.add(recieveContact);

        recieveHistory = new JTextField();
        recieveHistory.setColumns(10);
        recieveHistory.setBounds(633, 464, 221, 105);
        contentPane.add(recieveHistory);

        JButton save = new JButton("Save");
        save.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\save.png"));
        save.setBackground(new Color(255, 255, 255));
        save.setFont(new Font("Times New Roman", Font.BOLD, 18));
        save.setBounds(628, 602, 134, 44);
        contentPane.add(save);

        // Adjusted table setup
        String[] columnNames = {"Name", "Date of Birth"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(28, 115, 452, 518);
        contentPane.add(scrollPane);

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (recieveName.getText().trim().isEmpty() || recieveCNIC.getText().trim().isEmpty() ||
                    recieveDOB.getText().trim().isEmpty() || recieveGender.getText().trim().isEmpty() ||
                    recieveContact.getText().trim().isEmpty() || recieveHistory.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(AddPatientGUI.this, "Enter all data!");
                } else {
                    Patient newPatient = new Patient(
                        recieveName.getText(),
                        recieveCNIC.getText(),
                        recieveDOB.getText(),
                        recieveGender.getText(),
                        recieveContact.getText(),
                        recieveHistory.getText(), null
                    );
                    patientsList.add(newPatient);

                    JOptionPane.showMessageDialog(AddPatientGUI.this, "Data added successfully!");

                    recieveName.setText("");
                    recieveCNIC.setText("");
                    recieveDOB.setText("");
                    recieveGender.setText("");
                    recieveContact.setText("");
                    recieveHistory.setText("");

                    updatePatientTable();
                    savePatientToFile(newPatient);
                }
            }
        });

        JLabel history = new JLabel("History:");
        history.setFont(new Font("Times New Roman", Font.BOLD, 23));
        history.setBounds(490, 469, 87, 27);
        contentPane.add(history);

        JLabel contact = new JLabel("Contact:");
        contact.setFont(new Font("Times New Roman", Font.BOLD, 23));
        contact.setBounds(490, 402, 126, 33);
        contentPane.add(contact);

        JLabel DoB = new JLabel("Date of Birth:");
        DoB.setFont(new Font("Times New Roman", Font.BOLD, 20));
        DoB.setBounds(490, 291, 133, 25);
        contentPane.add(DoB);

        JLabel cnic = new JLabel("CNIC:");
        cnic.setFont(new Font("Times New Roman", Font.BOLD, 23));
        cnic.setBounds(490, 240, 109, 21);
        contentPane.add(cnic);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Times New Roman", Font.BOLD, 23));
        name.setBounds(490, 182, 95, 30);
        contentPane.add(name);

        JLabel title = new JLabel("Add Patient");
        title.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\addPatient.png"));
        title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        title.setBounds(545, 63, 283, 44);
        contentPane.add(title);
        
        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\AddPatientPage.png"));
        background.setBounds(7, 6, 996, 659);
        contentPane.add(background);
    }

    private void updatePatientTable() {
        tableModel.setRowCount(0);
        for (Patient patient : patientsList) {
            Object[] row = {
                patient.getName(),   // "Date of Birth" column contains Name
                patient.getAge()     // "Name" column contains Date of Birth
            };
            tableModel.addRow(row);
        }
    }

    private void savePatientToFile(Patient patient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("savedPatients.txt", true))) {
            writer.write(patient.getName() + "|" +
                         patient.getCnic() + "|" +
                         patient.getAge() + "|" +
                         patient.getGender() + "|" +
                         patient.getContact() + "|" +
                         patient.getHistory() + "|" +
                         new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data to file!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Not used in this example
    }
}
