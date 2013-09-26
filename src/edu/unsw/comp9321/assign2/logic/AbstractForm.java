package edu.unsw.comp9321.assign2.logic;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractForm extends AbstractAction {
	
	private List<String> errors = new ArrayList<String>();
	private List<String> warnings = new ArrayList<String>();
	private List<String> infos = new ArrayList<String>();
	private List<String> successes = new ArrayList<String>();
	
	public void setError(String error){
		errors.add(error);
	}
	
	public void setWarning(String warning){
		warnings.add(warning);
	}
	
	public void setInfo(String info){
		infos.add(info);
	}
	
	public void setSuccess(String success){
		successes.add(success);
	}
	
	@Override
	public void postAction(){
		request.setAttribute("errors", errors);
		request.setAttribute("warnings", warnings);
		request.setAttribute("infos", infos);
		request.setAttribute("successes", successes);
	}
}
