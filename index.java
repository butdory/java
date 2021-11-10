package project;
import static project.getTimetableAPI.all_ti_ymd;
import static project.getTimetableAPI.itrt_cntnt;
import static project.getTimetableAPI.perio;
import static project.getlunchAPI.ddish_nm;
import static project.getlunchAPI.mlsv_ymd;
import static project.login.a;
import static project.login.n;
import static project.adminLogin.a_t;
import static project.adminLogin.n_t;
import static project.adminLogin.isT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

// ����ڿ��� ���� ���� ������ ȭ��
public class index extends JFrame implements ActionListener{
	JPanel main_panel;
	JButton exit_btn, timetable_btn, login_btn, admin_btn;
	JTable table;
	JLabel lunch, lunch_title, title;
	
	public index() {
		boolean islunch = false;
		// ������ �޽��� �ҷ����� ���� ���� ��¥�� ���ϴ� �ڵ� 48 ~ 50 
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		String today = sdf.format(date);
		
		// ���� ��¥�� ���� �Ľ��ؿ� api �����Ϳ� ���Ͽ� ���� ��¥�� ã�� index ��ȣ�� �˾Ƴ��� �ڵ� 53 ~ 64
		int index = 0;
		for(int i = 0; i < mlsv_ymd.length; i++) {
			if(mlsv_ymd[i] == null) {
				islunch = false;
				break;
			}
			if(mlsv_ymd[i].equals(today)) {
				index = i;
				islunch = true;
				break;
			}
		}
		title = new JLabel("������");
		title.setFont(new Font("116watermelon", Font.BOLD, 50));
		
		setSize(1280, 720);
		setTitle("������ [ Sunrin Information ]");
		
		// ���� �޽� ������ �����Ѵٸ� ������ ���� �޴��� label�� �����ϰ� ���ٸ� �ٸ� �ڸ�Ʈ�� �����ϴ� �ڵ� 72 ~ 77
		if(islunch) {
			lunch = new JLabel("<html>" + ddish_nm[index] + "</html>");
		}
		else {
			lunch = new JLabel("��ϵ� �޽������� �����ϴ�.");
		}

		lunch_title = new JLabel("������ �޽�");
		login_btn = new JButton("�α���");
		main_panel = new JPanel();
		exit_btn = new JButton("����");
		timetable_btn = new JButton("�ð�ǥ");
		
		// ������ �������� �α����� ��� ������ �������� �̵��� �� �ִ� ��ư�� �����ϴ� �ڵ� 86 ~ 92
		if(isT) {
			admin_btn = new JButton("������ ������");
			admin_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 22));
			admin_btn.setBounds(980, 150, 200, 50);
			admin_btn.addActionListener(this);
			main_panel.add(admin_btn);
		}
		
		// ��Ʈ ���� 95 ~ 99
		lunch.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 18));
		lunch_title.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 22));
		login_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 18));
		exit_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 18));
		timetable_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 18));

		// layout ���� 102 ~ 109
		main_panel.setLayout(null);
		
		title.setBounds(600, -25, 200, 200);
		lunch_title.setBounds(550, 200, 200, 100);
		lunch.setBounds(550, 220, 300, 300);
		login_btn.setBounds(380, 150, 150, 50);
		exit_btn.setBounds(580, 150, 150, 50);
		timetable_btn.setBounds(780, 150, 150, 50);
		
		// ��ư Ŭ�� �̺�Ʈ 112 ~ 114
		login_btn.addActionListener(this);
		exit_btn.addActionListener(this);
		timetable_btn.addActionListener(this);
		
		// ������Ʈ�� panel ���� 117 ~ 122
		main_panel.add(title);
		main_panel.add(lunch_title);
		main_panel.add(lunch);
		main_panel.add(login_btn);
		main_panel.add(timetable_btn);
		main_panel.add(exit_btn);
		
		// ȭ�鿡 panel ��� 125 ~ 126
		add(main_panel);
		setVisible(true);
	}

	// ��ư Ŭ���̺�Ʈ 130 ~ 152
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == exit_btn) {
			// ���α׷��� �����ϴ� �ڵ�
			System.exit(0);
		}
		else if(obj == timetable_btn) {
			// �ð�ǥ Ŭ������ �̵��ϴ� �ڵ� 139 ~ 140
			setVisible(false);
			new timetable();
		}
		else if (obj == login_btn) {
			// login Ŭ������ �̵��ϴ� �ڵ� 144 ~ 145
			setVisible(false);
			new login();
		}
		else if (obj == admin_btn) {
			// admin Ŭ������ �̵��ϴ� �ڵ� 149 ~ 150
			setVisible(false);
			new admin();
		}
	}

	public static void main(String[] args) {
		// �ڵ尡 ó�� ����Ǹ� api���� ȣ���ϴ� �ڵ� 156 ~ 159
		getlunchAPI lunchapi = new getlunchAPI();
		getTimetableAPI timetableapi = new getTimetableAPI();
		lunchapi.main();
		timetableapi.main();
		new index();
	}
	
}
