package cn.ui;

import javax.swing.JFrame;

import cn.dao.TypeDao;
import cn.ui.*;
import cn.service.TypeService;

public class MainFrame extends JFrame {

	public TypePanel tpn;

	public MainFrame() {

		tpn = new TypePanel(new TypeService(new TypeDao()));
		add(tpn);
		setSize(1024, 768);
		setTitle("Book Management System v1.0");
		setDefaultCloseOperation(3);
	}
}
