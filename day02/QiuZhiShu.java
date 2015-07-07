package day02;

import java.util.Date;

public class QiuZhiShu {

	public static void main(String[] args) {
		Date d1 = new Date();
		for (int i = 2; i <= 100; i++) {
			boolean flag = true;
			for (int j = 2; j <= (int) Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag == true)
				System.out.println(i);
		}
		Date d2 = new Date();
		System.out.println(d2.getTime() - d1.getTime());
	}

}
