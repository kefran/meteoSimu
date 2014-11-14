package fr.utbm.core.entity;

import java.util.Date;

public class AlertHistory {
	private int id;
	private Trigger trigger;
	private Date date;
	private boolean state;

	public AlertHistory() {
	}

	public AlertHistory(int id, Trigger trigger, Date date, boolean state) {
		this.id = id;
		this.trigger = trigger;
		this.date = date;
		this.state = state;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Trigger getTrigger() {
		return this.trigger;
	}

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return getDate().toString();
	}
}
