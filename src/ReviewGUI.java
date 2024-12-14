import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ReviewGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField recieveFeedback;
    private JTextField recieveEmail;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReviewGUI frame = new ReviewGUI();
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
    public ReviewGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1154, 732);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        recieveFeedback = new JTextField();
        recieveFeedback.setBounds(323, 142, 455, 228);
        contentPane.add(recieveFeedback);
        recieveFeedback.setColumns(10);

        recieveEmail = new JTextField();
        recieveEmail.setBounds(323, 436, 455, 39);
        contentPane.add(recieveEmail);
        recieveEmail.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Email:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(365, 392, 338, 34);
        contentPane.add(lblNewLabel_2);

        JButton btnSend = new JButton("Send");
        btnSend.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\send.png"));
        btnSend.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnSend.setBounds(728, 555, 124, 54);
        contentPane.add(btnSend);

        JButton btnDiscard = new JButton("Discard");
        btnDiscard.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\Discard.png"));
        btnDiscard.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnDiscard.setBounds(255, 545, 141, 54);
        contentPane.add(btnDiscard);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\logout-Icon.png"));
        btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnLogout.setBounds(864, 10, 124, 21);
        contentPane.add(btnLogout);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JLabel title = new JLabel("Share your Feedback and Opinion");
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));
        title.setBounds(365, 68, 389, 70);
        contentPane.add(title);

        JButton HomeBtn = new JButton("Home");
        HomeBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\home-Icon.png"));
        HomeBtn.setFont(new Font("Times New Roman", Font.BOLD, 14));
        HomeBtn.setBounds(92, 10, 99, 21);
        contentPane.add(HomeBtn);
        HomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current ReviewGUI window
                ReviewGUI.this.dispose();
                // Open the HomeGUI window
                HomeGUI homeFrame = new HomeGUI();
                homeFrame.setVisible(true);
            }
        });

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\ReviewPage.png"));
        lblNewLabel.setBounds(10, 0, 1120, 695);
        contentPane.add(lblNewLabel);

        // Action listener for Send button
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String feedback = recieveFeedback.getText().trim();
                String email = recieveEmail.getText().trim();
                
                if (!feedback.isEmpty() && !email.isEmpty()) {
                    // Save the review to "sentReviews.txt"
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("sentReviews.txt", true))) {
                        writer.write("Feedback: " + feedback + "\nEmail: " + email + "\n---------------------------------\n");
                        JOptionPane.showMessageDialog(ReviewGUI.this, "Review sent", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(ReviewGUI.this, "Error saving review", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Clear the fields after sending the review
                    recieveFeedback.setText("");
                    recieveEmail.setText("");
                } else {
                    JOptionPane.showMessageDialog(ReviewGUI.this, "Please fill all the review form", "Input Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Action listener for Discard button
        btnDiscard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the text fields
                recieveFeedback.setText("");
                recieveEmail.setText("");
                // Show a pop-up message
                JOptionPane.showMessageDialog(ReviewGUI.this, "Message discarded", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
