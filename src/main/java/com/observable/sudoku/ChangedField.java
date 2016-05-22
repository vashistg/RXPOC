package com.observable.sudoku;

public class ChangedField {

	private int value;
	ChangedValue changeIn =ChangedValue.NOCHANGE;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public ChangedValue getChangeIn() {
		return changeIn;
	}
	public void setChangeIn(ChangedValue changeIn) {
		this.changeIn = changeIn;
	}
	public ChangedField(int value, ChangedValue changedField) {
		super();
		this.value = value;
		this.changeIn = changedField;
	}
	
}
