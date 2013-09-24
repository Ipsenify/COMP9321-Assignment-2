package edu.unsw.comp9321.assign2.command;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.controller.DBUtil;
import edu.unsw.comp9321.assign2.model.User;
import edu.unsw.comp9321.assign2.notifications.ConfirmationEmail;
import edu.unsw.comp9321.assign2.service.UserService;
import edu.unsw.comp9321.assign2.util.Helper;

public class RegistrationForm extends AbstractForm {

	@Override
	public String processView() throws ServletException, IOException {
		if (!context.isAuthenticated()) {
			User user = new User();
			request.setAttribute("user", user);
			return "user/register.jsp";
		} else {
			// Redirect to view
			return "redirect:user/view";
		}
	}

	@Override
	public String processSubmit() throws ServletException, IOException {
		// required stuff: client side
		// check passwords match : client side
		// check yearofbirth is int: client side
		// check fields are clean: check full address (text area)
		// username is not taken: (ajax with server)
		// email is an actual email: client side
		// check credit card number is of length (16): client side

		User user = new User();
		user.setFirstName(param("user.firstName"));
		user.setLastName(param("user.lastName"));
		user.setEmail(param("user.email"));
		user.setUserName(param("user.userName"));
		user.setPassword(Helper.encrypt(param("user.password")));
		user.setNickName("");
		user.setYearOfBirth(Helper.toInt(param("user.yearOfBirth")));
		user.setFullAddress(param("user.fullAddress"));
		user.setCreditCardNumber(param("user.creditCardNumber"));

		// validate();

		// Add to database
		UserService service = DBUtil.getUserService();
		service.persist(user);

		// Send Confirmation Email
		ConfirmationEmail confirmEmail = new ConfirmationEmail(user,
				Helper.getURLWithContextPath(request));
		try {
			confirmEmail.send();
		} catch (MessagingException e) {
			// Failed to send email
			e.printStackTrace();
		}

		// Redirect to login page, maybe show a message to check email. // or
		// other page
		return "redirect:login";
	}

	@Override
	public boolean isPublic() {
		return true;
	}
}
