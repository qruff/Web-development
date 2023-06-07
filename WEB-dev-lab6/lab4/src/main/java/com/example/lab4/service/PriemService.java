package com.example.lab4.service;

import com.example.lab4.Entity.Priem;

import java.util.List;

public interface PriemService {
    List<Priem> getAllPriem();
    void savePriem(Priem priem);
    void deletePriemById(Long id);
    Priem getPriemById(Long id);
    void editPriem(Priem priem);
}
