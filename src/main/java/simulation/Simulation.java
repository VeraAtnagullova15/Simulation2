package simulation;

import simulation.actions.Action;
import simulation.actions.SpawnEntityAction;
import simulation.entities.creatures.Herbivore;
import simulation.entities.creatures.Predator;
import simulation.entities.map_objects.Grass;
import simulation.entities.map_objects.Rock;
import simulation.entities.map_objects.Tree;

import java.util.List;

public class Simulation {
    private final WorldMap worldMap;
    private final RendererWorldMap renderer;

    public Simulation(WorldMap worldMap, RendererWorldMap renderer) {
        this.worldMap = worldMap;
        this.renderer = renderer;
    }

    List<Action> initAction = List.of(new SpawnEntityAction(() -> new Herbivore(1,1), 4),
            new SpawnEntityAction(() -> new Predator(1,1, 1), 3),
                    new SpawnEntityAction(() -> new Grass(), 4),
                            new SpawnEntityAction(() -> new Tree(), 3),
                                    new SpawnEntityAction(() -> new Rock(), 2));

    public void start() {
        for (Action action : initAction) {
            action.execute(worldMap);
        }
        renderer.print(worldMap);

    }
}
