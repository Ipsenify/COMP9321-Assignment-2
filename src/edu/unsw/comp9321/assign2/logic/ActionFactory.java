package edu.unsw.comp9321.assign2.logic;

import java.util.HashMap;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.logic.admin.AJAXBanUser;
import edu.unsw.comp9321.assign2.logic.admin.AJAXDeleteAuction;
import edu.unsw.comp9321.assign2.logic.admin.AJAXUnBanUser;
import edu.unsw.comp9321.assign2.logic.admin.AJAXUpdateAuctionStatus;
import edu.unsw.comp9321.assign2.logic.admin.AdminAuctionsPage;
import edu.unsw.comp9321.assign2.logic.admin.AdminPanelPage;
import edu.unsw.comp9321.assign2.logic.admin.AdminUsersPage;

public class ActionFactory {

	private static final ActionFactory commandFactory = new ActionFactory();

	public static ActionFactory getInstance() {
		return commandFactory;
	}

	private HashMap<String, Class<?>> map;

	private ActionFactory() {
		map = new HashMap<String, Class<?>>();
		map.put("/", IndexPage.class);
		map.put("/index", IndexPage.class);
		map.put("/home", IndexPage.class);
		map.put("/login", LoginForm.class);
		map.put("/logout", LogoutAction.class);
		map.put("/register", RegistrationPage.class);
		map.put("/search", SearchPage.class);
		map.put("/user/confirm", ConfirmationService.class);
		map.put("/user/register", RegistrationForm.class);

		map.put("/user/update", UpdateProfileForm.class);
		map.put("/user/changepassword", ChangePasswordForm.class);
		map.put("/user/view", ViewProfilePage.class);
		map.put("/user/validateusername", AJAXUserNameValidator.class);
		
		map.put("/auction/create", CreateAuctionForm.class);
		//map.put("/auction/update", UpdateAuctionForm.class);
		map.put("/auction/view", ViewAuctionPage.class);
		map.put("/auction/image", AuctionPictureRenderer.class);
		map.put("/auction/bid", AuctionBidForm.class);
		map.put("/my/auctions", ViewMyAuctionsPage.class);
		map.put("/my/auctions/accept", AJAXAcceptAuctionOffer.class);
		map.put("/my/auctions/reject", AJAXAcceptAuctionOffer.class);

		map.put("/admin/", AdminPanelPage.class);
		map.put("/admin/auctions/", AdminAuctionsPage.class);
		map.put("/admin/auctions/updateauctionstatus", AJAXUpdateAuctionStatus.class);
		map.put("/admin/auctions/deleteauction", AJAXDeleteAuction.class);
		map.put("/admin/users/", AdminUsersPage.class);
		map.put("/admin/users/banuser", AJAXBanUser.class);
		map.put("/admin/users/unbanuser", AJAXUnBanUser.class);
	}

	public Action getAction(String actionStr) throws ServletException {
		if (map.containsKey(actionStr)) {
			try {
				Class<?> cls = map.get(actionStr);
				return (Action) Class.forName(cls.getName()).newInstance();
			} catch (Exception e) {
				throw new ServletException(e);
			}
		} else {
			return null;
		}
	}
}
