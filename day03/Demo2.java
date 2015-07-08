package day03;
abstract class Fruit{
	String name;
	abstract String getName();
}

class Apple extends Fruit{
	String getName(){
		return "苹果";
	}
	
} 

class Watermellon extends Fruit{
	String getName(){
		return "西瓜";
	}	
}

class Orange extends Fruit{
	String getName(){
		return "橘子";
	}	
}




public class Demo2 {
	
	static void zhaZhi(Fruit fruit){
		System.out.println("榨"+fruit.getName()+"汁");
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根	
		zhaZhi(new Orange());
		zhaZhi(new Apple());
		zhaZhi(new Watermellon());

	}

}
