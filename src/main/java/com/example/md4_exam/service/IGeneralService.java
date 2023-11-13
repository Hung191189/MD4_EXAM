package com.example.md4_exam.service;

import java.util.Iterator;
import java.util.Optional;

public interface IGeneralService<H> {
    Iterable<H> findByAll();
    Optional<H> findById(Long id);
    H save (H h);
    void delete(Long id);
}
