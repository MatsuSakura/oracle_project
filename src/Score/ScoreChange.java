package Score;

import java.awt.Font;
import com.borland.jbcl.layout.*;

import db.dbConn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

/**
 * 
 * Title: �ɼ��޸� 
 * Description: �ɼ��޸�ģ��
 * 
 */

public class ScoreChange extends JFrame {
	XYLayout xYLayout1 = new XYLayout();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JTextField jTextField1 = new JTextField();
	JComboBox jComboBox1 = new JComboBox();
	JTextField jTextField2 = new JTextField();
	JButton jButton1 = new JButton();
	JButton jButton3 = new JButton();
	dbConn sta = new dbConn();
	JOptionPane jOptionPane1 = new JOptionPane();
	JOptionPane jOptionPane2 = new JOptionPane();
	JOptionPane jOptionPane3 = new JOptionPane();
	int csid;
	int kefind;

	public ScoreChange(int find) {
		kefind = find;
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {

		getContentPane().setLayout(xYLayout1);
		xYLayout1.setWidth(500);
		xYLayout1.setHeight(350);
		jLabel1.setFont(new java.awt.Font("������", Font.BOLD, 20));
		jLabel1.setText("��   ��   ��   �� ");
		jButton3.addActionListener(new ScoreManager_jButton3_actionAdapter(this));
		jButton1.addActionListener(new ScoreManager_jButton1_actionAdapter(this));
		jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton3.setText("��    ��");
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton1.setText("��    ��");
		jLabel5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel5.setText("\u6210 \u7EE9\uFF1A");
		jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel3.setText("�γ����ƣ�");
		this.getContentPane().add(jComboBox1, new XYConstraints(200, 130, 140, 30));
		this.getContentPane().add(jTextField2, new XYConstraints(200, 180, 140, 30));
		this.getContentPane().add(jLabel2, new XYConstraints(85, 80, 80, 30));
		this.getContentPane().add(jLabel5, new XYConstraints(85, 180, 80, 30));
		this.getContentPane().add(jLabel3, new XYConstraints(85, 130, 80, 30));
		this.getContentPane().add(jTextField1, new XYConstraints(200, 80, 140, 30));
		this.getContentPane().add(jLabel1, new XYConstraints(158, 21, -1, 49));
		this.getContentPane().add(jButton1, new XYConstraints(130, 230, 90, 30));
		this.getContentPane().add(jButton3, new XYConstraints(295, 230, 90, 30));
		jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel2.setText("ѧ��ѧ�ţ�");
		this.setTitle("�ɼ��޸�");
		jComboBox1.addItem("��ѡ��");
		// ѡ��γ�
		try {
			ResultSet rs = sta.getRs("select * from tb_cource");
			while (rs.next()) {
				String xibu = rs.getString("courceName");
				jComboBox1.addItem(xibu);
			}
			rs.close();
		} catch (Exception ce) {
			System.out.println("++++++++" + ce);
		}
		setF();
	}

	// ѡ���к����޸Ľ�����ʾѡ��Ĭ��ֵ
	public void setF() {
		if (kefind < 0)
			return;
		else {
			try {
				ResultSet rs = sta.getRs("select * from tb_score where scoreId='" + Integer.valueOf(kefind) + "'");
				while (rs.next()) {
					jComboBox1.setSelectedItem(String.valueOf(rs.getString("courceName")));
					jTextField1.setText(rs.getString("stuNumber").trim());
					jTextField2.setText(rs.getString("score").trim());
				}
				rs.close();
			} catch (Exception ce) {
				System.out.println("++++++++" + ce);
			}
		}
	}
	
	// �˳�
	public void jButton3_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	// �޸�
	public void jButton1_actionPerformed(ActionEvent e) {
		String keCName, zyName, tName, xueFen;
		int old_score = 0;
		keCName = jTextField1.getText().trim();
		zyName = String.valueOf(jComboBox1.getSelectedItem());
		xueFen = jTextField2.getText().trim();
		try {
			ResultSet rs = sta.getRs("select score from tb_score where scoreId='" + Integer.valueOf(kefind) + "'");
			while (rs.next()) {
				old_score=rs.getInt("score");
				System.out.println("ԭ���ķ�����"+old_score);
			}
			rs.close();
		} catch (Exception ce) {
			System.out.println("++++++++" + ce);
		}
		try {
			if(Float.valueOf(xueFen)<old_score){
				jOptionPane3.showMessageDialog(this,"�ؿ���������ԭ���ķ���������ʧ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
			}else if(Float.valueOf(xueFen)>=0&&Float.valueOf(xueFen)<=100) {
				sta.getUpdate("update tb_score set courceName='" + zyName + "', stuNumber='" + keCName + "',score='"
					+ Float.valueOf(xueFen) + "' where scoreId='" + kefind + "'");
				jOptionPane1.showMessageDialog(this, "�γ��޸ĳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
			}else {
				jOptionPane2.showMessageDialog(this,"����Ӧ��0~100֮�䣬����������", "��ʾ", JOptionPane.INFORMATION_MESSAGE, null);
			}
			
			
		} catch (Exception a) {		
			System.out.println(a.getMessage());
			
		}
		
	}
}

class ScoreManager_jButton1_actionAdapter implements ActionListener {
	private ScoreChange adaptee;

	ScoreManager_jButton1_actionAdapter(ScoreChange adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class ScoreManager_jButton3_actionAdapter implements ActionListener {
	private ScoreChange adaptee;

	ScoreManager_jButton3_actionAdapter(ScoreChange adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton3_actionPerformed(e);
	}
}
