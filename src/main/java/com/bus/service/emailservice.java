package com.bus.service;



import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.beans.Customer;
import com.bus.beans.OrderHistory;


 
// Annotation
@Service
@RestController

// Class
// Implementing EmailService interface
public class emailservice {
	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	  private JavaMailSender javaMailSender;
	  
	public void sendBookingEmail(Customer send,OrderHistory booking)  
	{

	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setTo(send.getEmail());
	    message.setSubject("Booking Confirmation");
	    message.setText("Hi " + booking.gethId() + ",\n\n"
	      + "Your booking for " + booking.getMovieName() + " has been confirmed.\n"
	      + "Date: " + booking.getBookOnDate() + "\n"
	      + "Name: " + booking.getCustomer() + "\n"
	      + "Seats: " + booking.getSeat() + "\n\n"
	      + "Thank you for using our online booking system.\n"
	      + "Regards,\n"
	      + "The Film Booking Team");
	   
	    
	    javaMailSender.send(message);
	  }

	 
	
}

	

	


 

