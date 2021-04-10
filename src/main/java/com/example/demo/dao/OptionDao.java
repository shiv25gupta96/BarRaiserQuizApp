package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Option;

@Component
public interface OptionDao extends JpaRepository<Option, Integer> {

}
