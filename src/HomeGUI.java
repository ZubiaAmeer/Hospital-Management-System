import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class HomeGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeGUI frame = new HomeGUI();
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
	public HomeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\logout-Icon.png"));
		logoutBtn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		logoutBtn.setBounds(836, 41, 99, 37);
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		contentPane.add(logoutBtn);
		
		JLabel homeTitle = new JLabel("Home");
		homeTitle.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\home.png"));
		homeTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
		homeTitle.setBounds(418, 27, 163, 56);
		contentPane.add(homeTitle);
		
		JLabel titleText = new JLabel("Patient");
		titleText.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\patient.png"));
		titleText.setFont(new Font("Times New Roman", Font.BOLD, 27));
		titleText.setBounds(25, 68, 198, 58);
		contentPane.add(titleText);
		
		JLabel patientDetails = new JLabel("Patient Detials");
		patientDetails.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\details.png"));
		patientDetails.setFont(new Font("Times New Roman", Font.BOLD, 27));
		patientDetails.setBounds(36, 404, 262, 61);
		contentPane.add(patientDetails);
		
		JButton AdminBtn = new JButton("Admin");
		AdminBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\admin.png"));
		AdminBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AdminBtn.setBounds(99, 163, 148, 51);
		AdminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Only admin can access, restricted access", "Restricted Access", JOptionPane.WARNING_MESSAGE);
	        }
		});
		
		contentPane.add(AdminBtn);
		
		
		JButton addPatientBtn = new JButton("Add Patient");
		addPatientBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\addPatient.png"));
		addPatientBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		addPatientBtn.setBounds(351, 163, 189, 48);
		addPatientBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HomeGUI.this.dispose();
				AddPatientGUI addPatient = new AddPatientGUI();
				addPatient.setVisible(true);
			}
			
		});
		contentPane.add(addPatientBtn);
		
		JButton DocScgeduleBtn = new JButton("Doctor's Schedule");
		DocScgeduleBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\DoctorsSchedule.png"));
		DocScgeduleBtn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		DocScgeduleBtn.setBounds(631, 163, 209, 48);
		DocScgeduleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorScheduleGUI docSchedule = new DoctorScheduleGUI();
				docSchedule.setVisible(true);
			}
		});
		contentPane.add(DocScgeduleBtn);
		
		JButton availableStuffBtn = new JButton("Available Stuff");
		availableStuffBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\availableStuff.png"));
		availableStuffBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		availableStuffBtn.setBounds(633, 306, 212, 37);
		availableStuffBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorListGUI docList = new DoctorListGUI();
				docList.setVisible(true);
			}
			
		});
		contentPane.add(availableStuffBtn);
		
		JButton UpdateInfoBtn = new JButton("Update/Delete");
		UpdateInfoBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\update.png"));
		UpdateInfoBtn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		UpdateInfoBtn.setBounds(351, 307, 209, 36);
		UpdateInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Your information will be updated/deleted", "Success", JOptionPane.WARNING_MESSAGE);

            }
			
		});
		contentPane.add(UpdateInfoBtn);
		
		JButton ReviewBtn = new JButton("Review");
		ReviewBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\review.png"));
		ReviewBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ReviewBtn.setBounds(99, 306, 166, 43);
		ReviewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviewGUI reviewFrame = new ReviewGUI();
				reviewFrame.setVisible(true);
				
			}
			
		});
		contentPane.add(ReviewBtn);
		
		
		JButton BillBtn = new JButton("Bill");
		BillBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\bill.png"));
		BillBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		BillBtn.setBounds(109, 507, 172, 63);
		BillBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillingSystemGUI billFrame = new BillingSystemGUI();
				billFrame.setVisible(true);
			}
		});
		contentPane.add(BillBtn);
		
		JButton recordsBtn = new JButton("Record Details");
		recordsBtn.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\details2.png"));
		recordsBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		recordsBtn.setBounds(664, 507, 213, 66);
		recordsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientDetail detailFrame = new PatientDetail();
				detailFrame.setVisible(true);
			}
		});
		contentPane.add(recordsBtn);
		
		JLabel backgroundPic = new JLabel("");
		backgroundPic.setIcon(new ImageIcon("C:\\Users\\Yasmine nargis\\eclipse-workspace\\HospitalManagementSystem\\resources\\HomePage.png"));
		backgroundPic.setBounds(0, 0, 970, 658);
		contentPane.add(backgroundPic);
	}
}
