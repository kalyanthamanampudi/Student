package student.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import student.DTO.Student;
import student.Repository.StudentRepository;
import student.Service.Studentinterface;

@Service
public class StudentServiceImpl implements Studentinterface {

	@Autowired
	StudentRepository repo;

	@Override
	public String registerNewStudent(Student s) {
		return repo.registerNewStudent(s);
	}

	@Override
	public String updateStudent(String roll_no, String fieldname, String value) {
		try {
			if ((fieldname.equals("age") && 10 <= Integer.parseInt(value) && Integer.parseInt(value) <= 20)
					|| (fieldname.equals("marks") && Integer.parseInt(value) <= 100)) {
				return repo.updateStudent(roll_no, fieldname, value);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"age should be between 10 to 20 and marks should be less then 100");
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.getAllStudents();
	}

	@Override
	public Student getStudent(String roll_no) {
		return repo.getStudent(roll_no);
	}

	@Override
	public String deleteStudent(String roll_no) {
		return repo.deleteStudent(roll_no);
	}

	@Override
	public List<Student> getStudentsOfSameClass(String class_no) {
		return repo.getStudentsOfSameClass(class_no);
	}

	@Override
	public List<Student> getStudentsByAge(int starting, int ending) {
		return repo.getStudentsByAge(starting, ending);
	}

	public List<Student> getStudentsByMarks() {
		return repo.getStudentByMarks();
	}

}
