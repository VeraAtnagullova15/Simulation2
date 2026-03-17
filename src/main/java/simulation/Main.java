package simulation;

public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap(10,10);
        RendererWorldMap renderer = new RendererWorldMap();
        Simulation simulation = new Simulation(worldMap, renderer);
        simulation.start();
    }
}
