package com.example.md4_exam.controller;

import com.example.md4_exam.model.Department;
import com.example.md4_exam.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/departments")
public class DepartmentController {
    final
    IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public ResponseEntity<Iterable<Department>> findAll(){
        List<Department> departmentList = (List<Department>) departmentService.findByAll();
        if(departmentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departmentList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Department> save(@RequestBody Department department){
       departmentService.save(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department){
        Optional<Department> optionalDepartment = departmentService.findById(id);
        if(!optionalDepartment.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        department.setId(id);
        return new ResponseEntity<>(departmentService.save(department), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Department> delete(@PathVariable Long id){
        Optional<Department> optionalDepartment = departmentService.findById(id);
        if(!optionalDepartment.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        departmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
