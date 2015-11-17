package com.mposluszny.lolesportsapp.web.teams;

import java.io.Serializable;
import java.util.List;

import com.mposluszny.lolesportsapp.core.model.Team;
import com.mposluszny.lolesportsapp.web.services.TeamService;
import com.mposluszny.lolesportsapp.web.services.impl.TeamServiceImpl;

public class ModelBean implements Serializable {

	/**
	 * Bean for 'teams' section.
	 * Contains a Player list
	 */
	private static final long serialVersionUID = 1551523865258549328L;

	private List<Team> teams;
	private boolean isView;
	private boolean isEdit;
	
	public ModelBean() {
		
		TeamService teamService = new TeamServiceImpl();
		this.teams = teamService.getTeams();
		isView = false; isEdit = false;
	}

	public List<Team> getTeams() {
		
		return teams;
	}

	public boolean isView() {
		return isView;
	}

	public void setView(boolean isView) {
		this.isView = isView;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
}
