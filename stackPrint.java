package project;

import static project.admin.name_stack;
import static project.admin.num_stack;

public class stackPrint {
	public stackPrint() {
		// stack�� �����Ͱ� ������ ���� ����� �����͸� ����ϴ� �Լ� 9 ~ 16
		System.out.println("##############");
		if(!name_stack.empty()) {
			System.out.println("�̸� : "+name_stack.peek());	
		}	 
		if(!num_stack.empty()) {
			System.out.println("�й� : "+num_stack.peek());	
		}
		System.out.println("##############");
	}
}
