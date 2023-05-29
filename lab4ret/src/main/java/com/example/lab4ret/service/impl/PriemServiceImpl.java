package com.example.lab4ret.service.impl;


import com.example.lab4ret.entity.Priem;
import com.example.lab4ret.repository.PriemRepository;
import com.example.lab4ret.service.PriemService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriemServiceImpl implements PriemService {
    private final PriemRepository priemRepository;

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
    public Priem getPriemById(Long id) {
        return priemRepository.findById(id).get();
    }

    @Override
    public void deletePriemById(Long id) {
        priemRepository.deleteById(id);
    }

    @Override
    public void editPriem(Priem priem) {
        priemRepository.save(priem);
    }
}
