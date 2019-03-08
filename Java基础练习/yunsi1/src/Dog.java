/**
 * @author Jeremy
 * @date 2018-12-29
 * @time 下午2:08:32
 */

public class Dog {
	private String name;
	private int age;

	public void eat() {
		System.out.println("我是" + name + "我今年" + age + "我会啃骨头");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 得到属性
	public int getAge() {
		return age;
	}

	// 给属性赋值
	public void setAge(int age) {
		if (age <= 15) {
			this.age = age;
		} else {
			System.out.println("您输入的年龄有误");
		}
	}
	//无参构造
	public Dog() {
		
	}
	//有参构造
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

}
