package simulation;

import simulation.core.RendererWorldMap;
import simulation.core.Simulation;
import simulation.core.WorldMap;

public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap(10,10);
        RendererWorldMap renderer = new RendererWorldMap();
        Simulation simulation = new Simulation(worldMap, renderer);
        simulation.start();
        int a = 123;
        for (int i = 0; i < 8; i++) {
            simulation.startSimulation();
            renderer.print(worldMap);
        }


    }
}
