package simulation.core;

import simulation.actions.*;

import java.util.List;

public class Simulation {
    private final WorldMap worldMap;
    private final RendererWorldMap renderer;
    private List<Action> initAction;
    private List<Action> turnAction;
    private int turnCounter = 0;
    protected final Lock lock = new Lock();
    public volatile boolean isPaused = false;
    public volatile boolean isRunning = true;



    public Simulation(WorldMap worldMap, RendererWorldMap renderer) {
        this.worldMap = worldMap;
        this.renderer = renderer;
        initAction = List.of(new SpawnEntityAction());
        turnAction = List.of(new MoveCreature(), new RespawnEntityAction());
    }

    public void start() {
        executeAction(initAction);
        renderer.print(worldMap);
    }

    public void nextTurn() {
        turnCounter++;
        executeAction(turnAction);
        renderer.print(worldMap);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void executeAction(List<Action> actions) {
        for (Action action : actions) {
            action.execute(worldMap);
        }
    }

    public void startSimulationLoop() {
        while (!isPaused) {
            nextTurn();
            System.out.println(turnCounter);
        }
    }

    protected static class Lock{}

    public void pauseSimulation() {
        isPaused = true;
    }

    public void restartSimulationLoop() {
        synchronized (lock) {
            isPaused = false;
            lock.notify();
        }
    }


}
