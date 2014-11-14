package fr.utbm.core.entity;

import java.util.HashSet;
import java.util.Set;

public class Alert {
	private String code;
	private String label;
	private String description;
	private Set<Trigger> triggers = new HashSet<Trigger>(0);

	public Alert() {
	}

	public Alert(String code, String label, String description) {
		this.code = code;
		this.label = label;
		this.description = description;
	}

	public Alert(String code, String label, String description,
	             Set<Trigger> triggers) {
		this.code = code;
		this.label = label;
		this.description = description;
		this.triggers = triggers;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Trigger> getTriggers() {
		return this.triggers;
	}

	public void setTriggers(Set<Trigger> triggers) {
		this.triggers = triggers;
	}

	@Override
	public String toString() {
		return getLabel();
	}
}
