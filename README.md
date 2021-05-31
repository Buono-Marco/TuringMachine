# TuringMachine

Lab 5 from http://math.hws.edu/eck/cs225/s09/lab5/

CPSC 225, Spring 2009
Lab 5: Tape for a Turing Machine (Doubly-linked List)

This week's lab is another relatively short exercise in which you will code part of an existing project. In this case, you will be working with a doubly-linked list. To make this topic more interesting, the list that you work on will be part of a Turing Machine. A Turing Machine is a kind of very simple, abstract computing device that was introduced in the 1930's by Alan Turing as a way of studying computation and its limitations.

The classes that you need for the lab are in a package named turing. You will define a new class named Tape in this package. You can find the Java source code in the directory /classes/s0/cs225/turing. You should copy this directory into an Eclipse project. There will have errors, since the existing classes depend on the Tape class, which you have not yet written.

This lab is due next Tuesday, February 24. Don't forget the Javadoc comments.
A Class for Turing Machine Tapes

A Turing machine works on a "tape" that is used for both input and output. The tape is made up of little squares called cells lined up in a horizontal row that stretches, conceptually, off to infinity in both directions. Each cell can hold one character. Initially, the content of a cell is a blank space. One cell on the tape is considered to be the current cell. This is the cell where the machine is located. As a Turing machine computes, it moves back and forth along the tape, and the current cell changes.

A Turing machine tape can be represented by a doubly-linked list where each cell has a pointer to the previous cell (to its left) and to the next cell (to its right). The pointers will allow the machine to advance from one cell to the next cell on the left or to the next cell on the right. Each cell can be represented as an object of type Cell as defined by the class:

   public class Cell {
      public char content;  // The character in this cell.
      public Cell next;     // Pointer to the cell to the right of this one.
      public Cell prev;     // Pointer to the cell to the left of this one.
   }

This class is already defined in the file Cell.java, so you don't have to write it yourself.

Your task is to write a class named Tape to represent Turing machine tapes. The class should have an instance variable of type Cell that points to the current cell. To be compatible with the classes that will use the Tape class, your class must include the following methods:

    public Cell getCurrentCell() -- returns the pointer that points to the current cell.
    public char getContent() -- returns the char from the current cell.
    public void setContent(char ch) -- changes the char in the current cell to the specified value.
    public void moveLeft() -- moves the current cell one position to the left along the tape. Note that if the current cell is the leftmost cell that exists, then a new cell must be created and added to the tape at the left of the current cell, and then the current cell pointer can be moved to point to the new cell. The content of the new cell should be a blank space. (Remember that the Turing machine's tape is conceptually infinite, so your linked list must must be prepared to expand on demand, when the machine wants to move past the current end of the list.)
    public void moveRight() -- moves the current cell one position to the right along the tape. Note that if the current cell is the rightmost cell that exists, then a new cell must be created and added to the tape at the right of the current cell, and then the current cell pointer can be moved to point to the new cell. The content of the new cell should be a blank space.
    public String getTapeContents() -- returns a String consisting of the chars from all the cells on the tape, read from left to right, except that leading or trailing blank characters should be discarded. The current cell pointer should not be moved by this method; it should point to the same cell after the method is called as it did before. You can create a different pointer to move along the tape and get the full contents. (This method is the hardest one to implement.)

It is also useful to have a constructor that creates a tape that initially consists of a single cell. The cell should contain a blank space, and the current cell pointer should point to it. (The alternative -- letting the current cell pointer be null to represent a completely blank tape -- makes all the methods in the class more difficult to implement.)

To test your Tape class, you can should run the programs that are defined by the files TestTape.java, TestTapeGUI.java, and TestTuringMachine.java. The first two programs just do things with a tape, to test whether it is functioning properly. TestTuringMachine actually creates and runs several Turing machines, using your Tape class to represent the machines' tapes.
