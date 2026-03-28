package simulation.core;

public class SimulationThread implements Runnable {
    private Simulation simulation;

    public SimulationThread(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void run() {
        while (simulation.isRunning) {
            synchronized (simulation.lock) {
                while (simulation.isPaused && simulation.isRunning) {
                        try {
                            simulation.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                simulation.startSimulationLoop();
            }

        }

}
