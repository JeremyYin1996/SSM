/**
 * @author Jeremy
 * @date 2018-12-29
 * @time ����2:08:32
 */

public class Dog {
	private String name;
	private int age;

	public void eat() {
		System.out.println("����" + name + "�ҽ���" + age + "�һ�й�ͷ");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// �õ�����
	public int getAge() {
		return age;
	}

	// �����Ը�ֵ
	public void setAge(int age) {
		if (age <= 15) {
			this.age = age;
		} else {
			System.out.println("���������������");
		}
	}
	//�޲ι���
	public Dog() {
		
	}
	//�вι���
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

}
