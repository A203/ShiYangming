package day02;

public class ChengFaBiao {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print(i + "x" + j + "=" + (i * j) + " ");
			System.out.println("");
		}
	}
}
