import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class LoginGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    // Launch the application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginGUI frame = new LoginGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Create the frame
    public LoginGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1072, 775);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton signUp = new JButton("Not a user? Sign Up!");
        signUp.setFont(new Font("Times New Roman", Font.BOLD, 12));
        signUp.setBounds(586, 507, 230, 24);
        contentPane.add(signUp);
        
        JButton btnForgotPassword = new JButton("Forgot Password?");
        btnForgotPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnForgotPassword.setBounds(613, 371, 161, 17);
        contentPane.add(btnForgotPassword);
        
        JButton HomeBtn = new JButton("Log In");
        HomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                // Check if the credentials are valid
                if (UserAuthenticator.authenticate(username, password)) {
                    // Close the current login window
                    LoginGUI.this.dispose();
                    HomeGUI homeFrame = new HomeGUI();
                    homeFrame.setVisible(true);
                } else {
                    // Show an error message if login fails
                    JOptionPane.showMessageDialog(LoginGUI.this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        HomeBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\login.png"));
        HomeBtn.setFont(new Font("Times New Roman", Font.BOLD, 14));
        HomeBtn.setBounds(586, 430, 230, 57);
        contentPane.add(HomeBtn);
        
        JLabel login = new JLabel("LOGIN CENTER");
        login.setForeground(new Color(255, 255, 255));
        login.setFont(new Font("Times New Roman", Font.BOLD, 17));
        login.setBounds(434, 171, 193, 39);
        contentPane.add(login);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        passwordField.setBounds(586, 331, 230, 36);
        contentPane.add(passwordField);
        
        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        textField.setBounds(586, 247, 230, 39);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel userpasswd = new JLabel("Password: ");
        userpasswd.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\password.png"));
        userpasswd.setFont(new Font("Times New Roman", Font.BOLD, 18));
        userpasswd.setForeground(new Color(255, 255, 255));
        userpasswd.setBounds(425, 310, 133, 57);
        contentPane.add(userpasswd);
        
        JLabel username = new JLabel("User Name: ");
        username.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\username.png"));
        username.setFont(new Font("Times New Roman", Font.BOLD, 18));
        username.setForeground(new Color(255, 255, 255));
        username.setBounds(425, 245, 151, 39);
        contentPane.add(username);
        
        JLabel lblNewLabel_1 = new JLabel("Masha Hospital");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 41));
        lblNewLabel_1.setBounds(424, 78, 350, 92);
        contentPane.add(lblNewLabel_1);
        
        JLabel usernamee = new JLabel("");
        usernamee.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\LoginPage.png"));
        usernamee.setBounds(0, 0, 1058, 728);
        contentPane.add(usernamee);
    }
}
