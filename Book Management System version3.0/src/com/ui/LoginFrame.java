package com.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bean.User;
import com.common.DataException;
import com.common.DataUtil;
import com.dataBaseOperation.JDBCExcutor;
import com.ui_normal.MainFrame_Normal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String user, pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int width = 300;
		int height = 238;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();
					Component com = frame;
					com.setBounds((dime.width - width) / 2, (dime.height - height) / 2, width, height);
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
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/huangduo/Downloads/FullSizeRender.jpg"));
		setTitle("Login");
		setDefaultCloseOperation(3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblAccount = new JLabel("Account:");

		JLabel lblPassword = new JLabel("Password:");

		textField = new JTextField();
		textField.setColumns(10);

		passwordField = new JPasswordField();

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = textField.getText().trim();
				pass = passwordField.getText().trim();
				JDBCExcutor ex = JDBCExcutor.getJDBCExcutor();
				String sql = "SELECT * FROM T_USER WHERE USER_NAME = " + "'" + user + "'" + " AND USER_PASSWORD = "
						+ "'" + pass + "'";
// 传统方式连接测试
//				try {
//					ResultSet rs = ex.excuteQuery(sql);
//					if (rs.next()) {
//						setVisible(false);
//						System.out.println("Login Success.");
//					} else {
//						System.out.println("Login Failed.");
//					}
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
				
				// 连接数据库
				try {
					ResultSet rs = ex.excuteQuery(sql);
					Collection<User> users = DataUtil.getDatas(new ArrayList<User>(), rs, User.class);
					if (users.size() == 1) {
						setVisible(false);
						MainFrame_Normal mf = new MainFrame_Normal();
						mf.show();
					} else {
						JOptionPane.showMessageDialog(null, "Wrong password, please check it then retry.", "Warning", JOptionPane.INFORMATION_MESSAGE);
						passwordField.setText("");
					}
				} catch (Exception e1) {
					throw new DataException(e1.getMessage());
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPassword)
						.addComponent(lblAccount))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
						.addComponent(textField, 181, 181, 181))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(114, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(97))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccount)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
