package main.toop.alexander;

/**
 * Simple object used for the representation of a live cell in the Game of Life.
 * Provides 2D grid location data.
 */
public class Cell {
    private Integer horizontalPosition;
    private Integer verticalPosition;


    /**
     * Constructor with horizontal and vertical position.
     *
     * @param horizontalPosition Relative to the infinite 2D grid.
     * @param verticalPosition Relative to the infinite 2D grid.
     */
    public Cell(Integer horizontalPosition, Integer verticalPosition) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
    }


    /**
     * Getter method for horizontal position.
     *
     * @return Horizontal position.
     */
    public Integer getHorizontalPosition() {
        return horizontalPosition;
    }


    /**
     * Getter method for vertical position.
     *
     * @return Vertical position.
     */
    public Integer getVerticalPosition() {
        return verticalPosition;
    }
}
