package com.ui_normal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.dataBaseOperation.JDBCExcutor;

public class LoginFrame_Normal extends JFrame {

	// 定义账号密码标签
	private JLabel accLabel, passLabel;

	// 定义接受用户名textField
	private JTextField accField;

	// 定义一个密码接受
	private JPasswordField passField;

	// 定义一个登录按钮
	private JButton loginButton;

	// 定义两个存储变量
	private String user, pass;

	// 构造函数初始化窗体
	public LoginFrame_Normal() {
		// 窗体初始化
		setTitle("Login");
		setBounds(300, 300, 340, 300);
		setDefaultCloseOperation(3);
		setLayout(null);
		setResizable(false);
		setVisible(true);

		// 组件初始化
		accLabel = new JLabel("Accont:");
		passLabel = new JLabel("Pass Word:");
		accField = new JTextField(20);
		passField = new JPasswordField(20);
		loginButton = new JButton("Login");

		// 用坐标标识组件位置
		accLabel.setBounds(60, 50, 50, 50);
		passLabel.setBounds(60, 100, 50, 50);
		accField.setBounds(100, 60, 150, 28);
		passField.setBounds(100, 110, 150, 28);

		add(accLabel);
		add(passLabel);
		add(accField);
		add(passField);

		// 添加按钮
		loginButton.setBounds(150, 150, 75, 40);
		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// 获得用户名、密码
				user = accField.getText().trim();
				pass = passField.getText().trim();
				System.out.println(user);
				System.out.println(pass);

				// 用户名、密码验证
				JDBCExcutor ex = JDBCExcutor.getJDBCExcutor();
				String sql = "SELECT * FROM T_USER WHERE USER_NAME = " + "'" + user + "'" + " AND USER_PASSWORD = "
						+ "'" + pass + "'";
				try {
					ResultSet rs = ex.excuteQuery(sql);
					if(rs.next()) {
						setVisible(false);
						System.out.println("Login Success.");
					}else{
						System.out.println("Login Failed.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(loginButton);
	}

	public static void main(String[] args) {
		LoginFrame_Normal lfn = new LoginFrame_Normal();
		lfn.show();
	}
}
