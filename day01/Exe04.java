package day01;

import java.util.ArrayList;
import java.util.Scanner;

public class Exe04 {
	
	static void print(ArrayList<String> A){
		System.out.println("学生姓名:");
		for(int i=0;i<A.size();i++)
			System.out.println(A.get(i));
	}	
	
	static void show(){
		System.out.println("| 1. 增加1个学生 |");
		System.out.println("| 2. 显示所有学生 |");
		System.out.println("| 3. 退出程序 |");
		System.out.println("| 请输入选择（1-3）：");
	}
	
		public static void main(String[] args) {
			ArrayList<String> Student= new ArrayList<String>();
			show();
		while(true){
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			switch (scanner.next()) {
			case "1":	
				System.out.println("请输入学生姓名:");
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
				System.out.println("请重新选择:");
			}		
		}		
	}

}
