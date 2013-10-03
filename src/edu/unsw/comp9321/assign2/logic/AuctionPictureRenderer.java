package edu.unsw.comp9321.assign2.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;

import edu.unsw.comp9321.assign2.common.DBUtil;
import edu.unsw.comp9321.assign2.model.Auction;
import edu.unsw.comp9321.assign2.service.AuctionService;
import edu.unsw.comp9321.assign2.util.Helper;

public class AuctionPictureRenderer extends AbstractAction {

	@Override
	public String processView() throws ServletException, IOException {
		AuctionService service = DBUtil.getAuctionService();
		Long id = Helper.toLong(request.getParameter("id"));
		Auction auction = service.findById(id);

		response.setContentType("image/png");

		byte[] picture = auction.getPicture();

		if (picture == null) {
			// Placeholder image
			File file = new File(request.getServletContext().getRealPath(
					"/theme/img/placeholder.jpg"));
			picture = new byte[(int) file.length()];
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				fileInputStream.read(picture);
				fileInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		response.setContentType("image/png");
		response.setContentLength(picture.length);

		OutputStream out = response.getOutputStream();
		out.write(picture, 0, picture.length);

		return "";
	}

	@Override
	public boolean isPublic() {
		return true;
	}
}
