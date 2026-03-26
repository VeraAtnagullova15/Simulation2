package simulation.core;

public class SimulationThread implements Runnable {
    private Simulation simulation;

    public SimulationThread(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void run() {
        while (simulation.isRunning) {
            while (simulation.isPaused) {
                synchronized (simulation.lock) {
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
