package com.example.lab5vaadin.data.service;

import com.example.lab5vaadin.data.entity.Priem;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
@Configuration
@Service
public interface PriemService {
    List<Priem> getAllPriems();
    void savePriem(Priem priem);
    void deletePriemById(Long id);
    Priem getPriemById(Long id);
    void editPriem(Priem priem);
}
