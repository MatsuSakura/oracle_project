package Depart;

import java.awt.*;

import com.borland.jbcl.layout.*;

import db.dbConn;
import stuManager.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * 
 * Title: Ժϵ���� 
 * Description: Ժϵ����ģ�飬���Զ�Ժϵ��Ϣ���в�ѯ�����޸ĺ�ɾ������ڡ�
 *
 */

public class DepartManager extends JFrame {
	XYLayout xYLayout1 = new XYLayout();
	JLabel jLabel1 = new JLabel();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JScrollPane jScrollPane1 = new JScrollPane();
	JTable jTable1 = new JTable();
	JButton jButton4 = new JButton();
	JButton jButton5 = new JButton();
	JButton jButton6 = new JButton();
	dbConn conn = new dbConn();
	Object[][] arrData = {};
	String[] arrField = { "רҵ���", "ѧԺ����", "רҵ����" };
	JOptionPane jOptionPane1 = new JOptionPane();
	DefaultTableModel model = new DefaultTableModel();
	String sql, find;
	int intRow;

	public DepartManager() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(xYLayout1);
		xYLayout1.setWidth(530);
		xYLayout1.setHeight(540);
		jLabel1.setFont(new java.awt.Font("����", Font.PLAIN, 20));
		jLabel1.setText("Ժ ϵ �� Ϣ �� ��");
		jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
		jButton4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jButton4.setText("��  ��");
		jButton4.addActionListener(new DepartManager_jButton4_actionAdapter(this));
		jButton5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jButton5.setText("ɾ  ��");
		jButton5.addActionListener(new DepartManager_jButton5_actionAdapter(this));
		jButton6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jButton6.setText("��  ��");
		jButton6.addActionListener(new DepartManager_jButton6_actionAdapter(this));
		this.getContentPane().add(jLabel1, new XYConstraints(177, 14, 177, 39));
		jScrollPane1.getViewport().add(jTable1);
		this.getContentPane().add(jScrollPane1, new XYConstraints(10, 60, 510, 400));
		this.getContentPane().add(jButton4, new XYConstraints(100, 480, 90, 35));
		this.getContentPane().add(jButton5, new XYConstraints(220, 480, 90, 35));
		this.getContentPane().add(jButton6, new XYConstraints(340, 480, 90, 35));

		// �û��ȼ��ж�
		// 1Ϊ����Ա
		if (MainFrame.level.equals("1")) {
			// �������κι���
		}
		// 2Ϊ��ͨ�û�
		else if (MainFrame.level.equals("2")) {
			// ���ز��ֹ���
			jButton4.setVisible(false);
			jButton5.setVisible(false);
		}

		// ѡ��רҵ��
		sql = "select * from tb_spec";
		// ˢ��
		UpdateRecord();
	}

	// �޸�Ժϵ
	public void jButton4_actionPerformed(ActionEvent e) {
		getM();
		if (intRow == -1) {
			jOptionPane1.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ�Ժϵ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
		} else {
			DepartChange siadd = new DepartChange(find);
			siadd.setLocation(400, 200);
			siadd.setSize(465, 310);
			siadd.setVisible(true);
			siadd.setResizable(false);
			siadd.validate();
			this.dispose();
		}
	}

	// ɾ��Ժϵ
	public void jButton5_actionPerformed(ActionEvent e) {
		getM();
		if (intRow == -1) {
			jOptionPane1.showMessageDialog(this, "��ѡ��Ҫɾ����Ժϵ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
		}
		try {
			conn.getUpdate("delete from tb_spec where specId='" + Integer.valueOf(find) + "'");
			jOptionPane1.showMessageDialog(this, "ɾ���ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
		} catch (Exception ce) {
			System.out.println(ce.getMessage());
		}
		UpdateRecord();
	}

	// �˳�
	public void jButton6_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	// ���±��
	public void UpdateRecord() {
		Object[][] arrTmp = {}; // �趨�����ֶ�
		Vector vec = new Vector(1, 1);
		model = new DefaultTableModel(arrTmp, arrField);
		jTable1 = new JTable(model);
		jScrollPane1.getViewport().add(jTable1, null);
		try {
			ResultSet rs3 = conn.getRs(sql);
			while (rs3.next()) {
				vec = new Vector();
				vec.add(String.valueOf(rs3.getInt("specId")));
				vec.add(rs3.getString("departName"));
				vec.add(rs3.getString("specName"));
				model.addRow(vec);
			}
			rs3.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		jScrollPane1.getHorizontalScrollBar();
		jTable1.setGridColor(Color.blue);
		jTable1.setDragEnabled(true);
		jTable1.setSelectionForeground(Color.red);
		jTable1.setSelectionBackground(Color.green);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable1.setRowSelectionAllowed(true);
		jTable1.setShowVerticalLines(true);
	}

	// ��ȡ��ѡ����
	public void getM() {
		intRow = jTable1.getSelectedRow();

		if (intRow == -1) {
			return;
		}
		try {
			find = model.getValueAt(intRow, 0).toString().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class DepartManager_jButton6_actionAdapter implements ActionListener {
	private DepartManager adaptee;

	DepartManager_jButton6_actionAdapter(DepartManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton6_actionPerformed(e);
	}
}

class DepartManager_jButton5_actionAdapter implements ActionListener {
	private DepartManager adaptee;

	DepartManager_jButton5_actionAdapter(DepartManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton5_actionPerformed(e);
	}
}

class DepartManager_jButton4_actionAdapter implements ActionListener {
	private DepartManager adaptee;

	DepartManager_jButton4_actionAdapter(DepartManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {

		adaptee.jButton4_actionPerformed(e);
	}
}
