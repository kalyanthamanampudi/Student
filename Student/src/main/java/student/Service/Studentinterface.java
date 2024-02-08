package student.Service;

import java.util.List;

import student.DTO.Student;


public interface Studentinterface {
	
	public String registerNewStudent(Student s);
	
	public String updateStudent(String roll_no, String fieldname, String value);
	
	public List<Student> getAllStudents();
	
	public Student getStudent(String roll_no);
	
	public String deleteStudent(String roll_no);
	
	public List<Student> getStudentsOfSameClass(String class_no);
	
	public List<Student> getStudentsByAge(int starting, int ending);
	
	public List<Student> getStudentsByMarks();

}
