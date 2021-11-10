package project;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.io.IOException; 
import java.net.URI; 
import java.net.URISyntaxException;

import static project.getTimetableAPI.all_ti_ymd;
import static project.getTimetableAPI.itrt_cntnt;
import static project.getTimetableAPI.perio;
import static project.login.a;
import static project.login.c;
import static project.login.n;

import static project.adminLogin.a_t;
import static project.adminLogin.n_t;
import static project.adminLogin.c_t;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class timetable extends JFrame implements ActionListener {
	
	JButton timetable_web_btn, exit_btn;
	JLabel name, grade, class_nm;
	JPanel main_panel;
	JTable table;
	
	// �ð�ǥ�� ����ϴ� Ŭ����
	public timetable() {
		setTitle("������ [ Sunrin Information ] �ð�ǥ");
		exit_btn = new JButton("���ư���");
		timetable_web_btn = new JButton("������ ����");
		main_panel = new JPanel();
		name = new JLabel(n);
		grade = new JLabel(a+"�г�");
		class_nm = new JLabel(c+"��");
		main_panel.setLayout(null);
		String header[] = {"����", "��", "ȭ", "��", "��", "��"};
		
		String contents[][] = new String[7][8];
		
		// api�� ������ �ð�ǥ�� table�� ǥ���ϱ����� 2���� �迭�� ��ȯ�ϴ� �ڵ� 55 ~ 70
		int tmp = 0;
		
		for(int i = 0; i < 7; i++) {
			tmp = i;
			for(int j = 0; j < 8; j++) {
				if(j == 0) {
					contents[i][j] = Integer.toString(i+1);
					continue;
				}
				if(tmp >= 34) {
					break;
				}
				contents[i][j] = itrt_cntnt[tmp];
				tmp+=7;
			}
		}
		
		table = new JTable(contents, header);
		// �� ���� ���̸� ���� 74
		table.setRowHeight(25);
		table.getColumn("��").setPreferredWidth(200);
		table.getColumn("ȭ").setPreferredWidth(200);
		table.getColumn("��").setPreferredWidth(200);
		table.getColumn("��").setPreferredWidth(200);
		table.getColumn("��").setPreferredWidth(200);
		
		// ��Ʈ ���� 82 ~ 87
		table.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 12));
		timetable_web_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 16));
		exit_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 16));
		name.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 16));
		class_nm.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 16));
		grade.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 16));
		
		// ���̺��� ���������� ó���ϱ� ���� �ڵ� add(table)�� �ٷ� �����ϸ� ������ ���� �� ���� 90 ~ 91
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true); 
		
		// layout ���� 94 ~ 99
		scrollPane.setBounds(150, 180, 1000, 200);
		timetable_web_btn.setBounds(350, 100, 150, 30);
		exit_btn.setBounds(550, 100, 100, 30);
		name.setBounds(700, 100, 50, 50);
		class_nm.setBounds(800, 100, 50, 50);
		grade.setBounds(750, 100, 50, 50);
		
		// ��ư Ŭ���̺�Ʈ 102 ~ 103
		exit_btn.addActionListener(this);
		timetable_web_btn.addActionListener(this);
		
		// �ǳ� ���� 106 ~ 115
		main_panel.add(timetable_web_btn);
		main_panel.add(exit_btn);
		main_panel.add(name);
		main_panel.add(grade);
		main_panel.add(class_nm);
		main_panel.add(scrollPane);
		
		add(main_panel);
		setSize(1280, 720);
		setVisible(true);
	}
	
	// ��ư Ŭ���̺�Ʈ 119 ~ 137
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		// �ð�ǥ apiȣ�⿡ ������ ��츦 ����Ͽ� ���󿡼� �ð�ǥ�� �����ִ� �ڵ� (����� 2�г� 6�ݸ� �����Ǿ�����) 123 ~ 131
		if (obj == timetable_web_btn) {
			try {
				Desktop.getDesktop().browse(new URI("https://timetable-2aace.web.app/"));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e2) {
				e2.printStackTrace();
			}
		}
		else if(obj == exit_btn) {
			setVisible(false);
			new index();
		}
		
	}

}
