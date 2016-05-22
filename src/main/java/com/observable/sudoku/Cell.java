package com.observable.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.rx.sudoku.ChangedField;
import com.rx.sudoku.ChangedValue;
import com.rx.sudoku.Coordinate;




public class Cell extends Observable implements Observer{
    static int dimension=9;
    static int solved=0;
	
	int value=0;
	Coordinate rowCol ;
	Probables[] probables = new Probables[dimension];
	List<Integer> surelyNot = new ArrayList<Integer>();
	ChangedField changedField;
	
	public Cell(Coordinate rowCol) {
		super();
		this.rowCol = rowCol;
	}

	
	public int getValue() {
		return value;
	}
	
	/**
	 * This is where we notify other observers when
	 * the value changes.
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
		ChangedField changedField = new ChangedField(value,ChangedValue.VALUE);
		this.setChangedField(changedField);
		setChanged();
		super.notifyObservers();
		clearChanged();
		/**
		 * Set rest of numbers as surely not.
		 */
		for(int k=1;k<=dimension;k++){
			if(k!=value){
			    this.addToSurelyNot(k);
			}
		}
		
		solved++;
	}
	
	
	/**
	 * We notify observers only when we are sure of something
	 * either positively sure or negatively sure.
	 * @param surelyNotValue
	 */
	public void addToSurelyNot(Integer surelyNotValue) {
		if(!this.surelyNot.contains(surelyNotValue)){
			this.surelyNot.add(surelyNotValue);
			ChangedField changedField = new ChangedField(surelyNotValue,ChangedValue.SURELYNOT);
			this.setChangedField(changedField);
			setChanged();
			super.notifyObservers();
			clearChanged();
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		/**
		 * Check whats changed
		 * if value
		 *   put the number in surely not list 
		 *   and update all observers
		 * if surely not
		 *   updateProbableList
		 */
		
		
		if (value == 0) {
			Cell updatedCell = (Cell) o;
			//System.out.println(updatedCell);
			if (ChangedValue.VALUE.equals(updatedCell.getChangedField().getChangeIn())) {
				this.addToSurelyNot(updatedCell.getValue());
			}
			
			if(ChangedValue.SURELYNOT.equals(updatedCell.getChangedField().getChangeIn())){
				int changedValue = updatedCell.getChangedField().getValue();
				if(!this.surelyNot.contains(changedValue)){
					updateProbableList(updatedCell, changedValue);
				}
			}
		}
	}
    

	/**
	check if present in surely not
	 *      if yes do nothing
	 *      if not increment surely not flag in probable list.
	 */
	private void updateProbableList(Cell updatedCell, int changedValue) {
		Probables probable=null;
		if(this.getProbables()[changedValue-1]==null ){
			probable = new Probables();
			this.getProbables()[changedValue-1]=probable;
		}else{
			probable = this.getProbables()[changedValue-1];
		}
		
		probable.value = changedValue;
		/**
		 * If same row increment 0th index 
		 */
		if(this.rowCol.getRow() == updatedCell.rowCol.getRow()){
			probable.getNotSureFlags()[0]=probable.getNotSureFlags()[0]+1;
			if(probable.getNotSureFlags()[0]==dimension-1){
				this.setValue(changedValue);
			}
		}
		/**
		 * If same column incremnet 1st index
		 */
		if(this.rowCol.getCol() == updatedCell.rowCol.getCol()){
			probable.getNotSureFlags()[1]=probable.getNotSureFlags()[1]+1;
			if(probable.getNotSureFlags()[1]==dimension-1){
				this.setValue(changedValue);
			}
		}					
		/**
		 * If same grid increment 2nd index
		 */
		if(getGrid(this) == getGrid(updatedCell)){
			probable.getNotSureFlags()[2]=probable.getNotSureFlags()[2]+1;
			if(probable.getNotSureFlags()[2]==dimension-1){
				this.setValue(changedValue);
			}
		}
		
	}
	
	
	public Probables[] getProbables() {
		return probables;
	}
	
	public void setProbables( Probables[] probables) {
		this.probables = probables;
	}
	
	public ChangedField getChangedField() {
		return changedField;
	}

	public void setChangedField(ChangedField changedField) {
		this.changedField = changedField;
	}

	public void setSurelyNot(List<Integer> surelyNot) {
		this.surelyNot = surelyNot;
	}
	
	public List<Integer> getSurelyNot() {
		return surelyNot;
	}

	public static int getGrid(Cell cell) {
		return getGridIndex(cell.rowCol.getRow(),cell.rowCol.getCol());
	}

	private static int getGridIndex(int row,int col) {
		int gridSize = new Double(Math.sqrt(dimension)).intValue();
		return  gridSize*(row/gridSize) + col/gridSize;
	}
	

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}
	
	
	/**
	 * This is the dimension of the sudoku
	 * @return
	 */
	public static int getDimension() {
		return dimension;
	}

	public static void setDimension(int dimension) {
		Cell.dimension = dimension;
	}
	
	@Override
	public String toString() {
		return "Cell [value=" + value + ", rowCol=" + rowCol 
				+ ", surelyNot=" + surelyNot + ", changedField=" + changedField + "]";
	}
}
