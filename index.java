package test;
import java.awt.Container;
import java.awt.*; 
import javax.swing.*;


import javax.swing.JFrame;

public class index extends JFrame{
	
	public index(String name, int age) {
		setTitle("���� ������");
		setSize(1280 , 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		String char_age = Integer.toString(age);
		JLabel my_label_1 = new JLabel(name);
		JLabel my_label_2 = new JLabel(char_age);
		
		String header[] = {"�̸�", "����"};
		String contents[][] = {{name, char_age}};
		
		JTable table = new JTable(contents, header);
		
		c.add(my_label_1);
		c.add(my_label_2);
		c.add(table);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] age = {16, 17, 18, 16};
		String[] name = {"������", "��â��", "������", "������"};
		
		interfacetest getstudent = new interfacetest();
		new index(getstudent.getName(name, 3), getstudent.getAge(age, 3));
	}

}
