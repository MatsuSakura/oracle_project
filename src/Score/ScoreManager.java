package Score;

import com.borland.jbcl.layout.*;

import db.dbConn;
import stuManager.MainFrame;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.awt.*;

/**
 * 
 * Title: �ɼ����� 
 * Description: �ɼ�����ģ�飬���Բ�ѯ�ɼ����ǳɼ��޸ĺ�ɾ������ڡ�
 *
 */

public class ScoreManager extends JFrame {
	XYLayout xYLayout1 = new XYLayout();
	JLabel jLabel1 = new JLabel();
	JPanel jPanel1 = new JPanel();
	JScrollPane jScrollPane1 = new JScrollPane();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	XYLayout xYLayout2 = new XYLayout();
	JTable jTable1 = new JTable();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JButton jButton_print = new JButton();
	JButton jButton_sort = new JButton();
	JButton jButton_average = new JButton();
	JButton jButton_failure = new JButton();
	dbConn sta = new dbConn();
	String sql;
	Object[][] arrData = {};
	String[] arrField = { "�ɼ����", "ѧ��ѧ��", "����", "�γ�", "����" };
	DefaultTableModel model = new DefaultTableModel();
	int intRow;
	static int find;
	int i_sortDesc = 0, i_print = 0;
	JOptionPane jOptionPane1 = new JOptionPane();
	JButton jButton6 = new JButton();

	public ScoreManager() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(xYLayout1);
		jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
		jLabel1.setText("��  ��  ��  ��");
		jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jButton1.setText("��   ��");
		jButton1.addActionListener(new ScoreF_jButton1_actionAdapter(this));
		jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jButton2.setText("��   ��");
		jButton2.addActionListener(new ScoreF_jButton2_actionAdapter(this));
		jPanel1.setLayout(xYLayout2);
		jPanel1.setBorder(BorderFactory.createEtchedBorder());
		xYLayout1.setWidth(550);
		xYLayout1.setHeight(560);
		jButton_print.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton_print.setText("��  ӡ");
		jButton_print.addActionListener(new ScoreManager_jButton_print_actionAdapter(this));
		jButton_sort.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton_sort.setText("��  ��");
		jButton_sort.addActionListener(new ScoreManager_jButton_sort_actionAdapter(this));
		jButton_average.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton_average.setText("ƽ  ��");
		jButton_average.addActionListener(new ScoreManager_jButton_average_actionAdapter(this));
		jButton_failure.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton_failure.setText("������");
		jButton_failure.addActionListener(new ScoreManager_jButton_failure_actionAdapter(this));
		this.setTitle("�ɼ�����");
		jButton6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jButton6.setText("ɾ   ��");
		jButton6.addActionListener(new ScoreF_jButton6_actionAdapter(this));
		jScrollPane1.getViewport().add(jTable1);
		this.getContentPane().add(jLabel1, new XYConstraints(208, 13, 135, 43));
		this.getContentPane().add(jButton1, new XYConstraints(74, 470, 100, -1));
		this.getContentPane().add(jButton2, new XYConstraints(374, 470, 100, -1));
		this.getContentPane().add(jPanel1, new XYConstraints(17, 68, 515, 63));
		this.getContentPane().add(jScrollPane1, new XYConstraints(18, 150, 515, 300));
		this.getContentPane().add(jButton6, new XYConstraints(224, 470, 100, -1));
		jPanel1.add(jButton_print, new XYConstraints(10, 15, 80, 25));
		jPanel1.add(jButton_sort, new XYConstraints(147, 15, 80, 25));
		jPanel1.add(jButton_average, new XYConstraints(287, 15, 80, 25));
		jPanel1.add(jButton_failure, new XYConstraints(419, 15, 80, 25));

		// �û��ȼ��ж�
		// 1Ϊ����Ա
		if (MainFrame.level.equals("1")) {
			// �������κι���
		}
		// 2Ϊ��ͨ�û�
		else if (MainFrame.level.equals("2")) {
			// ���ز��ֹ���
			jButton1.setVisible(false);
			jButton6.setVisible(false);
		}

		// ����Ĭ�ϲ������гɼ�
		sql = "select * from tb_score ";
		// ����
		UpdateRecord();
	}

	// ��ѯ�����±��
	public void UpdateRecord() {
		Object[][] arrTmp = {}; // �趨�����ֶ�
		Vector vec = new Vector(1, 1);
		model = new DefaultTableModel(arrTmp, arrField);
		jTable1 = new JTable(model);
		jScrollPane1.getViewport().add(jTable1, null);
		try {
			ResultSet rs = sta.getRs(sql);
			int i = 1;
			while (rs.next()) {
				vec = new Vector();
				vec.add(String.valueOf(rs.getString("scoreId")));
				vec.add(String.valueOf(rs.getString("stuNumber")));
				ResultSet rsTemp = sta.getRs("select stuName from tb_student where stuNumber='"
						+ String.valueOf(rs.getString("stuNumber")) + "'");
				while (rsTemp.next()) {
					vec.add(String.valueOf(rsTemp.getString("stuName")));
				}
				vec.add(String.valueOf(rs.getString("courceName")));
				vec.add(String.valueOf(rs.getString("score")));
				model.addRow(vec);
			}
			rs.close();
		} catch (Exception ce) {
			System.out.println(ce);
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

	// ѡ����ѡ����
	public void getM() {
		intRow = jTable1.getSelectedRow();
		if (intRow == -1) {
			jOptionPane1.showMessageDialog(this, "��ѡ��Ҫ�޸ĵĿγ̣�", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
			return;
		}
		try {
			find = Integer.parseInt(model.getValueAt(intRow, 0).toString());
			System.out.println(find);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �˳�
	public void jButton2_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	// ���ε����ӡ��ѧ�Ž�����������
	// ˫�ε����ӡ��ѧ�Ž�����������
	public void jButton_print_actionPerformed(ActionEvent e) {
		i_print++;
		if (i_print % 2 == 1) {
			sql = "select * from tb_score order by scoreId, stuNumber";
		} else if (i_print % 2 == 0) {
			sql = "select * from tb_score order by stuNumber, scoreId";
		}
		UpdateRecord();
		jOptionPane1.showMessageDialog(this, "��ӡ�ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
	}

	// ���ε������Գɼ����н�������
	// ˫�ε������Գɼ�������������
	public void jButton_sort_actionPerformed(ActionEvent e) {
		i_sortDesc++;
		if (i_sortDesc % 2 == 1) {
			sql = "select * from tb_score order by score desc, stuNumber";
		} else if (i_sortDesc % 2 == 0) {
			sql = "select * from tb_score order by score, stuNumber";
		}
		UpdateRecord();
	}

	// ƽ����
	public void jButton_average_actionPerformed(ActionEvent e) {
		float f_average = 0;
		int averageBig = 0, averageSmall = 0;
		try {
			// ���ƽ����
			ResultSet rs_average = sta.getRs("select avg(score) as scoreAverage from tb_score");
			while (rs_average.next()) {
				f_average = Float.valueOf(rs_average.getString("scoreAverage"));
			}

			// ��ô��ڵ���ƽ���ֵ�����
			ResultSet rs_averageBig = sta.getRs("select * from tb_score where score>='" + f_average + "'");
			while (rs_averageBig.next()) {
				averageBig++;
			}

			// ���С��ƽ���ֵ�����
			ResultSet rs_averageSmall = sta.getRs("select * from tb_score where score<'" + f_average + "'");
			while (rs_averageSmall.next()) {
				averageSmall++;
			}

		} catch (SQLException e1) {
			System.out.println(e1);
		}

		// ��ʾƽ����
		jOptionPane1.showMessageDialog(this,
				"ƽ����  = " + f_average + "\n���ڵ���ƽ������ " + averageBig + "��\nС��ƽ������ " + averageSmall + "��", "��ʾ",
				JOptionPane.INFORMATION_MESSAGE, null);
	}

	// ������
	public void jButton_failure_actionPerformed(ActionEvent e) {
		int totalNumber = 0, failureNumber = 0;
		try {
			// ��ȡ������
			ResultSet rs_total = sta.getRs("select * from tb_score");
			while (rs_total.next()) {
				totalNumber++;
			}

			// ��ȡ����60�֣�����������
			ResultSet rs_failure = sta.getRs("select * from tb_score where score<'" + 60 + "'");
			while (rs_failure.next()) {
				failureNumber++;
			}
		} catch (SQLException e1) {
			System.out.println(e1);
		}

		// ��ʾ��������
		jOptionPane1.showMessageDialog(this, "��������  = " + (float) failureNumber / totalNumber * 100 + "%\n������������ "
				+ failureNumber + "��\n�������� " + totalNumber + "��", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
	}

	// �޸Ŀγ�
	public void jButton1_actionPerformed(ActionEvent e) {
		getM();
		if (find > 0) {
			ScoreChange siadd = new ScoreChange(find);
			siadd.setLocation(400, 200);
			siadd.setSize(465, 310);
			siadd.setVisible(true);
			siadd.setResizable(false);
			siadd.validate();
			this.dispose();
		}
	}

	// ɾ���γ�
	public void jButton6_actionPerformed(ActionEvent e) {
		getM();
		if (intRow == -1) {
			jOptionPane1.showMessageDialog(this, "��ѡ��Ҫɾ���Ŀγ̣�", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
		}
		try {
			sta.getUpdate("delete from tb_score where scoreId='" + Integer.valueOf(find) + "'");
			jOptionPane1.showMessageDialog(this, "ɾ���ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
		} catch (Exception ce) {
			System.out.println(ce.getMessage());
		}
		UpdateRecord();
	}
}

class ScoreF_jButton1_actionAdapter implements ActionListener {
	private ScoreManager adaptee;

	ScoreF_jButton1_actionAdapter(ScoreManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class ScoreF_jButton6_actionAdapter implements ActionListener {
	private ScoreManager adaptee;

	ScoreF_jButton6_actionAdapter(ScoreManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton6_actionPerformed(e);
	}
}

class ScoreF_jButton2_actionAdapter implements ActionListener {
	private ScoreManager adaptee;

	ScoreF_jButton2_actionAdapter(ScoreManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);
	}
}

class ScoreManager_jButton_print_actionAdapter implements ActionListener {
	private ScoreManager adaptee;

	ScoreManager_jButton_print_actionAdapter(ScoreManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton_print_actionPerformed(e);
	}
}

class ScoreManager_jButton_sort_actionAdapter implements ActionListener {
	private ScoreManager adaptee;

	ScoreManager_jButton_sort_actionAdapter(ScoreManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton_sort_actionPerformed(e);
	}
}

class ScoreManager_jButton_average_actionAdapter implements ActionListener {
	private ScoreManager adaptee;

	ScoreManager_jButton_average_actionAdapter(ScoreManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton_average_actionPerformed(e);
	}
}

class ScoreManager_jButton_failure_actionAdapter implements ActionListener {
	private ScoreManager adaptee;

	ScoreManager_jButton_failure_actionAdapter(ScoreManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton_failure_actionPerformed(e);
	}
}
