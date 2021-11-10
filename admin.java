package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class admin extends JFrame implements ActionListener{
	JPanel main_panel;
	JButton print_btn, exit_btn, add_name_btn, add_num_btn, del_btn, table_btn;
	JLabel lunch, lunch_title, title;
	JTextField name, num;
	
	public static Stack<String> name_stack = new Stack<>();
	public static Stack<String> num_stack = new Stack<>();
	
	public admin() {
		// JFrame �⺻ ���� (ȭ�� ������� frame title)
		setSize(1280, 720);
		setTitle("������ [ Sunrin Information ] ������");
		
		// ��ư, �ؽ�Ʈ �ʵ� �� JFrame�� �ִ� ������Ʈ ���� 35 ~ 43
		print_btn = new JButton("������ ����");
		table_btn = new JButton("������ ����");
		main_panel = new JPanel();
		exit_btn = new JButton("���ư���");
		add_name_btn = new JButton("�л� �߰�");
		add_num_btn = new JButton("�й� �߰�");
		del_btn = new JButton("�л� ����");
		name = new JTextField("�̸�");
		num = new JTextField("�й�");

		// ������Ʈ���� ��Ʈ ���� 46 ~ 50 
		table_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 18));
		exit_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 18));
		add_name_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 18));
		add_num_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 18));
		del_btn.setFont(new Font("G���� �꽺 TTF Bold", Font.BOLD, 18));

		// ������Ʈ���� Layout ���� 53 ~ 60
		print_btn.setBounds(530, 50, 150, 50);
		table_btn.setBounds(530, 50, 150, 50);
		name.setBounds(220, 150, 150, 50);
		num.setBounds(380, 150, 150, 50);
		add_name_btn.setBounds(540, 150, 150, 50);
		add_num_btn.setBounds(530, 150, 150, 50);
		del_btn.setBounds(730, 150, 150, 50);
		exit_btn.setBounds(930, 150, 150, 50);

		// �ǳ��� ���̾ƿ��� null�� ����� setBounds�� ���� Layout ������ ������ 63
		main_panel.setLayout(null);

		// ��ư Ŭ���̺�Ʈ ���� 66 ~ 71 
		print_btn.addActionListener(this);
		table_btn.addActionListener(this);
		add_name_btn.addActionListener(this);
		add_num_btn.addActionListener(this);
		del_btn.addActionListener(this);
		exit_btn.addActionListener(this);
		
		// ������Ʈ���� �ǳڿ� �߰� 74 ~ 81
//		main_panel.add(table_btn);
//		main_panel.add(print_btn);
		main_panel.add(name);
		main_panel.add(num);
		main_panel.add(exit_btn);
		main_panel.add(add_name_btn);
//		main_panel.add(add_num_btn);
		main_panel.add(del_btn);

		// �ǳ��� ȭ�鿡 ������ 84 ~ 85
		add(main_panel);
		setVisible(true);
	}

	// ��ư Ŭ���̺�Ʈ 
	@Override
	public void actionPerformed(ActionEvent e) {
		// ���� Ŭ���� ��ư�� �ҽ��� obj ������ �������� 92
		Object obj = e.getSource();
		// obj ������ ���� ��ư�� �ڵ带 ���Ͽ� ��� ��ư�� Ŭ���Ǿ����� Ȯ�� 94 ~ 119
		if(obj == exit_btn) {
			// ���� ���������ִ� admin frame�� ���� index Ŭ������ ȣ���Ͽ� �⺻ȭ������ ���ư� 96 ~ 97
			setVisible(false);
			new index();
		}
		else if(obj == add_name_btn) {
			// name_stack�� num_stack�� ���� name �ؽ�Ʈ �ʵ�� num �ؽ�Ʈ �ʵ忡 �ִ� �����͸� �������ְ� ����� 101 ~ 103
			name_stack.push(name.getText());
			num_stack.push(num.getText());
			new stackPrint();
		}
		else if(obj == add_num_btn) {
			// �ڵ尡 �����Ǹ鼭 ������� �ʴ� �ڵ� 
			new stackPrint();
		}
		else if(obj == del_btn) {
			// name_stack�� num_stack�� �����͸� �ϳ��� �����ϰ� ���� �����ִ� �����͸� ���
			name_stack.pop();
			num_stack.pop();
			new stackPrint();
		}
		else if(obj == table_btn) {
			// �ڵ尡 �����Ǹ鼭 ������� �ʴ� �ڵ�
			setVisible(false);
			new adminTable();
		}
	}
}
