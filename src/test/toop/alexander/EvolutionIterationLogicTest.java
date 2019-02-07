package test.toop.alexander;

import main.toop.alexander.EvolutionIterationLogic;
import main.toop.alexander.Grid;
import main.toop.alexander.Cell;
import org.junit.Assert;
import org.junit.Test;

public class EvolutionIterationLogicTest {

    @Test
    public void checkNoInteractionsScenario(){
        Grid grid = new Grid();
        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);

        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertTrue(outcomeGrid.getLiveCells().isEmpty());
    }


    @Test
    public void checkUnderpopulationScenarioNoNeighbours(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);

        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();
        Assert.assertTrue(outcomeGrid.getLiveCells().isEmpty());
    }


    @Test
    public void checkUnderpopulationScenarioOneNeighbour(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertTrue(outcomeGrid.getLiveCells().isEmpty());
    }

    @Test
    public void checkUnderpopulationScenarioTwoNeighbours(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));
        grid.addCellIfPositionEmpty(new Cell(1,2));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertFalse(outcomeGrid.getLiveCells().isEmpty());
    }


    @Test
    public void checkOvercrowdingScenarioThreeNeighbours(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));
        grid.addCellIfPositionEmpty(new Cell(1,2));
        grid.addCellIfPositionEmpty(new Cell(2,1));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertTrue(outcomeGrid.isLiveCellInPosition(2,2));
    }


    @Test
    public void checkOvercrowdingScenarioFourNeighbours(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));
        grid.addCellIfPositionEmpty(new Cell(1,2));
        grid.addCellIfPositionEmpty(new Cell(2,1));
        grid.addCellIfPositionEmpty(new Cell(1,3));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertFalse(outcomeGrid.isLiveCellInPosition(2,2));
    }


    @Test
    public void checkSurvivalScenarioOneNeighbour(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertFalse(outcomeGrid.isLiveCellInPosition(2,2));
    }


    @Test
    public void checkSurvivalScenarioTwoNeighbours(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));
        grid.addCellIfPositionEmpty(new Cell(1,2));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertTrue(outcomeGrid.isLiveCellInPosition(2,2));
    }


    @Test
    public void checkSurvivalScenarioThreeNeighbours(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));
        grid.addCellIfPositionEmpty(new Cell(1,2));
        grid.addCellIfPositionEmpty(new Cell(2,1));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertTrue(outcomeGrid.isLiveCellInPosition(2,2));
    }


    @Test
    public void checkSurvivalScenarioFourNeighbours(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));
        grid.addCellIfPositionEmpty(new Cell(1,2));
        grid.addCellIfPositionEmpty(new Cell(2,1));
        grid.addCellIfPositionEmpty(new Cell(1,3));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertFalse(outcomeGrid.isLiveCellInPosition(2,2));
    }


    @Test
    public void checkLifeCreationScenarioTwoNeighbours(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));
        grid.addCellIfPositionEmpty(new Cell(2,1));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertFalse(outcomeGrid.getLiveCells().size() > grid.getLiveCells().size());
    }


    @Test
    public void checkLifeCreationScenarioThreeNeighbours(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));
        grid.addCellIfPositionEmpty(new Cell(1,2));
        grid.addCellIfPositionEmpty(new Cell(2,1));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertTrue(outcomeGrid.getLiveCells().size() > grid.getLiveCells().size());
    }


    @Test
    public void checkLifeCreationScenarioFourNeighbours(){
        Grid grid = new Grid();
        grid.addCellIfPositionEmpty(new Cell(2,2));
        grid.addCellIfPositionEmpty(new Cell(2,3));
        grid.addCellIfPositionEmpty(new Cell(1,2));
        grid.addCellIfPositionEmpty(new Cell(2,1));
        grid.addCellIfPositionEmpty(new Cell(1,3));

        EvolutionIterationLogic evolutionIterationLogic = new EvolutionIterationLogic(grid);
        evolutionIterationLogic.runEvolutionIteration();
        Grid outcomeGrid = evolutionIterationLogic.getGrid();

        Assert.assertFalse(outcomeGrid.getLiveCells().size() > grid.getLiveCells().size());
    }
}