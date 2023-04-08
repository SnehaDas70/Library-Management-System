package com.xfactor.openlibrary.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xfactor.openlibrary.Domain.Student;
import java.util.List;

public interface StudentRepositories extends JpaRepository<Student, Long> {

    List<Student> findByname(String name);

    List<Student> findBydepartment(String department);

    List<Student> findByrollNumber(String rollNumber);

    List<Student> findBybirthDate(String birthDate);

    List<Student> findBymobileNumber(String mobileNumber);
}
