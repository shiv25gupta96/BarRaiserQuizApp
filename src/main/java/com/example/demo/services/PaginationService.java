package com.example.demo.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.demo.common.pojo.PaginationHeader;

@Component
public class PaginationService {

	public Pageable getPaginationVal(PaginationHeader header) {
		return PageRequest.of(header.getPageNumber() < 0 ? 0 : header.getPageNumber(), header.getLimit() < 0 ? 50 : header.getLimit());
	}

}
