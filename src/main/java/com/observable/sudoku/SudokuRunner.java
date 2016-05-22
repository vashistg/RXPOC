package com.observable.sudoku;

import com.rx.sudoku.Coordinate;

public class SudokuRunner {
	
	static int dimension =9;
	static Cell[][] sudoku = new Cell[dimension][dimension];
	public static void main(String[] args) {
		Cell.dimension=dimension;
		initializeCells();
		/**
		 * This is where the magic happens.
		 */
		int[][] initialEntries = getEntries(dimension);
		for(int i =0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				if(initialEntries[i][j]!=0){
					sudoku[i][j].setValue(initialEntries[i][j]);
				}
			}
		}
		
		printSudoku();
		//System.out.println("solved"+Cell.solved);
		System.out.println(Cell.solved > 81 ?"Yo :)":"Ohhh no :(");
	}
	
	

	/**
	 * Initial Setup
	 */

	private static void initializeCells() {
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				Cell cell = new Cell(new Coordinate(i, j));
				sudoku[i][j] = cell;
			}
		}
		/**
		 * Just add all observers to the list
		 */
		addobservers();
	}

	private static void addobservers() {
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				addObservers(sudoku[i][j]);
			}
		}
	}

	
	private static void addObservers(Cell cell) {
		/**
		 * Add all column wise neighours
		 */
		for(int i=0;i<dimension;i++){
			if(cell.rowCol.getRow()!=i){
				cell.addObserver(sudoku[i][cell.rowCol.getCol()]);
			}
		}
		
		/**
		 * Add row wise neighours
		 */
		for(int i=0;i<dimension;i++){
			if(cell.rowCol.getCol()!=i){
				cell.addObserver(sudoku[cell.rowCol.getRow()][i]);
			}
		}
		
		/**
		 * Add grid wise neighours
		 */
		  int gridSize = new Double(Math.sqrt(dimension)).intValue();
		  
		  int grid = Cell.getGrid(cell);
		  int initialRow = (grid/gridSize)*gridSize; 
		  int initialCol = (grid % gridSize)*gridSize ;	  
		  for(int i =initialRow ; i< initialRow+gridSize;i++){
			  for(int j = initialCol ;j<initialCol+gridSize;j++){
				  if(!(cell.rowCol.getRow()==i && cell.rowCol.getCol()==j)){
					  cell.addObserver(sudoku[i][j]);
				  }
			  }
		  }
	}
	
	private static void printSudoku() {
		int gridSize = new Double(Math.sqrt(dimension)).intValue();
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(sudoku[i][j].value + " ");
				if ((j+1) % 3 == 0 && j>1) {
					System.out.print("  ");
				}
				if ((j+1) % 9 == 0 && j != 0) {
					System.out.println(" ");
					if((i+1)%3==0 && i >1){
						System.out.println(" ");
					}
				}
				
			}
		}

	}


	private static int[][] getEntries(int dimension) {
		//int[][] entries = getEasySudoku();
		int[][] entries = getMediumSudoku();
		//int[][] entries = getEvilSudoku();
		return entries;
	}



	private static int[][] getEasySudoku() {
		int [][] entries = {
				{2,0,8,0,5,4,0,1,7},
				{0,0,0,0,0,8,0,0,0},
				{9,0,0,6,0,7,0,3,0},
				{0,0,0,0,0,0,0,0,6},
				{4,0,3,2,0,6,8,0,1},
				{0,0,7,3,0,0,0,2,4},
				{1,0,6,4,0,0,7,8,0},
				{3,0,9,0,0,2,0,0,5},
				{5,0,4,8,6,0,0,9,0}
				};
		
		int [][] mediumEntries = {
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
				};
		
		return entries;
	}
	
	
	private static int[][] getMediumSudoku() {
		int [][] entries = {
		{0,4,0,2,0,0,0,6,7},
		{0,0,5,0,1,4,3,8,0},
		{0,0,0,0,9,0,0,0,4},
		{0,9,4,0,3,0,6,0,0},
		{0,0,0,0,8,0,0,0,0},
		{0,0,8,0,2,0,4,7,0},
		{3,0,0,0,6,0,0,0,0},
		{0,1,2,8,7,0,5,0,0},
		{5,6,0,0,0,1,0,2,0}
		};
		
		
		/*{
			{0,5,0,0,0,0,0,6,1},
			{1,2,0,0,9,4,0,5,0},
			{0,0,0,0,3,0,0,7,0},
			{0,0,0,0,6,9,0,0,0},
			{0,0,5,8,0,2,4,0,0},
			{0,0,0,7,4,0,0,0,0},
			{0,1,0,0,2,0,0,0,0},
			{0,6,0,4,7,0,0,1,2},
			{8,4,0,0,0,0,0,3,0}
			}*/
		return entries;
	}
}
