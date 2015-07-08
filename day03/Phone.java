package day03;

public class Phone {
	private String name, brand;
	private int price;
	public Phone(){}

	public Phone(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	void call() {
		System.out.println("打电话");
	}

	void sendMessage() {
		System.out.println("发短信");
	}

	public static void main(String[] args) {
		Phone phone = new Phone("我的手机", "iphone6 plus", 5200);
		System.out.println("手机的名字：" + phone.name + "\n" + "手机的品牌:"
				+ phone.brand + "\n" + "手机的价格:" + phone.price);
		phone.call();
		phone.sendMessage();

	}

}
