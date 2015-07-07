package day02;

public class Score {
	static void setScore(int a[][]) {
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 5; j++) {
				a[i][j] = (int) (Math.random() * 100);
			}

	}

	static void printScore(int a[][]) {
		int b[] = sumScore(a);
		System.out.print("学号\tcore C++\tcoreJava\tServlet\t\tJSP\t\tEJB\t\t总分");
		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print(i + 1 + "\t");
			for (int j = 0; j < 5; j++)
				System.out.print(a[i][j] + "\t\t");
			System.out.print(b[i] + "\n");
		}
	}

	static int[] sumScore(int a[][]) {
		int[] b = new int[20];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 5; j++)
				b[i] += a[i][j];
		}
		return b;
	}

	static void average(int a[][]) {
		System.out.print("平均分\t");
		for (int i = 0; i < 5; i++) {
			int Average = 0;
			for (int j = 0; j < 20; j++)
				Average += a[j][i];
			System.out.print(Average / 20.0 + "\t\t");
		}
	}

	public static void main(String[] args) {
		int[][] Chengji = new int[20][5];
		setScore(Chengji);
		printScore(Chengji);
		average(Chengji);

	}
}
