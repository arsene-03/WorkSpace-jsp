package com.movie.controller;

import com.movie.controller.action.Action;
import com.movie.controller.action.MovieListAction;
import com.movie.controller.action.MovieWriteFormAction;

public class ActionFactory {
	
	private ActionFactory() {}
	
	private static ActionFactory af = new ActionFactory();
	
	public static ActionFactory getInsetance() {
		return af;
	}
	
	
	//////////////////////////////////////////////
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("movie_list")) {
			action = new MovieListAction();
		}
		if(command.equals("movie_write")) {
			action = new MovieWriteFormAction();
		}
		return action;
	}
}
