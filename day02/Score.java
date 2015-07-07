package day02;

public class Score {
	
	
	static void setScore(int a[][]){
		for(int i = 0;i<20;i++)
			for(int j = 0;j<5;j++)
				a[i][j]=(int)(Math.random()*100);
	}
	
	static void printScore(int a[][]){
		for(int i = 0;i<20;i++){
			System.out.println("第"+(i+1)+"个同学五门课的成绩：");
			for(int j = 0;j<5; j++)
				System.out.print(a[i][j]+"  ");
			System.out.println("");
		}		
	}
	
	static int[] sumScore(int a[][]){
		int[] b=new int[20];
		for(int i = 0;i<20;i++){
			for(int j = 0;j<5;j++)
			b[i]+=a[i][j];
		System.out.println("第"+(i+1)+"个同学的总成绩为"+b[i]+" ");
		}		
		return b;
	}
	
	static void  average(int a[][],int i){
		int Average = 0;
		for(int j=0;j<20;j++)
			Average+=a[j][i];
		switch (i) {
		case 0:
			System.out.print("coreC++的平均成绩是");
			break;
		case 1:
			System.out.print("corejava的平均成绩是");
			break;
		case 2:
			System.out.print("Servlet的平均成绩是");
			break;
		case 3:
			System.out.print("JSP的平均成绩是");
			break;
		case 4:
			System.out.print("EJB的平均成绩是");
			break;
		default:
			return;
		}
		System.out.println(Average/20);		
	}
	
	public static void main(String[] args) {
		int [][]Chengji=new int[20][5];
		setScore(Chengji);
		printScore(Chengji);
		average(Chengji, 4);
		sumScore(Chengji);		
	}
}
