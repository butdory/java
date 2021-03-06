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

import static project.adminLogin.isT;


public class login extends JFrame implements ActionListener{
	JButton check_btn, admin_btn;
	JPanel main_panel;
	JTextField name, class_nm, grade;
	
	public static String n, a, c;
	
	// adminLogin 함수와 거의 동일
	public login() {
		setTitle("선린인 [ Sunrin Information ] 로그인");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(5, 2));

		main_panel = new JPanel();
		JPanel name_panel = new JPanel();
		JLabel name_label = new JLabel(" 이름 : ");
		name_label.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		name_panel.add(name_label);
		name = new JTextField(20);
		name_panel.add(name);
		
		JPanel grade_panel = new JPanel();
		JLabel grade_label = new JLabel(" 학년 : ");
		grade_label.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		grade_panel.add(grade_label);
		grade = new JTextField(3);
		grade_panel.add(grade);
		
	
		JPanel class_nm_panel = new JPanel();
		JLabel class_label = new JLabel(" 반 :  ");
		class_label.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		class_nm_panel.add(class_label);
		class_nm = new JTextField(3);
		class_nm_panel.add(class_nm);
		
		this.add(name_panel);
		add(grade_panel);
		add(class_nm_panel);
		check_btn = new JButton("확인");
		check_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 20));
		add(check_btn);
		check_btn.addActionListener(this);
		
		admin_btn = new JButton("관리자 로그인");
		admin_btn.setFont(new Font("G마켓 산스 TTF Bold", Font.BOLD, 16));
		main_panel.add(admin_btn);
		admin_btn.addActionListener(this);
		
		add(main_panel);
		setSize(500, 300);
		setVisible(true);
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == check_btn) {
			n = name.getText();
			a = grade.getText();
			c = class_nm.getText();
			getTimetableAPI timetableapi = new getTimetableAPI();
			timetableapi.main();
			isT = false;
			setVisible(false);
			new index();
		}
		else if (obj == admin_btn) {
			setVisible(false);
			new adminLogin();
		}
	}
}
