package com.rx.sudoku;

public class Coordinate {
	
	int row;
	int col;
	
	public Coordinate(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	
	@Override
	public String toString() {
		return "RowandCol [row=" + row + ", col=" + col + "]";
	}

	

}