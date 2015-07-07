package day02;

import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		scanner.close();
		if (score < 0 || score > 100) {
			System.out.println("输入错误");
		} else {
			if (score >= 60) {
				System.out.println("成绩合格");
			} else {
				System.out.println("成绩不合格");
			}
		}

	}

}
