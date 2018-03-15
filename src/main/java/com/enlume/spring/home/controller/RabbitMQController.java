package com.enlume.spring.home.controller;


import java.math.BigInteger;
import java.util.Random;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import co.enlume.spring.dao.TransactionsDao;
import co.enlume.spring.model.Transactions;

@Controller
public class RabbitMQController {

	@Autowired TransactionsDao transactionsDao;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RequestMapping(value = "/saveTransactions", method = RequestMethod.POST)
	@ResponseBody
	void saveTransactions()  {
		System.out.println("Entered RabbitMQController index handler method");
		Transactions transactions = new Transactions();
        Random rand = new Random();

		transactions.setFiName("Send");
		transactions.setLastName("Rabbit");
		transactions.setTransactionId(BigInteger.valueOf(rand.nextInt(1000000)));
		
		BigInteger Id = transactionsDao.save(transactions).getTransactionId();
		rabbitTemplate.convertAndSend("spring_test", transactions);
		
		//rabbitTemplate.convertAndSend("spring_test", transactions);;
		
		System.out.println("Saved Transactions");
	}
	
	
	/*@RabbitListener(queues = "spring_test")
    public void processMessage(BigInteger Id) {
       System.out.println("Entered in RabbitMQ Recever ---->"+Id);
       Transactions transactions = new Transactions();
       Random rand = new Random();
       transactions.setFiName("Send");
		transactions.setLastName("Rabbit");
		transactions.setTransactionId(BigInteger.valueOf(rand.nextInt(1000000)));
		
		 transactionsDao.save(transactions).getTransactionId();
    }*/
}
