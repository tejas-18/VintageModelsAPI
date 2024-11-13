package com.classicmodels.classicmodelsservice.service;

import java.util.List;
import com.classicmodels.classicmodelsservice.entity.Office;

public interface OfficeService {
    List<Office> findAll();
    Office findById(int id);
    Office save(Office office);
    void deleteById(int id);
}