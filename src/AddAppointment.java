import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AddAppointment extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField recievePatientID;
    private JTextField RecievePatientName;

    // Lists to store Doctor Names and Specializations
    private List<String> doctorNames = new ArrayList<>();
    private List<String> doctorSpecializations = new ArrayList<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddAppointment frame = new AddAppointment();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AddAppointment() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1052, 733);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Load doctor data from availableStuff.txt to populate drop-downs
        loadDoctorData();

        // ComboBox for Doctor Specialization
        JComboBox<String> DoctorSpecializationSelect_1 = new JComboBox<String>();
        DoctorSpecializationSelect_1.setBounds(449, 320, 164, 30);
        contentPane.add(DoctorSpecializationSelect_1);

        // Populate Specialization ComboBox
        for (String specialization : doctorSpecializations) {
            DoctorSpecializationSelect_1.addItem(specialization);
        }

        // ComboBox for Doctor Name
        JComboBox<String> DoctorNameSelect = new JComboBox<String>();
        DoctorNameSelect.setBounds(449, 270, 158, 30);
        contentPane.add(DoctorNameSelect);

        // Populate Name ComboBox
        for (String name : doctorNames) {
            DoctorNameSelect.addItem(name);
        }

        JButton HomeBtn = new JButton("Home");
        HomeBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\home-Icon.png"));
        HomeBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        HomeBtn.setBounds(10, 0, 112, 34);
        contentPane.add(HomeBtn);
        HomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current AddPatientGUI window
                AddAppointment.this.dispose();

                // Open the HomeGUI window
                HomeGUI homeFrame = new HomeGUI();
                homeFrame.setVisible(true);
            }
        });

        JButton Discardbtn = new JButton("Discard");
        Discardbtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\Discard.png"));
        Discardbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        Discardbtn.setBounds(262, 374, 140, 48);
        contentPane.add(Discardbtn);

        JButton Savebtn = new JButton("Save");
        Savebtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\save.png"));
        Savebtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        Savebtn.setBounds(501, 374, 132, 48);
        contentPane.add(Savebtn);

        // Save Button Logic
        Savebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the data from the text fields and combo boxes
                String patientID = recievePatientID.getText();
                String patientName = RecievePatientName.getText();
                String doctorName = (String) DoctorNameSelect.getSelectedItem();
                String doctorSpecialization = (String) DoctorSpecializationSelect_1.getSelectedItem();

                // Save the data to a text file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("savedAppointments.txt", true))) {
                    writer.write("Patient ID: " + patientID + ", ");
                    writer.write("Patient Name: " + patientName + ", ");
                    writer.write("Doctor Name: " + doctorName + ", ");
                    writer.write("Doctor Specialization: " + doctorSpecialization);
                    writer.newLine();  // New line for the next entry
                    JOptionPane.showMessageDialog(null, "Your appointment is saved successfully!", doctorSpecialization, JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Discard Button Logic
        Discardbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                        // Show a pop-up message
                        JOptionPane.showMessageDialog(null, "Appointment not saved", "Discard", JOptionPane.INFORMATION_MESSAGE);
                        
                        // Clear all the input fields
                        recievePatientID.setText("");
                        RecievePatientName.setText("");
                    }
                });
        
        JLabel SelectDoctorSp = new JLabel("Doctor Specialization");
        SelectDoctorSp.setFont(new Font("Times New Roman", Font.BOLD, 15));
        SelectDoctorSp.setBounds(298, 321, 140, 26);
        contentPane.add(SelectDoctorSp);

        JLabel SelectDoctorName = new JLabel("Doctor Name");
        SelectDoctorName.setFont(new Font("Times New Roman", Font.BOLD, 15));
        SelectDoctorName.setBounds(298, 271, 103, 26);
        contentPane.add(SelectDoctorName);

        JLabel Doctordetail = new JLabel("Doctor");
        Doctordetail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Doctordetail.setBounds(148, 263, 118, 34);
        contentPane.add(Doctordetail);

        RecievePatientName = new JTextField();
        RecievePatientName.setFont(new Font("Tahoma", Font.BOLD, 20));
        RecievePatientName.setBounds(334, 209, 229, 34);
        contentPane.add(RecievePatientName);
        RecievePatientName.setColumns(10);

        JLabel Patientname = new JLabel("Patient Name");
        Patientname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Patientname.setBounds(148, 209, 118, 34);
        contentPane.add(Patientname);

        recievePatientID = new JTextField();
        recievePatientID.setFont(new Font("Times New Roman", Font.BOLD, 20));
        recievePatientID.setBounds(334, 151, 229, 29);
        contentPane.add(recievePatientID);
        recievePatientID.setColumns(10);

        JLabel Patientid = new JLabel("Patient ID");
        Patientid.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Patientid.setBounds(148, 151, 132, 34);
        contentPane.add(Patientid);

        JLabel AddAppointment = new JLabel("Add Appointment");
        AddAppointment.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\appointment1.png"));
        AddAppointment.setFont(new Font("Times New Roman", Font.BOLD, 40));
        AddAppointment.setBounds(279, 81, 422, 48);
        contentPane.add(AddAppointment);

        JLabel Diplay = new JLabel("");
        Diplay.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\appointmentPage.png"));
        Diplay.setBounds(0, 10, 1038, 696);
        contentPane.add(Diplay);
    }

    /**
     * Load the doctor data (names and specializations) from the availableStuff.txt file.
     */
    private void loadDoctorData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("availableStuff.txt"))) {
            String line;
            String[] doctorData = new String[6];
            int index = 0;

            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("---------------------------------------------------")) {
                    // Add the doctor name and specialization to the lists
                    if (index == 6) {
                        doctorNames.add(doctorData[0]);  // Add Doctor Name
                        doctorSpecializations.add(doctorData[1]);  // Add Specialization
                    }
                    index = 0;
                } else {
                    doctorData[index] = line;
                    index++;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
