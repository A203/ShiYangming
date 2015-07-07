package day02;

public class Demo6 {

	public static void main(String[] args) {
		for (int i = 1; i <= 100;) {
			System.out.print(i++ + " ");
		}
		System.out.println();
		// int j=1;
		// while(j<=100){
		// System.out.print(j+++" ");
		// }
		int[] a = { 1, 2, 3, 4 };
		for (int i : a) {
			System.out.println(i);
		}
	}
}
