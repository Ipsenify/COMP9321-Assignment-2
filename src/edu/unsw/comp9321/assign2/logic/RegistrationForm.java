package edu.unsw.comp9321.assign2.logic;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;

import org.hibernate.exception.ConstraintViolationException;

import edu.unsw.comp9321.assign2.common.DBUtil;
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

	public boolean isValid(String str) {
		return str != null && !str.isEmpty();
	}

	@Override
	public String processSubmit() throws ServletException, IOException {
		String password = param("password");
		String username = param("userName");
		String email = param("email");

		// Validate required fields
		if (!isValid(password) || !isValid(username) || !isValid(email)) {
			throw new ServletException(
					"The input you have enterered is corrupted.");
		}
		User user = new User();
		user.setFirstName(param("firstName"));
		user.setLastName(param("lastName"));
		user.setEmail(email);
		user.setUserName(username);
		user.setPassword(Helper.encrypt(password));
		user.setNickName(param("nickName"));
		user.setYearOfBirth(Helper.toInt(param("yearOfBirth")));
		user.setFullAddress(param("fullAddress"));
		user.setCreditCardNumber(param("creditCardNumber"));

		// Insert to database
		UserService service = DBUtil.getUserService();
		try {
			service.persist(user);

		} catch (Exception e) {
			throw new ServletException(
					"The input you have enterered is corrupted.");
		}
		// Send Confirmation Email
		ConfirmationEmail confirmEmail = new ConfirmationEmail(user,
				Helper.getURLWithContextPath(request));
		try {
			confirmEmail.send();
		} catch (MessagingException e) {
			// Failed to send email
			e.printStackTrace();
		}
		return "redirect:login";
	}

	@Override
	public boolean isPublic() {
		return true;
	}
}
