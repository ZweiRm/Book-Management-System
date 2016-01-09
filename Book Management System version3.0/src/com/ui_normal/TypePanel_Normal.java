package com.ui_normal;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.bean.Type;
import com.service.TypeService;

public class TypePanel_Normal extends JPanel {

	// 声明界面用到的控件
	// 文本输入框
	private JTextField queryText, nameText;
	// 隐藏文本ID
	private JTextField IDText;
	// 简介输入界面
	private JTextArea introText;
	// 按钮
	private JButton queryButton, saveButton, clearButton;
	// 表格
	private JTable table;

	// 声明界面中数据
	// 数据提供者 TypeService
	private TypeService service;
	// 表格中当前数据
	private Vector<Vector> datas;
	// 定义表头
	private Vector columns;

	public JTextField getQueryText() {
		return queryText;
	}

	// getter and setters
	public void setQueryText(JTextField queryText) {
		this.queryText = queryText;
	}

	public JTextField getNameText() {
		return nameText;
	}

	public void setNameText(JTextField nameText) {
		this.nameText = nameText;
	}

	public JTextField getIDText() {
		return IDText;
	}

	public void setIDText(JTextField iDText) {
		IDText = iDText;
	}

	public JTextArea getIntroText() {
		return introText;
	}

	public void setIntroText(JTextArea introText) {
		this.introText = introText;
	}

	public JButton getQueryButton() {
		return queryButton;
	}

	public void setQueryButton(JButton queryButton) {
		this.queryButton = queryButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public void setClearButton(JButton clearButton) {
		this.clearButton = clearButton;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public TypeService getService() {
		return service;
	}

	public void setService(TypeService service) {
		this.service = service;
	}

	public Vector<Vector> getDatas() {
		return datas;
	}

	public void setDatas(Vector<Vector> datas) {
		this.datas = datas;
	}

	public Vector getColumns() {
		return columns;
	}

	public void setColumns(Vector columns) {
		this.columns = columns;
	}

	private void setTableDatas() {
		// 将TypeService中Collection<Type>数据转换为二维数据
		Vector<Type> types = (Vector<Type>) service.findAll();
		Vector<Vector> data = changeDatas(types);
		setDatas(data);
	}

	private void initColumns() {
		this.columns = new Vector();
		this.columns.addElement("ID");
		this.columns.addElement("Name");
		this.columns.addElement("Introduction");
	}

	// 一维数据向二维数据转换函数
	private Vector<Vector> changeDatas(Vector<Type> types) {
		Vector<Vector> result = new Vector<Vector>();
		for (Type t : types) {
			Vector v = new Vector();
			v.add(t.getID());
			v.add(t.getTYPE_NAME());
			v.add(t.getTYPE_INTRO());
			result.add(v);
		}
		return result;
	}

	// 箱子填充方法
	private Component getSplitBox() {
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JLabel("          "));
		return box;
	}

	
	private void refreshTable() {
		initData();
		getTable().repaint();
	}
	
	// 初始化数据方法
	private void initData() {
		if (this.table == null) {
			return;
		} else {
			DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
			dtm.setDataVector(getDatas(), getColumns());
			setTableFace();			
		}
//		if (this.table == null)
//			return;
//		DefaultTableModel m = (DefaultTableModel) this.table.getModel();
//		m.setDataVector(getDatas(), getColumns());
//		setTableFace();
	}
	
	
	
	// 设置表外观函数
	private void setTableFace() {
		// 隐藏ID列
		getTable().getColumn("ID").setMinWidth(-1);
		getTable().getColumn("ID").setMaxWidth(-1);
		getTable().setRowHeight(30);
	}

	// 文本框置空方法
	private void clear() {
		nameText.setText("");
		introText.setText("");
		IDText.setText("");
	}
	
	// 查询方法
	private void query() {
		String str = queryText.getText();
		Vector<Type> t = (Vector<Type>)service.findByName(str);
		Vector<Vector> data = changeDatas(t);
		setDatas(data);
		refreshTable();
	}
	
	// 保存方法
	private void add() {
		String name = nameText.getText().trim();
		String intro = introText.getText().trim();
		if(name.equals("") || intro.equals("")) {
			return;
		} else {
			Type t = new Type(null, name, intro);
			service.add(t);
			initData();
			refreshTable();
		}
	}

	
	// create constructor method and initialize
	public TypePanel_Normal(TypeService ts) {
		// 声明数据提供者
		this.service = ts;

		// 声明查询面板
		JPanel queryPanel = new JPanel();
		Box queryBox = new Box(BoxLayout.X_AXIS);

		// 查询箱中添加标签
		queryBox.add(new JLabel("Name"));
		// 标签后添加水平结构
		queryBox.add(Box.createHorizontalStrut(30));
		// 水平结构后添加查询文本框
		queryText = new JTextField(20);
		queryBox.add(queryText);
		// 查询文本框后添加查询按钮
		queryButton = new JButton("Query");
		queryBox.add(queryButton);

		// 将查询箱添加到查询面板
		queryPanel.add(queryBox);

		// 将查询面板添加到主面板
		this.add(queryPanel);

		// 添加表格
		// 准备表格内数据
		setTableDatas();
		// 准备表格内表头
		initColumns();
		// 设置表格模型
		DefaultTableModel model = new DefaultTableModel(null, this.columns);
		// 添加表格
		setTable(new JTable(model));

		// 创建带有滚动条的面板、将表格放入此面板
		JScrollPane tablePane = new JScrollPane(table);
		tablePane.setPreferredSize(new Dimension(1000, 350));

		// 添加编辑区面板
		JPanel editPanel = new JPanel();
		// 设置面板布局为BoxLayout，按Y轴排列
		editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.Y_AXIS));
		// 初始化面板内控件
		nameText = new JTextField(20);
		introText = new JTextArea("", 5, 5);
		IDText = new JTextField(20);
		saveButton = new JButton("Save");
		clearButton = new JButton("Clear");
		// 添加控件、隐藏ID控件到面板中
			IDText.setVisible(false);
			// 创建名称编辑区面板
				// 创建存放箱1，放置隐藏ID控件，标签，水平结构，文本框
				Box downBox1 = new Box(BoxLayout.X_AXIS);
				downBox1.add(IDText);
				downBox1.add(new JLabel("Name"));
				downBox1.add(Box.createHorizontalStrut(10));
				downBox1.add(nameText);
				downBox1.add(Box.createHorizontalStrut(100));
				// 创建存放箱2，放置隐藏ID控件，标签，水平结构，文本框
				Box downBox2 = new Box(BoxLayout.X_AXIS);
				downBox2.add(IDText);
				downBox2.add(new JLabel("Introdunction"));
				downBox2.add(Box.createHorizontalStrut(10));
				downBox2.add(introText);
				downBox2.add(Box.createHorizontalStrut(100));
				// 创建存放箱3，放置按钮
				Box downBox3 = new Box(BoxLayout.X_AXIS);
				downBox3.add(IDText);
				downBox3.add(saveButton);
				downBox3.add(Box.createHorizontalStrut(30));
				downBox3.add(clearButton);
				downBox3.add(Box.createHorizontalStrut(30));
			// 将名称编辑区面板添加入编辑区面板
			editPanel.add(getSplitBox());
			editPanel.add(downBox1);
			editPanel.add(getSplitBox());
			editPanel.add(downBox2);
			editPanel.add(getSplitBox());
			editPanel.add(downBox3);
			editPanel.add(getSplitBox());
			
		// 将表格面板和编辑区面板放入面板
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tablePane, editPanel);
		split.setDividerSize(5);
		this.add(split);
		
		// 数据更新操作
		refreshTable();
		// 创建监听器
		initListener();
	}

	// 监听器方法
	private void initListener() {
		// 清除按钮监听
		clearButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		// 查询按钮监听
		queryButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				query();
			}

		});
		
		// 保存按钮监听
		saveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
	}
}
