package com.ui_normal;

import javax.swing.JFrame;

import com.dataAccessObject.TypeDao;
import com.ui_normal.*;
import com.service.TypeService;

public class MainFrame_Normal extends JFrame {

	public TypePanel_Normal tpn;
//	public TypePanel t = new TypePanel(new TypeService(new TypeDao()));
	
	public MainFrame_Normal() {
		
		tpn = new TypePanel_Normal(new TypeService(new TypeDao()));
		add(tpn);
//		add(t);
		setSize(1024, 768);
		setTitle("Book Management System v1.0");
		setDefaultCloseOperation(3);
	}
}
