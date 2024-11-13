package com.classicmodels.classicmodelsservice.serviceImpl;


import java.util.List;

import com.classicmodels.classicmodelsservice.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classicmodels.classicmodelsservice.entity.Office;
import com.classicmodels.classicmodelsservice.repository.OfficeRepository;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository officeRepository;  // Corrected repository variable

    @Override
    public List<Office> findAll() {
        return officeRepository.findAll();
    }

    @Override
    public Office findById(int id) {
        return officeRepository.findById(id).orElse(null);
    }

    @Override
    public Office save(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public void deleteById(int id) {
        officeRepository.deleteById(id);
    }
}