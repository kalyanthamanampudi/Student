package student.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import student.DTO.Student;
import student.ServiceImpl.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	StudentServiceImpl service;

	@PostMapping("/register")
	public String addStudent(@Valid @RequestBody Student st) {
		try {
			return service.registerNewStudent(st);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@PutMapping("/update/{roll_no}")
	public String updateStudentData(@PathVariable("roll_no") String roll_no,
			@RequestParam("fieldname") String fieldname, @RequestParam("value") String value) {
		try {
			return service.updateStudent(roll_no, fieldname, value);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@GetMapping("/AllStudents")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}

	@GetMapping("/Student/{roll_no}")
	public Student getStudentByRollNo(@PathVariable("roll_no") String roll_no) {
		return service.getStudent(roll_no);
	}

	@DeleteMapping("/delete/{roll_no}")
	public String deleteStudent(@PathVariable("roll_no") String roll_no) {
		return service.deleteStudent(roll_no);
	}

	@GetMapping("/Studentbyclass/{class_no}")
	public List<Student> getSameClassStudents(@PathVariable("class_no") String class_no) {
		return service.getStudentsOfSameClass(class_no);
	}

	@GetMapping("/StudentbyAge")
	public List<Student> getStudentsByAgeRange(@RequestParam("starting") int starting,
			@RequestParam("ending") int ending) {
		return service.getStudentsByAge(starting, ending);
	}

	@GetMapping("/averagestudents")
	public List<Student> getStudentsMoreThenAvgMarks() {
		return service.getStudentsByMarks();
	}

}
