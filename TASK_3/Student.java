import java.util.Arrays;


public class Student{
	public Student(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	public Student(int id, String name, String surname, int age,
			String group, String[] grades, int debt) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.group = group;
		this.grades = Arrays.stream(grades).mapToInt(Integer::parseInt).toArray();
	}
	String name,surname,group;
	int age,debt;
	int grades[];
	int id;
	public String toString(){
		return id+" "+name+" "+surname+" "+age+" "+group+" "+Arrays.toString(grades);
	}
}
