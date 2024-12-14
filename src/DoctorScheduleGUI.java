import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DoctorScheduleGUI extends JFrame {

    public DoctorScheduleGUI() {
        setTitle("Doctor Schedule & Profile");
        setSize(931, 731);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Custom JPanel for background image
        BackgroundPanel backgroundPanel = new BackgroundPanel("path_to_your_image.jpg");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        JButton HomeBtn = new JButton("Home");
        HomeBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\home-Icon.png"));
        HomeBtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
        HomeBtn.setBounds(43, 10, 116, 25);
        backgroundPanel.add(HomeBtn);
        HomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close DoctorScheduleGUI
                HomeGUI homeFrame = new HomeGUI();
                homeFrame.setVisible(true); // Open HomeGUI
            }
        });

        // Title Label
        JLabel titleLabel = new JLabel("Doctor Schedule & Profile", SwingConstants.CENTER);
        titleLabel.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\Doctor1.png"));
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titleLabel.setBounds(86, 47, 700, 50); // Centered title
        backgroundPanel.add(titleLabel);

        // Doctor Name
        JLabel lblDoctorName = new JLabel("Doctor Name:");
        lblDoctorName.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblDoctorName.setBounds(169, 124, 150, 25);
        JTextField txtDoctorName = new JTextField(20);
        txtDoctorName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        txtDoctorName.setBounds(329, 124, 400, 25);
        backgroundPanel.add(lblDoctorName);
        backgroundPanel.add(txtDoctorName);

        // Specialization
        JLabel lblSpecialization = new JLabel("Specialization:");
        lblSpecialization.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblSpecialization.setBounds(169, 180, 150, 25);
        JTextField txtSpecialization = new JTextField(20);
        txtSpecialization.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        txtSpecialization.setBounds(329, 181, 400, 25);
        backgroundPanel.add(lblSpecialization);
        backgroundPanel.add(txtSpecialization);

        // Licenses
        JLabel lblLicenses = new JLabel("Licenses:");
        lblLicenses.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblLicenses.setBounds(169, 226, 150, 25);
        JTextField txtLicenses = new JTextField(20);
        txtLicenses.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        txtLicenses.setBounds(329, 227, 400, 25);
        backgroundPanel.add(lblLicenses);
        backgroundPanel.add(txtLicenses);

        // Contact
        JLabel lblContact = new JLabel("Contact:");
        lblContact.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblContact.setBounds(169, 274, 150, 25);
        JTextField txtContact = new JTextField(20);
        txtContact.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        txtContact.setBounds(329, 275, 400, 25);
        backgroundPanel.add(lblContact);
        backgroundPanel.add(txtContact);

        // Room Number
        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblRoomNumber.setBounds(169, 332, 150, 25);
        JTextField txtRoomNumber = new JTextField(20);
        txtRoomNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        txtRoomNumber.setBounds(329, 333, 400, 25);
        backgroundPanel.add(lblRoomNumber);
        backgroundPanel.add(txtRoomNumber);

        // Availability
        JLabel lblAvailability = new JLabel("Availability:");
        lblAvailability.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblAvailability.setBounds(169, 386, 150, 25);
        JTextField txtAvailability = new JTextField(20);
        txtAvailability.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        txtAvailability.setBounds(329, 387, 400, 25);
        backgroundPanel.add(lblAvailability);
        backgroundPanel.add(txtAvailability);

        JButton btnCheckSchedule = new JButton("Check Availability time");
        btnCheckSchedule.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\check.png"));
        btnCheckSchedule.setBounds(143, 524, 255, 51);
        btnCheckSchedule.setFont(new Font("Arial", Font.BOLD, 14));
        btnCheckSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorName = txtDoctorName.getText().trim();
                JOptionPane.showMessageDialog(null, "Doctor Availability: " + txtAvailability.getText(),
                        "Schedule Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        backgroundPanel.add(btnCheckSchedule);

        JButton btnSave = new JButton("Save Doctor Info");
        btnSave.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\save.png"));
        btnSave.setBounds(486, 524, 243, 51);
        btnSave.setFont(new Font("Arial", Font.BOLD, 14));
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorName = txtDoctorName.getText().trim();
                if (!doctorName.isEmpty()) {
                    // Create doctor info string with the correct order of fields
                    String doctorInfo = doctorName + "\n" +  // Doctor's Name
                            txtSpecialization.getText() + "\n" +  // Specialization
                            txtAvailability.getText() + "\n" +  // Availability
                            txtLicenses.getText() + "\n" +  // Licenses
                            txtContact.getText() + "\n" +  // Contact
                            txtRoomNumber.getText() + "\n" +  // Room Number
                            "---------------------------------------------------\n";  // separator between doctors' data

                    // Write the doctor info to "availableStuff.txt"
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("availableStuff.txt", true))) {
                        writer.write(doctorInfo);
                        JOptionPane.showMessageDialog(null, "Doctor information saved successfully.", "Save Info", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "An error occurred while saving the doctor information.", "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a doctor name.", "Save Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        backgroundPanel.add(btnSave);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\DoctorSchedulePage.png"));
        lblNewLabel.setBounds(10, 0, 897, 684);
        backgroundPanel.add(lblNewLabel);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DoctorScheduleGUI frame = new DoctorScheduleGUI();
            frame.setVisible(true);
        });
    }
}

// Custom JPanel for background image
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
