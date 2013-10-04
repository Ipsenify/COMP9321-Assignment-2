package edu.unsw.comp9321.assign2.notifications;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailService {
	
	private ThreadPoolExecutor executor;
	
	private MailSender mailSender;
	 
	@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public EmailService(){
		BlockingQueue<Runnable> mailQueue = new ArrayBlockingQueue<Runnable>(10);
		executor = new ThreadPoolExecutor(5, 20, 20, TimeUnit.SECONDS, mailQueue);
	}

	public void sendEmail(Email email) throws MessagingException {
		MailTask task = new MailTask(email);
		executor.execute(task);
	}
	
	public class MailTask implements Runnable
	{
		private Email email;
		
		public MailTask(Email email){
			this.email = email;
		}
		
		@Override
		public void run(){
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(this.email.getFrom());
			message.setTo(this.email.getTo());
			message.setSubject(this.email.getSubject());
			message.setText(this.email.getText());
			mailSender.send(message);
		}
	}
}