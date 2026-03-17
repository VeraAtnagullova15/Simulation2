package simulation;

import simulation.entities.creatures.Herbivore;
import simulation.entities.creatures.Predator;
import simulation.entities.map_objects.Grass;
import simulation.entities.map_objects.Rock;
import simulation.entities.map_objects.Tree;

public class Simulation {
    private final WorldMap worldMap;
    private final RendererWorldMap renderer;

    public Simulation(WorldMap worldMap, RendererWorldMap renderer) {
        this.worldMap = worldMap;
        this.renderer = renderer;
    }

    public void start() {
        worldMap.putEntity(new Coordinates(1,1), new Herbivore(1,1));
        worldMap.putEntity(new Coordinates(2,2), new Predator(1,1, 1));
        worldMap.putEntity(new Coordinates(3,3), new Grass());
        worldMap.putEntity(new Coordinates(4,4), new Rock());
        worldMap.putEntity(new Coordinates(5,5), new Tree());
        worldMap.putEntity(new Coordinates(6,6), new Herbivore(1,1));
        renderer.printMap(worldMap);

    }
}
