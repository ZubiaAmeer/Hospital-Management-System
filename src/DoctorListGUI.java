import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DoctorListGUI extends JFrame {

    public DoctorListGUI() {
        setTitle("Doctor List");
        setSize(958, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Custom JPanel for background image
        BackgroundPanel backgroundPanel = new BackgroundPanel("path_to_your_image.jpg");
        backgroundPanel.setLayout(null);
        setContentPane(backgroundPanel);

        // Column headers for the table
        String[] columnHeaders = {"Doctor's Name", "Specialization", "Availability", "Licenses", "Contact", "Room Number"};

        // Data model for the table (initially empty)
        DefaultTableModel model = new DefaultTableModel(columnHeaders, 0);
        
                // Home button
                JButton HomeBtn = new JButton("Home");
                HomeBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\home-Icon.png"));
                HomeBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
                HomeBtn.setBounds(10, 10, 93, 21);
                backgroundPanel.add(HomeBtn);
                HomeBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose(); // Close current window
                        HomeGUI homeFrame = new HomeGUI();
                        homeFrame.setVisible(true); // Open HomeGUI
                    }
                });

        // JTable to display doctor information
        JTable doctorTable = new JTable(model);
        doctorTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        // JScrollPane to add a scrollbar for the table
        JScrollPane scrollPane = new JScrollPane(doctorTable);
        scrollPane.setBounds(30, 100, 890, 350);
        backgroundPanel.add(scrollPane);

        // Button to load doctor data from the file
        JButton btnLoadData = new JButton("Load Doctor Data");
        btnLoadData.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnLoadData.setBounds(340, 480, 250, 50);
        btnLoadData.setBackground(new Color(135, 206, 235)); // Light blue color
        btnLoadData.setForeground(Color.BLACK);
        backgroundPanel.add(btnLoadData);

        // Action listener for the "Load Doctor Data" button
        btnLoadData.addActionListener(e -> {
            model.setRowCount(0); // Clear the existing rows in the table

            // Read the data from the file and populate the table
            try (BufferedReader reader = new BufferedReader(new FileReader("availableStuff.txt"))) {
                String line;
                String[] doctorData = new String[6];
                int index = 0;

                while ((line = reader.readLine()) != null) {
                    // If we encounter a separator line, it indicates the end of the current doctor's info
                    if (line.trim().equals("---------------------------------------------------")) {
                        if (index == 6) {
                            model.addRow(doctorData);
                        }
                        index = 0; // Reset index
                    } else {
                        doctorData[index] = line;
                        index++;
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading doctor data from file.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        // Title Label
        JLabel titleLabel = new JLabel("Doctor List & Available Stuff", SwingConstants.CENTER);
        titleLabel.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\Doctor2.png"));
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titleLabel.setBounds(320, 30, 382, 50); // Positioning the title
        backgroundPanel.add(titleLabel);

        // Background image
        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\doctorsListPage.png"));
        lblNewLabel.setBounds(10, 0, 924, 553);
        backgroundPanel.add(lblNewLabel);

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DoctorListGUI frame = new DoctorListGUI();
            frame.setVisible(true);
        });
    }

    // Custom JPanel for background image
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            this.backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
