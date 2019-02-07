package main.toop.alexander;

import java.util.ArrayList;

/**
 * Contains logic surrounding the concept of an infinite 2D grid containing cells.
 */
public class Grid {
    private ArrayList<Cell> liveCells;


    /**
     * Constructor for Grid. Sets the ArrayList of live cells.
     */
    public Grid() {
        this.liveCells = new ArrayList<>();
    }


    /**
     * Checks cell is not duplicated and adds it to the list of live cells.
     *
     * @param cell The cell to be added.
     */
    public void addCellIfPositionEmpty(Cell cell) {
        if (isLiveCellInPosition(cell.getHorizontalPosition(), cell.getVerticalPosition())) {
            return;
        }
        this.liveCells.add(cell);
    }


    /**
     * Getter for the live cells in the grid.
     *
     * @return ArrayList of live cells in the grid.
     */
    public ArrayList<Cell> getLiveCells() {
        return liveCells;
    }


    /**
     * Iterates through the positions located around a position to determine the number of live cell
     * neighbours.
     *
     * @param horizontalPosition Horizontal position.
     * @param verticalPosition Vertical position.
     * @return Integer. The number of neighbours that the position has.
     */
    public Integer determineNumberOfNeighbours(Integer horizontalPosition, Integer verticalPosition) {
        Integer numberOfNeighbours = 0;

        if (isLiveCellInPosition(horizontalPosition - 1, verticalPosition + 1)) {
            numberOfNeighbours++;
        }
        if (isLiveCellInPosition(horizontalPosition, verticalPosition + 1)) {
            numberOfNeighbours++;
        }
        if (isLiveCellInPosition(horizontalPosition + 1, verticalPosition + 1)) {
            numberOfNeighbours++;
        }
        if (isLiveCellInPosition(horizontalPosition - 1, verticalPosition)) {
            numberOfNeighbours++;
        }
        if (isLiveCellInPosition(horizontalPosition + 1, verticalPosition)) {
            numberOfNeighbours++;
        }
        if (isLiveCellInPosition(horizontalPosition - 1, verticalPosition - 1)) {
            numberOfNeighbours++;
        }
        if (isLiveCellInPosition(horizontalPosition, verticalPosition - 1)) {
            numberOfNeighbours++;
        }
        if (isLiveCellInPosition(horizontalPosition + 1, verticalPosition - 1)) {
            numberOfNeighbours++;
        }

        return numberOfNeighbours;
    }


    /**
     * Checks if a live cell is located in the position specified.
     *
     * @param horizontalPosition Horizontal position.
     * @param verticalPosition Vertical position.
     * @return Boolean implying if a live cell is located at specified position.
     */
    public Boolean isLiveCellInPosition(Integer horizontalPosition, Integer verticalPosition) {
        for (Cell cell : this.liveCells) {
            if (cell.getHorizontalPosition().equals(horizontalPosition) && cell.getVerticalPosition().equals(verticalPosition)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Provides a textual representation of the live cells in the grid.
     *
     * @return String of the live cells in the grid.
     */
    public String toString() {
        String output = "Live Cells:\n";

        if (liveCells.size() < 1) {
            output += "No cells alive.\n";
        } else {
            for (Cell aliveCell : this.liveCells) {
                output += "x: " + aliveCell.getHorizontalPosition()
                        + ", y: " + aliveCell.getVerticalPosition() + ".\n";
            }
        }
        return output;
    }
}
