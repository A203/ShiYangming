package day03;

public class Student {
	private String name, address, num;

	public Student(String name, String address, String num) {
		this.name = name;
		this.address = address;
		this.num = num;
	}

	void ziWoJieShao() {
		System.out.println("我叫" + name + ",学号是" + num + "。我住在" + address
				+ ",请大家多多关照！");
	}

	public static void main(String[] args) {
		Student sym = new Student("施炀明", "12号楼702寝室", "2012214292");
		sym.ziWoJieShao();
		Student zs = new Student("钟    晟", "12号楼701寝室", "2012214304");
		zs.ziWoJieShao();

	}
}

