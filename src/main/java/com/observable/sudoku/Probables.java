package com.observable.sudoku;

import java.util.Arrays;

public class Probables {
	
	int value=-1;
	int dimension=3;

	public int[] getNotSureFlags() {
		return notSureFlags;
	}

	public void setNotSureFlags(int[] notSureFlags) {
		this.notSureFlags = notSureFlags;
	}

	int[] notSureFlags = {0,0,0};
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	@Override
	public String toString() {
		return "Probables [value=" + value + ", dimension=" + dimension + ", notSureFlags="
				+ Arrays.toString(notSureFlags) + "]";
	}
  	
}
