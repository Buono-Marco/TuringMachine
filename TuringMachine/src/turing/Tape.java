package turing;

/**
 * Represent Turing machine tapes. The tape is made up of little
 * squares called cells lined up in a horizontal row that stretches,
 * conceptually, off to infinity in both directions
 */
public class Tape {
	
	private Cell runner; // current cell
	private Cell leftCell; // current cell
	private Cell rightCell; // current cell
	
	/**
	 * The constructor creates a tape that
	 * initially consists of a single cell
	 * which contain a blank space, 
	 */
	public Tape() {
		runner = new Cell();
		runner.content = ' ';
	}
	
	/**
	 * Returns the pointer that points to
	 * the current cell
	 * @return the current cell
	 */
	public Cell getCurrentCell() {
		return runner;
	}
	
	/**
	 * The method returns the char
	 * from the current cell.
	 * @return the char from the current cell
	 */
	public char getContent() {
		return runner.content;
	}
	
	/**
	 * The method changes the char in the
	 * current cell to the specified value
	 * @param c, The char to store in the current cell
	 */
	public void setContent(char c) {
		runner.content = c;
	}
	
	/**
	 * Moves the current cell one position to the left along
	 * the tape. If the current cell is the leftmost cell that
	 * exists, then a new cell will be created and added to the
	 * tape at the left of the current cell, and then the current
	 * cell pointer can be moved to point to the new cell.
	 * The content of the new cell will be a blank space.
	 */
	public void moveLeft() {
		runner = getCurrentCell();
		if(runner.prev == null) { // if the left cell doesn't exist
			leftCell = new Cell(); // create one
			leftCell.content = ' ';
		} else {
			leftCell = runner.prev; // otherwise get it
		}
		leftCell.next = runner; // links the right pointer of the left cell to the current cell 
		runner.prev = leftCell; // links the left pointer of the current cell to the left cell
		runner = leftCell; // set the current position on the left cell
		
	}
	
	/**
	 * Moves the current cell one position to the right along
	 * the tape. If the current cell is the rightmost cell that
	 * exists, then a new cell will be created and added to the
	 * tape at the right of the current cell, and then the current
	 * cell pointer can be moved to point to the new cell.
	 * The content of the new cell will be a blank space.
	 */
	public void moveRight() {
		runner = getCurrentCell();
		if(runner.next == null) { // if the right cell doesn't exist
			rightCell = new Cell(); // create one
			rightCell.content = ' ';
		} else {
			rightCell = runner.next; // otherwise get it
		}
		rightCell.prev = runner; // links the left pointer of the right cell to the current cell
		runner.next = rightCell; // links the right pointer of the current cell to the right cell
		runner = rightCell; // set the current position on the right cell
	}
	
	/**
	 * Returns a String consisting of the chars from all the cells
	 * on the tape, read from left to right, except that leading or
	 * trailing blank characters will be discarded. The current cell
	 * pointer will not be moved by this method; it will point to the
	 * same cell after the method is called as it did before.
	 * 
	 * @return a String consisting of the chars from all the cells
	 * on the tape
	 */
	public String getTapeContents() {
		String tapeString = " ";
		Cell currentCell = getCurrentCell();
		if(currentCell.prev == null && currentCell.next == null) {
			return " "; // if both are null the tape is empty
		}
		
		// set the pointer to the leftmost cell;
		while (currentCell.prev != null) {
			currentCell = currentCell.prev;;
		}
		//tapeString = "";
		// read all the tape from left to right
		while(currentCell.next != null) {
			tapeString += currentCell.content;
			currentCell = currentCell.next;
		}

		return tapeString.trim(); //discard leading or trailing blank characters
	}
}
