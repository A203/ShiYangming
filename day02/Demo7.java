package day02;

import java.util.Scanner;

public class Demo7 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println("");
		}
	}

}
