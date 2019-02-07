package main.toop.alexander;

import java.util.ArrayList;
import java.util.Random;

/**
 * Game of life entry point.
 */
public class Game {
    private Grid grid;
    // change these constants as desired.
    private Integer MAX_NO_STARTING_CELLS = 1000;
    private Integer START_POSITIONS_MAX_DIFFERENCE = 100;


    /**
     * Runs a simulation of the Game of Life. Outputs results of each evolution iteration to the terminal.
     *
     * @param seed Determines the initial starting positions of cells.
     */
    public Game(String seed, Integer noIterationsToRun) {
        this.grid = new Grid();

        populateSeededGrid(seed);
        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(this.grid);

        System.out.println("-----Initial Seed-----");
        System.out.println(this.grid.toString());

        for (int i = 0; i < noIterationsToRun; i++) {
            evolutionIterationLogic.runEvolutionIteration();
            System.out.println("-----Iteration: " + (i + 1) + "-----");
            System.out.println(evolutionIterationLogic.getGrid().toString());
        }
    }


    /**
     * Adds the initial cells to the grid. Seed determines the starting number and positions of cells.
     *
     * @param seed Determines how the grid will be populated.
     */
    private void populateSeededGrid(String seed) {
        if ("random".equalsIgnoreCase(seed)) {
            for (Cell cell : getRandomArrayOfCells()) {
                this.grid.addCellIfPositionEmpty(cell);
            }
        }
        if ("scenario6".equalsIgnoreCase(seed)) {
            for (Cell cell : getScenario6ArrayOfCells()) {
                this.grid.addCellIfPositionEmpty(cell);
            }
        }
    }


    /**
     * Provides cells with example generated locations for scenario 6.
     * RE: Candidate instructions.
     *
     * @return List of cells to be added to the grid.
     */
    private ArrayList<Cell> getScenario6ArrayOfCells() {
        ArrayList<Cell> cells = new ArrayList<>();
        cells.add(new Cell(1, 2));
        cells.add(new Cell(2, 2));
        cells.add(new Cell(3, 2));

        return cells;
    }


    /**
     * Provides cells with randomly generated locations. Adheres to the constants specified to bound and
     * determine the positions and numbers.
     *
     * @return List of cells to be added to the grid.
     */
    private ArrayList<Cell> getRandomArrayOfCells() {
        Random rand = new Random();
        Integer noOfCellsToCreate = rand.nextInt(MAX_NO_STARTING_CELLS);

        ArrayList<Cell> cells = new ArrayList<>();
        for (int i = 0; noOfCellsToCreate > i; i++) {
            // Subtraction allows for negative starting positions.
            Integer horizontalPosition = rand.nextInt(START_POSITIONS_MAX_DIFFERENCE) - (START_POSITIONS_MAX_DIFFERENCE / 2);
            Integer verticalPosition = rand.nextInt(START_POSITIONS_MAX_DIFFERENCE) - (START_POSITIONS_MAX_DIFFERENCE / 2);
            cells.add(new Cell(horizontalPosition, verticalPosition));
        }
        return cells;
    }
}
