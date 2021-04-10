package com.example.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Response;

@Repository
public interface ResponseDao extends PagingAndSortingRepository<Response, Integer> {

}
