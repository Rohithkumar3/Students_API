package Student_API.Student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Student_API.Student.model.Student;
import Student_API.Student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Student save(Student student)
	{
		return repo.save(student);
	}
	public List<Student> getAll()
	{
		return repo.findAll();
	}
	
	 public Optional<Student> getById(Long id)
	 {
		 return repo.findById(id);
	 }
}

