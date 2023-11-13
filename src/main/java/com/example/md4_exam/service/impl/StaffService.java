package com.example.md4_exam.service.impl;

import com.example.md4_exam.model.Staff;
import com.example.md4_exam.repository.IStaffRepository;
import com.example.md4_exam.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StaffService implements IStaffService {
    @Autowired
    IStaffRepository staffRepository;
    @Override
    public Iterable<Staff> findByAll() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }
    @Override
    public Iterable<Staff> findAllByDepartmentId(Long id) {
        return staffRepository.findAllByDepartmentId(id);
    }
}
