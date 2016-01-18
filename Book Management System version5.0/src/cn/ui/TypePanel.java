package cn.ui;

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

import cn.bean.Type;
import cn.service.TypeService;

public class TypePanel extends JPanel {
	private JTextField queryText, nameText;
	private JTextField IDText;
	private JTextArea introText;
	private JButton queryButton, saveButton, clearButton;
	private JTable table;
	private TypeService service;
	private Vector<Vector> datas;
	private Vector columns;

	public JTextField getQueryText() {
		return queryText;
	}

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

	public TypePanel(TypeService ts) {
		this.service = ts;
		JPanel queryPanel = new JPanel();
		Box queryBox = new Box(BoxLayout.X_AXIS);
		queryBox.add(new JLabel("Name"));
		queryBox.add(Box.createHorizontalStrut(30));
		queryText = new JTextField(20);
		queryBox.add(queryText);
		queryBox.add(Box.createHorizontalStrut(30));
		queryButton = new JButton("Query");
		queryBox.add(queryButton);
		queryPanel.add(queryBox);
		this.add(queryPanel);
		setTableDatas();
		initColumns();
		DefaultTableModel model = new DefaultTableModel(null, this.columns);
		setTable(new JTable(model));
		JScrollPane tablePanel = new JScrollPane(table);
		tablePanel.setPreferredSize(new Dimension(1000, 350));
		JPanel editPanel = new JPanel();
		editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.Y_AXIS));
		nameText = new JTextField(20);
		introText = new JTextArea("", 5, 5);
		IDText = new JTextField(20);
		saveButton = new JButton("Save");
		clearButton = new JButton("Clear");
		IDText.setVisible(false);
		Box downBox1 = new Box(BoxLayout.X_AXIS);
		downBox1.add(IDText);
		downBox1.add(new JLabel("Name"));
		downBox1.add(Box.createHorizontalStrut(10));
		downBox1.add(nameText);
		downBox1.add(Box.createHorizontalStrut(100));
		Box downBox2 = new Box(BoxLayout.X_AXIS);
		downBox2.add(IDText);
		downBox2.add(new JLabel("Intorduction"));
		downBox2.add(Box.createHorizontalStrut(10));
		downBox2.add(introText);
		downBox2.add(Box.createHorizontalStrut(100));
		Box downBox3 = new Box(BoxLayout.X_AXIS);
		downBox3.add(IDText);
		downBox3.add(saveButton);
		downBox3.add(Box.createHorizontalStrut(10));
		downBox3.add(clearButton);
		downBox3.add(Box.createHorizontalStrut(100));
		editPanel.add(getSplitBox());
		editPanel.add(downBox1);
		editPanel.add(getSplitBox());
		editPanel.add(downBox2);
		editPanel.add(getSplitBox());
		editPanel.add(downBox3);
		editPanel.add(getSplitBox());
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tablePanel, editPanel);
		split.setDividerSize(5);
		this.add(split);
		refreshTable();
		initListener();
	}

	private void initListener() {
		clearButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		queryButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				query();
			}

		});
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
	}

	private void add() {
		String name = nameText.getText().trim();
		String intro = introText.getText().trim();
		if (name.equals("") || intro.equals(""))
			return;
		Type t = new Type(null, name, intro);
		service.add(t);
		initData();
		refreshTable();
	}

	private void query() {
		String str = queryText.getText();
		Vector<Type> t = (Vector<Type>) service.findByName(str);
		Vector<Vector> data = changeDatas(t);
		setDatas(data);
		refreshTable();
	}

	private void clear() {
		nameText.setText("");
		introText.setText("");
		IDText.setText("");

	}

	private void refreshTable() {
		initData();
		getTable().repaint();
	}

	private void initData() {
		if (this.table == null)
			return;
		DefaultTableModel m = (DefaultTableModel) this.table.getModel();
		m.setDataVector(getDatas(), getColumns());
		setTableFace();
	}

	private void setTableFace() {
		getTable().getColumn("ID").setMinWidth(-1);
		getTable().getColumn("ID").setMaxWidth(-1);
		getTable().setRowHeight(30);
	}

	private Component getSplitBox() {
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JLabel("        "));
		return box;
	}

	private void initColumns() {
		this.columns = new Vector();
		this.columns.add("ID");
		this.columns.add("Name");
		this.columns.add("Intorduction");

	}

	private void setTableDatas() {
		Vector<Type> types = (Vector<Type>) service.findAll();
		Vector<Vector> data = changeDatas(types);
		setDatas(data);
	}

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
}
