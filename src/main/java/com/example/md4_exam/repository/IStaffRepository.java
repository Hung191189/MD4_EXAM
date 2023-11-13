package com.example.md4_exam.repository;

import com.example.md4_exam.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffRepository extends JpaRepository<Staff, Long> {
    Iterable<Staff> findAllByDepartmentId(Long id);
}
