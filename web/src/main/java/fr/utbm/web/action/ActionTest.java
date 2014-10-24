package fr.utbm.web.action;

import com.opensymphony.xwork2.ActionSupport;


public class ActionTest extends ActionSupport {

	private static final long serialVersionUID = 6779201204500572858L;

	String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
