package co.enlume.spring.config;

import java.math.BigInteger;
import java.util.Random;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import co.enlume.spring.dao.TransactionsDao;
import co.enlume.spring.model.Transactions;

@Component
public class RabbitConfiguration {
	
	 @Bean
	    public ConnectionFactory connectionFactory() {
		 
		 CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");

		 connectionFactory.setUsername("guest");
		 connectionFactory.setPassword("guest");
		// connectionFactory.setPort(15672);

	        return connectionFactory;
	    }

	    @Autowired TransactionsDao transactionsDao;
	 
	 
	    @Bean
	    public AmqpAdmin amqpAdmin() {
	        return new RabbitAdmin(connectionFactory());
	    }

	    @Bean
	    public RabbitTemplate rabbitTemplate() {
	    	RabbitTemplate template = new RabbitTemplate(connectionFactory());
	        template.setMessageConverter(jsonMessageConverter());
	       // configureRabbitTemplate(template);
	        return template;
	    }

	    @Bean
	    public Queue myQueue() {
	       return new Queue("spring_test");
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
	    
	    @Bean
	    public SimpleMessageListenerContainer replyListenerContainer() {
	        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	        container.setConnectionFactory(connectionFactory());
	        container.setQueues(myQueue());
	        container.setMessageListener(exampleListener());
	        return container;
	    }
	    
	    @Bean
	    public MessageConverter jsonMessageConverter() {
	        return new Jackson2JsonMessageConverter();
	    }
	    
	    @Bean
	    public MessageListener exampleListener() {
	        return new MessageListenerAdapter() {
	        
	            public void onMessage(Message message) {
	                System.out.println("received ******: " + message);
	                Transactions transactions = new Transactions();
	     	       Random rand = new Random();
	     	       transactions.setFiName("Received");
	     		   transactions.setLastName("Rabbit");
	     		   transactions.setTransactionId(BigInteger.valueOf(rand.nextInt(1000000)));
	     			
	     		   transactionsDao.save(transactions).getTransactionId();
	                
	            }
	        };
	    }
	    
	
}