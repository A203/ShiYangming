package day02;

public class MaoPaoSort {
	static void sort(int a[]) {
		// TODO 自动生成的构造函数存根
		int temp;
		for (int i = 0; i < a.length-1; i++)
			for (int j = 0; j < a.length - i-1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
	}

	static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a[] = { 8, 5, 7, 4 , 20 };
		sort(a);
		printArray(a);
	}
}
