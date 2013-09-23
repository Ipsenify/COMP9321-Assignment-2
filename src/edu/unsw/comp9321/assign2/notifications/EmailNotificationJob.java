package edu.unsw.comp9321.assign2.notifications;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EmailNotificationJob implements Job {

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// Check for out of date auctions

		System.out.println("Sending email to: at" + new Date());
		// Send notification to user for each

		/*
		try {
			EmailService service = new EmailService();

			Email email = new Email();
			email.setFrom("admin@ibuy.com");
			email.setTo("sam.elhusseini@gmail.com");
			email.setSubject("Hello world");
			email.setText("Hello world...");

			
			 //msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
			 //"sam.elhusseini@gmail.com", "Sam El"));
			 

			service.sendEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}