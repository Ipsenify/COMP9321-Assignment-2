package edu.unsw.comp9321.assign2.logic.admin;

import edu.unsw.comp9321.assign2.logic.AbstractAction;

public class AdminAction extends AbstractAction {

	@Override
	public boolean isPublic(){
		// Other form of guarded views
		return true;
	}
}
