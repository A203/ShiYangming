package day02;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
//根据学生的分数输出学生的成绩等级
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		scanner.close();
		if(score>100||score<0){
			System.out.println("输入错误");
		}
		else if(score>=90){
			System.out.println("等级为A");
		}
		else if(score>=80){
			System.out.println("等级为B");
		}
		else if(score>=70){
			System.out.println("等级为C");
		}
		else if(score>=60){
			System.out.println("等级为D");
		}
		else{
			System.out.println("等级为E");
		}
	}

}
