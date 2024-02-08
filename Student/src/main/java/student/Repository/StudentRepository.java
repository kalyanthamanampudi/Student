package student.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import student.DTO.Student;

@Component
public class StudentRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public String registerNewStudent(Student st) {
		String sql = "insert into students (name, class_no, age, marks) VALUES (:name, :class_no, :age, :marks)";
		SqlParameterSource assign = new MapSqlParameterSource("name", st.getName())
				.addValue("class_no", st.getClass_no()).addValue("age", st.getAge()).addValue("marks", st.getMarks());
		int result = namedParameterJdbcTemplate.update(sql, assign);

		if (result > 0) {
			return "Marks updated successfully";
		} else
			return "No student found with the provided roll number.";
	}

	public String updateStudent(String roll_no, String fieldname, String value) {
		String sql = "update students set " + fieldname + " = :value where roll_no = :roll_no";
		SqlParameterSource assign = new MapSqlParameterSource("value", value).addValue("roll_no", roll_no);
		int result = namedParameterJdbcTemplate.update(sql, assign);
		if (result > 0) {
			return fieldname + " updated successfully";
		} else {
			return "No student found with the provided roll number.";
		}
	}

	public List<Student> getAllStudents() {
		String sql = "Select * from students";
		List<Student> students = namedParameterJdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Student.class));
		return students;
	}

	public Student getStudent(String roll_no) {
		String sql = "SELECT * FROM students WHERE roll_no = :roll_no";
		SqlParameterSource assign = new MapSqlParameterSource("roll_no", roll_no);
		Student st = namedParameterJdbcTemplate.queryForObject(sql, assign, new BeanPropertyRowMapper<>(Student.class));
		return st;
	}

	public String deleteStudent(String roll_no) {
		String sql = "delete from students WHERE roll_no = :roll_no";
		SqlParameterSource assign = new MapSqlParameterSource("roll_no", roll_no);
		int result = namedParameterJdbcTemplate.update(sql, assign);
		if (result > 0) {
			return " deleted successfully";
		} else {
			return "No student found with the provided roll number.";
		}
	}

	public List<Student> getStudentsOfSameClass(String class_no) {
		String sql = "select * from students where class_no = :class_no";
		SqlParameterSource assign = new MapSqlParameterSource("class_no", class_no);
		List<Student> st = namedParameterJdbcTemplate.query(sql, assign, new BeanPropertyRowMapper<>(Student.class));
		return st;
	}

	public List<Student> getStudentsByAge(int starting, int ending) {
		String sql = "select * from students where age between :starting and :ending";
		SqlParameterSource assign = new MapSqlParameterSource("starting", starting).addValue("ending", ending);
		List<Student> st = namedParameterJdbcTemplate.query(sql, assign, new BeanPropertyRowMapper<>(Student.class));
		return st;
	}

	public List<Student> getStudentByMarks() {
		String sql = "select * from students where marks > (select avg(marks) from students)";
		List<Student> st = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
		return st;
	}

}
