package main.toop.alexander;

import java.util.ArrayList;

/**
 * Class contains the logic to determine the outcome of an evolution iteration and provides
 * methods to obtain resultant grid.
 */
public class EvolutionIterationLogic {
    private Grid currentGrid;
    private Grid resultantGrid;


    /**
     * Constructor to set relevant grids before evolution iterations are run.
     *
     * @param currentGrid Initial grid with state of the initially created cells.
     */
    public EvolutionIterationLogic(Grid currentGrid) {
        this.currentGrid = currentGrid;
        this.resultantGrid = new Grid();
    }


    /**
     * Runs one complete evolution iteration. Applies all rules.
     */
    public void runEvolutionIteration() {
        ArrayList<Cell> liveCells = this.currentGrid.getLiveCells();
        for (Cell cell : liveCells) {

            // Underpopulation and overcrowding rules are implicit.
            // If the live cell does not get stored in the resultantGrid from the survivalRule, the cell has an
            // effective outcome of death.
            applySurvivalRule(cell);
            checkSurroundingPositionsForCreationRule(cell);
        }
        this.currentGrid = this.resultantGrid;
        this.resultantGrid = new Grid();
    }


    /**
     * Getter method for the current grid.
     *
     * @return Grid fo cells.
     */
    public Grid getGrid() {
        return this.currentGrid;
    }


    /**
     * RE:
     * When a live cell has two or three neighbours
     * Then this cell stays alive
     *
     * @param cell Check this in relation to rule.
     */
    private void applySurvivalRule(Cell cell) {
        Integer noNeighbours = this.currentGrid.determineNumberOfNeighbours(cell.getHorizontalPosition(), cell.getVerticalPosition());

        if (noNeighbours == 2 || noNeighbours == 3) {
            this.resultantGrid.addCellIfPositionEmpty(cell);
        }
    }


    /**
     * Applies the creation rule to positions around a cell. Only these positions are applicable  for the creation
     * rule. Creation rule is then applied on the positions to check validity.
     *
     * @param cell The cell we will check the positions around.
     */
    private void checkSurroundingPositionsForCreationRule(Cell cell) {
        // Note: We only check the positions around live cells to minimise computation.
        Integer horizontalPosition = cell.getHorizontalPosition();
        Integer verticalPosition = cell.getVerticalPosition();

        applyCreationRule(horizontalPosition - 1, verticalPosition + 1);
        applyCreationRule(horizontalPosition, verticalPosition + 1);
        applyCreationRule(horizontalPosition + 1, verticalPosition + 1);
        applyCreationRule(horizontalPosition - 1, verticalPosition);
        applyCreationRule(horizontalPosition + 1, verticalPosition);
        applyCreationRule(horizontalPosition - 1, verticalPosition - 1);
        applyCreationRule(horizontalPosition, verticalPosition - 1);
        applyCreationRule(horizontalPosition + 1, verticalPosition - 1);
    }


    /**
     * RE:
     * When an empty position has exactly three neighbouring cells
     * Then a cell is created in this position
     *
     * Minor assumption to allow new cells to be created on locations where cells have previously died.
     * This approach is supported by Scenario 6 requiring this implementation.
     *
     * @param horizontalPosition
     * @param verticalPosition
     */
    private void applyCreationRule(Integer horizontalPosition, Integer verticalPosition) {
        // If a cell is alive in the position currently and perhaps not in the future grid, we don't want to
        // create a new cell here to allow for the other cells death.
        if (this.currentGrid.isLiveCellInPosition(horizontalPosition, verticalPosition)) {
            return;
        }
        if (this.currentGrid.determineNumberOfNeighbours(horizontalPosition, verticalPosition) == 3) {
            this.resultantGrid.addCellIfPositionEmpty(new Cell(horizontalPosition, verticalPosition));
        }
    }
}