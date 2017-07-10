package dymall;

public class Test {
public static void main(String[] args) {
	Person p1=new Person("张三");
	Person p2=new Person("张三");
	System.out.println(p1.equals(p2));
}
}
class Person{
	private String name;
	Person(String name){
		this.name=name;
		
	}
}