package com.example.md4_exam.controller;

import com.example.md4_exam.model.Staff;
import com.example.md4_exam.service.IStaffService;
import com.example.md4_exam.service.impl.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/staffs")
public class StaffController {
    final
    IStaffService staffService;

    public StaffController(IStaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Staff>> findAll(){
        List<Staff> staffList = (List<Staff>) staffService.findByAll();
        if(staffList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staffList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Staff> findById(@PathVariable Long id){
        Optional<Staff> optionalStaff = staffService.findById(id);
        return new ResponseEntity<>(optionalStaff.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Staff> save(@RequestBody Staff staff){
        staffService.save(staff);
        return new ResponseEntity<>(staff, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staff){
        Optional<Staff> optionalStaff = staffService.findById(id);
        if(!optionalStaff.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staff.setId(id);
        return new ResponseEntity<>(staffService.save(staff), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Staff> delete(@PathVariable Long id){
        Optional<Staff> optionalStaff = staffService.findById(id);
        if(!optionalStaff.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        staffService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/DBD/{id}")
    ResponseEntity<Iterable<Staff>> findByDepartmentId(@PathVariable Long id) {
        List<Staff> staffList = (List<Staff>) staffService.findAllByDepartmentId(id);
        if (staffList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staffList, HttpStatus.OK);
    }

}
