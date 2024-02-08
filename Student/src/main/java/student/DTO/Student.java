package student.DTO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Scope("prototype")
public class Student {

	private int roll_no;

	@NotNull(message = "name is not null")
	@NotBlank(message = "name is required")
	@Size(max = 30, message = "name should be at most 30 characters")
	private String name;

	@NotNull(message = "name is not null")
	private int class_no;

	@Min(value = 10, message = "age should be more then 10")
	@Max(value = 20, message = "age should be less then 20")
	private int age;

	@Max(value = 100, message = "marks should be less then 100")
	private float marks;

	public Student() {
	}

	public Student(int roll_no, String name, int class_no, int age, float marks) {
		this.roll_no = roll_no;
		this.name = name;
		this.class_no = class_no;
		this.age = age;
		this.marks = marks;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClass_no() {
		return class_no;
	}

	public void setClass_no(int class_no) {
		this.class_no = class_no;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + ", class_no=" + class_no + ", age=" + age + ", marks="
				+ marks + "]";
	}

}
