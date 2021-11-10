package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class adminLogin extends JFrame implements ActionListener{
	JButton check_btn, admin_btn;
	JPanel main_panel;
	JTextField name, class_nm, grade;
	
	public static String n_t, a_t, c_t;
	public static Boolean isT = false;
	
	// ������ �������� �α����ϴ� ������
	public adminLogin() {
		setTitle("������ [ Sunrin Information ] ������ �α���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(5, 2));

		// main_panel�� ���� ��ư, �ؽ�Ʈ�ʵ�, �󺧵��� ���� 39 ~ 68
		main_panel = new JPanel();
		JPanel name_panel = new JPanel();
		JLabel name_label = new JLabel(" �̸� : ");
		name_label.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 16));
		name_panel.add(name_label);
		name = new JTextField(20);
		name_panel.add(name);
		
		JPanel grade_panel = new JPanel();
		JLabel grade_label = new JLabel(" �г� : ");
		grade_label.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 16));
		grade_panel.add(grade_label);
		grade = new JTextField(3);
		grade_panel.add(grade);
		
	
		JPanel class_nm_panel = new JPanel();
		JLabel class_label = new JLabel(" �� :  ");
		class_label.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 16));
		class_nm_panel.add(class_label);
		class_nm = new JTextField(3);
		class_nm_panel.add(class_nm);
		
		this.add(name_panel);
		add(grade_panel);
		add(class_nm_panel);
		check_btn = new JButton("Ȯ��");
		check_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 20));
		add(check_btn);
		check_btn.addActionListener(this);
		
		// main_panel�� ȭ�鿡 ����� 71 ~ 73
		add(main_panel);
		setSize(500, 300);
		setVisible(true);
		}
	
	// ��ư Ŭ���̺�Ʈ�� ���� ���� 77 ~ 91
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == check_btn) {
			// �ؽ�Ʈ �ʵ忡 ���� ������ ������ static ������ ���� �� �ð�ǥ api ȣ���� �� ���� Ŭ������ �̵� 82 ~ 89 
			n_t = name.getText();
			a_t = grade.getText();
			c_t = class_nm.getText();
			isT = true;
			getTimetableAPI timetableapi = new getTimetableAPI();
			timetableapi.main();
			setVisible(false);
			new index();
		}
	}
}
