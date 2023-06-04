package com.example.lab4.service.impl;

import com.example.lab4.Entity.Priem;
import com.example.lab4.repository.PriemRepository;
import com.example.lab4.service.PriemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriemImpl implements PriemService {
    private final PriemRepository priemRepository;

    public PriemImpl(PriemRepository priemRepository) {
        super();
        this.priemRepository = priemRepository;
    }

    @Override
    public List<Priem> getAllPriem() {
        return priemRepository.findAll();
    }

    @Override
    public void savePriem(Priem priem) {
            priemRepository.save(priem);
    }

    @Override
    public void deletePriemById(Long id) {
        //Priem priem =  priemRepository.findById(id).get();
        //priem.setActive(false);
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
