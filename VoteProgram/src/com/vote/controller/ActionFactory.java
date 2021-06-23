package com.vote.controller;

import com.vote.controller.action.Action;
import com.vote.controller.action.selectMember_Action;
import com.vote.controller.action.vote_action;
import com.vote.controller.action.vote_form_Action;
import com.vote.controller.action.vote_list_action;
import com.vote.controller.action.vote_ranklist_action;

public class ActionFactory {
	
	private ActionFactory () {};
	
	private static ActionFactory af = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return af;
	}
	
	
	public Action getAction(String command) {
		Action action = null;
		if(command.equals("selectMember")) {
			action = new selectMember_Action();
		}else if(command.equals("vote_form")) {
			action = new vote_form_Action();
		}else if(command.equals("vote_write")) {
			action = new vote_action();
		}else if(command.equals("vote_list")) {
			action = new vote_list_action();
		}else if(command.equals("rank_list")) {
			action = new vote_ranklist_action();
		}
		return action;
	}
	
	
}
