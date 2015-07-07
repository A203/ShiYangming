package day02;

import java.util.Scanner;

public class Demo8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num - i; j++)
				System.out.print(" ");
			for (int j = 1; j <= 2 * i - 1; j++)
				if (i <= 9)
					System.out.print(i);
				else {
					System.out.print((char) ('A' + i));
				}
			System.out.println();
		}
	}
}
