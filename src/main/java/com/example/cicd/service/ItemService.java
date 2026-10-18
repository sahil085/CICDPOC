package com.example.cicd.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

	public List<String> getItems() {
		return List.of("Build", "Test", "Deploy");
	}
}
