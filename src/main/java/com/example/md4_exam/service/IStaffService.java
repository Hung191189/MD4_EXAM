package com.example.md4_exam.service;

import com.example.md4_exam.model.Staff;

public interface IStaffService extends IGeneralService<Staff> {
    public Iterable<Staff> findAllByDepartmentId(Long id);
}
