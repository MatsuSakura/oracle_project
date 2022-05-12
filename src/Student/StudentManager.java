package Student;

import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import com.borland.jbcl.layout.XYLayout;

import db.dbConn;

import com.borland.jbcl.layout.*;
import stuManager.MainFrame;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * 
 * Title: ѧ����Ϣ����
 * Description: ѧ����Ϣ����ģ�飬���Էֱ�ѧ�š��������༶��ѯ�����޸ġ�ɾ��ѧ����Ϣ����ڡ�
 *
 */

public class StudentManager extends JFrame {
	String sql, zhy;
	JLabel jLabel1 = new JLabel();
	XYLayout xYLayout1 = new XYLayout();
	JLabel jLabel2 = new JLabel();
	JComboBox jComboBox1 = new JComboBox();
	JPanel jPanel1 = new JPanel();
	JLabel jLabel3 = new JLabel();
	JButton jButton1 = new JButton();
	JPanel jPanel2 = new JPanel();
	XYLayout xYLayout2 = new XYLayout();
	JLabel jLabel4 = new JLabel();
	JTextField jTextField2 = new JTextField();
	JButton jButton2 = new JButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JPanel jPanel4 = new JPanel();
	JLabel jLabel6 = new JLabel();
	XYLayout xYLayout4 = new XYLayout();
	JTextField jTextField3 = new JTextField();
	JButton jButton4 = new JButton();
	XYLayout xYLayout5 = new XYLayout();
	JTextField jTextField1 = new JTextField();
	JButton jButton5 = new JButton();
	JButton jButton6 = new JButton();
	JScrollPane jScrollPane1 = new JScrollPane();
	JTable jTable1 = new JTable();
	int intRow;
	dbConn conn = new dbConn();
	String[] arrField = { "ѧ��", "����", "ѧԺ", "רҵ", "�༶" };
	DefaultTableModel model = new DefaultTableModel();
	Object[][] arrData = {};
	static int find;
	JButton jButton7 = new JButton();
	JOptionPane jOptionPane_LoginFeedback = new JOptionPane();

	public StudentManager() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {

		getContentPane().setLayout(xYLayout1);
		jLabel1.setFont(new java.awt.Font("������", Font.BOLD, 27));
		jLabel1.setText("ѧ����Ϣ����");
		jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jLabel2.setText("��ѡ���ѯ��ʽ��");
		this.setTitle("ѧ����Ϣ����");
		jPanel1.setBorder(BorderFactory.createEtchedBorder());
		jPanel1.setLayout(xYLayout5);
		jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jLabel3.setText("������ѧ�ţ�");
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jButton1.setText("��ѯ");
		jButton1.addActionListener(new StudentC_jButton1_actionAdapter(this));
		jPanel2.setBorder(BorderFactory.createEtchedBorder());
		jPanel2.setLayout(xYLayout2);
		jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jLabel4.setText("������ѧ��������");
		jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jButton2.setText("��ѯ");
		jButton2.addActionListener(new StudentC_jButton2_actionAdapter(this));
		jPanel4.setBorder(BorderFactory.createEtchedBorder());
		jPanel4.setLayout(xYLayout4);
		jLabel6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jLabel6.setText("������Ҫ��ѯ�İ༶��");
		jButton4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jButton4.setText("��ѯ");
		jButton4.addActionListener(new StudentC_jButton4_actionAdapter(this));
		jComboBox1.addActionListener(new StudentC_jComboBox1_actionAdapter(this));
		jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jTextField3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jButton5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jButton5.setText("�޸�");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton5_actionPerformed(e);
			}
		});

		jButton6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jButton6.setText("����");
		jButton6.addActionListener(new StudentC_jButton6_actionAdapter(this));
		jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
		jTable1.setCellSelectionEnabled(true);
		jButton7.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
		jButton7.setText("ɾ��");
		jButton7.addActionListener(new StudentC_jButton7_actionAdapter(this));
		this.getContentPane().add(jPanel2, new XYConstraints(150, 125, 510, 50));
		jPanel2.add(jButton2, new XYConstraints(381, 8, 85, 27));
		this.getContentPane().add(jPanel4, new XYConstraints(150, 125, 510, 50));
		jPanel4.add(jButton4, new XYConstraints(388, 8, 89, 26));
		ShowPanel();
		jComboBox1.addItem("��ѡ��");
		jComboBox1.addItem("��ѧ�Ų�ѯ");
		jComboBox1.addItem("��������ѯ");
		jComboBox1.addItem("���༶��ѯ");
		jPanel1.add(jTextField1, new XYConstraints(164, 8, 149, 25));
		jPanel1.add(jButton1, new XYConstraints(360, 8, 80, 29));
		jPanel1.add(jLabel3, new XYConstraints(29, 8, 125, 26));
		jPanel2.add(jLabel4, new XYConstraints(21, 8, 164, 31));
		jPanel2.add(jTextField2, new XYConstraints(206, 8, 132, 27));
		jPanel4.add(jLabel6, new XYConstraints(16, 8, 201, 30));
		jPanel4.add(jTextField3, new XYConstraints(212, 8, 152, 28));
		this.getContentPane().add(jLabel1, new XYConstraints(321, 12, 180, 38));
		this.getContentPane().add(jComboBox1, new XYConstraints(370, 76, -1, 30));
		this.getContentPane().add(jLabel2, new XYConstraints(169, 74, 161, 32));
		this.getContentPane().add(jPanel1, new XYConstraints(150, 125, 510, 50));
		jScrollPane1.getViewport().add(jTable1, null);
		this.getContentPane().add(jScrollPane1, new XYConstraints(20, 193, 759, 325));
		this.getContentPane().add(jButton5, new XYConstraints(225, 545, 95, 34));
		this.getContentPane().add(jButton6, new XYConstraints(525, 545, 95, 34));
		this.getContentPane().add(jButton7, new XYConstraints(375, 545, 95, 34));

		// �û��ȼ��ж�
		// 1Ϊ����Ա
		if (MainFrame.level.equals("1")) {
			// �������κι���
		}
		// 2Ϊ��ͨ�û�
		else if (MainFrame.level.equals("2")) {
			// ���ز��ֹ���
			jButton5.setVisible(false);
			jButton7.setVisible(false);
		}

		// ��������ѧ��
		sql = "select * from tb_student";
		// ������ʾ
		UpdateRecord();
	}

	// ������ʾ
	public void UpdateRecord() {
		Object[][] arrTmp = {}; // �趨�����ֶ�
		Vector vec = new Vector(1, 1);
		model = new DefaultTableModel(arrTmp, arrField);
		jTable1 = new JTable(model);
		jScrollPane1.getViewport().add(jTable1, null);

		try {
			ResultSet rs = conn.getRs(sql);
			while (rs.next()) {
				vec = new Vector();
				vec.add(rs.getString("stuNumber").trim());
				vec.add(rs.getString("stuName").trim());
				vec.add(rs.getString("stuDepart").trim());
				vec.add(rs.getString("stuSpec").trim());
				vec.add(rs.getString("stuClass").trim());
				model.addRow(vec);
			}

		} catch (Exception e) {
			e.printStackTrace();
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

	// ��ѯ��ʽ
	public void ShowPanel() {
		jPanel1.setVisible(false);
		jPanel2.setVisible(false);
		jPanel4.setVisible(false);
		if (jComboBox1.getSelectedIndex() == 1)
			jPanel1.setVisible(true);
		else if (jComboBox1.getSelectedIndex() == 2)
			jPanel2.setVisible(true);
		else if (jComboBox1.getSelectedIndex() == 3)
			jPanel4.setVisible(true);
	}

	// ��ȡѡ������
	public void getM() {
		intRow = jTable1.getSelectedRow();
		if (intRow == -1)
			return;
		try {
			find = Integer.parseInt(model.getValueAt(intRow, 0).toString());
			System.err.println(find);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �˳�
	public void jButton6_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	// ��ѧ�Ų�ѯ
	public void jButton1_actionPerformed(ActionEvent e) {
		if (!jTextField1.getText().trim().equals("")) {
			sql = "select * from tb_student where stuNumber='" + jTextField1.getText().trim() + "'";
			UpdateRecord();
		} else
			jOptionPane_LoginFeedback.showMessageDialog(this, "������Ҫ��ѯ��ѧ��ѧ�ţ�", "�� ʾ",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
	}

	// ѡ�񴥷�
	public void jComboBox1_actionPerformed(ActionEvent e) {
		ShowPanel();
	}

	// ��������ѯ
	public void jButton2_actionPerformed(ActionEvent e) {
		if (!jTextField2.getText().trim().equals("")) {
			sql = "select * from tb_student where stuName='" + jTextField2.getText().trim() + "'";
			UpdateRecord();
		} else
			jOptionPane_LoginFeedback.showMessageDialog(this, "������Ҫ��ѯ��ѧ��������", "�� ʾ",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
	}

	// ���༶��ѯ
	public void jButton4_actionPerformed(ActionEvent e) {
		if (!jTextField3.getText().trim().equals("")) {
			sql = "select * from tb_student where stuClass='" + jTextField3.getText().trim() + "'";
			UpdateRecord();
		} else
			jOptionPane_LoginFeedback.showMessageDialog(this, "������Ҫ��ѯ�İ༶��", "�� ʾ",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
	}

	// �޸�
	public void jButton5_actionPerformed(ActionEvent e) {
		getM();
		if (intRow != -1) {
			StudentChange siadd = new StudentChange(find);
			siadd.setLocation(400, 200);
			siadd.setSize(592, 350);
			siadd.setVisible(true);
			siadd.setResizable(false);
			siadd.validate();
			this.dispose();
		} else
			jOptionPane_LoginFeedback.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ���Ϣ��", "�� ʾ",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
	}

	// ����ɾ��
	public void jButton7_actionPerformed(ActionEvent e) {
		getM();
		if (intRow != -1) {
			delstu();
		} else
			jOptionPane_LoginFeedback.showMessageDialog(this, "��ѡ��Ҫɾ������Ϣ��", "�� ʾ",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);

	}

	// ɾ��
	public void delstu() {
		try {
			if (0 < conn.getUpdate("delete from tb_student where stuNumber='" + find + "'")) {
				jOptionPane_LoginFeedback.showMessageDialog(this, "ѧ����Ϣɾ���ɹ���", "�� ʾ",
						jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
			} else {
				System.err.printf("ɾ�� tb_student ���� stuNumber = %d �ļ�¼ʧ��\n", find);
				jOptionPane_LoginFeedback.showMessageDialog(this, "ѧ����Ϣɾ��ʧ�ܣ�", "�� ʾ",
						jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
			}
		} catch (Exception ce) {
			System.out.println(ce.getMessage());
		}
	}
}

class StudentC_jButton7_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jButton7_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton7_actionPerformed(e);
	}
}

class StudentC_jButton4_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jButton4_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton4_actionPerformed(e);
	}
}

class StudentC_jButton2_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jButton2_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);
	}
}

class 	StudentC_jButton1_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jButton1_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class StudentC_jButton6_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jButton6_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton6_actionPerformed(e);
	}
}

class StudentC_jComboBox1_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jComboBox1_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jComboBox1_actionPerformed(e);
	}
}
