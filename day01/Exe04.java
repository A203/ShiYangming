package day01;

import java.util.ArrayList;
import java.util.Scanner;

public class Exe04 {
	
	static void print(ArrayList<String> A){
		System.out.println("ѧ������:");
		for(int i=0;i<A.size();i++)
			System.out.println(A.get(i));
	}	
	
	static void show(){
		System.out.println("| 1. ����1��ѧ�� |");
		System.out.println("| 2. ��ʾ����ѧ�� |");
		System.out.println("| 3. �˳����� |");
		System.out.println("| ������ѡ��1-3����");
	}
	
		public static void main(String[] args) {
			ArrayList<String> Student= new ArrayList<String>();
			show();
		while(true){
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			switch (scanner.next()) {
			case "1":	
				System.out.println("������ѧ������:");
				Student.add(scanner.next());
				show();
				break;
			case "2":
				print(Student);
				show();
				break;
			case "3":				
				return;
			default:
				System.out.println("������ѡ��:");
			}		
		}		
	}

}
