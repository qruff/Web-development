package com.example.lab4ret.service;

import com.example.lab4ret.entity.Priem;

import java.util.List;

public interface PriemService {
    List<Priem> getAllPriems();
    void savePriem(Priem priem);
    void deletePriemById(Long id);
    Priem getPriemById(Long id);
    void editPriem(Priem priem);
}
