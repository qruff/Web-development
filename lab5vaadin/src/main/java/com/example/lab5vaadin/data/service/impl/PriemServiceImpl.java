package com.example.lab5vaadin.data.service.impl;

import com.example.lab5vaadin.data.entity.Priem;
import com.example.lab5vaadin.data.repository.PriemRepository;
import com.example.lab5vaadin.data.service.PriemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriemServiceImpl implements PriemService {
    private final PriemRepository priemRepository;

    @Autowired
    public PriemServiceImpl(PriemRepository priemRepository) {
        super();
        this.priemRepository = priemRepository;
    }

    @Override
    public List<Priem> getAllPriems() {
        return priemRepository.findAll();
    }

    @Override
    public void savePriem(Priem priem) {
        priemRepository.save(priem);
    }

    @Override
    public void deletePriemById(Long id) {
        priemRepository.deleteById(id);
    }

    @Override
    public Priem getPriemById(Long id) {
        return priemRepository.findById(id).get();
    }

    @Override
    public void editPriem(Priem priem) {
        priemRepository.save(priem);
    }
}
