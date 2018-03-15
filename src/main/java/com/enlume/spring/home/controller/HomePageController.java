package com.enlume.spring.home.controller;


import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.enlume.spring.dao.TransactionsDao;
import co.enlume.spring.model.Transactions;

@Controller
public class HomePageController {

	@Autowired TransactionsDao transactionsDao;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	String index()  {
		System.out.println("Entered HomePageController index handler method");
		return "testing ....";
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	List<Transactions> getAll()  {
		System.out.println("Entered HomePageController index handler method");
		
		return transactionsDao.findAll();
	}
	
	@RequestMapping(value = "/getFirstAndLastName", method = RequestMethod.GET)
	@ResponseBody
	List<Transactions> findByLastnameAndFirstname()  {
		System.out.println("Entered HomePageController index handler method");
		
		return transactionsDao.findByLastNameAndFirstName("Test","Test");
	}

	
}
