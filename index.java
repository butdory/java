package test;
import java.awt.Container;
import java.awt.*; 
import javax.swing.*;


import javax.swing.JFrame;

public class index extends JFrame{
	
	public index() {
		setTitle("���� ������");
		setSize(1280 , 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton my_btn_1 = new JButton("Ȯ��");
		JButton my_btn_2 = new JButton("���");
		
		c.add(my_btn_1);
		c.add(my_btn_2);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] age = {16, 17, 18, 16};
		String[] name = {"������", "��â��", "������", "������"};
		
		interfacetest getstudent = new interfacetest();
		System.out.println(getstudent.getName(name, 3));
		System.out.println(getstudent.getAge(age, 3));
		new index();
	}

}
