package simulation.core;

import simulation.actions.Action;
import simulation.actions.MoveCreature;
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
    private List<Action> initAction;
    private List<Action> turnAction;

    public Simulation(WorldMap worldMap, RendererWorldMap renderer) {
        this.worldMap = worldMap;
        this.renderer = renderer;
        initAction = List.of(new SpawnEntityAction(() -> new Herbivore(), 4),
                new SpawnEntityAction(() -> new Predator(), 3),
                new SpawnEntityAction(() -> new Grass(), 4),
                new SpawnEntityAction(() -> new Tree(), 3),
                new SpawnEntityAction(() -> new Rock(), 2));
        turnAction = List.of(new MoveCreature());
    }

    public void start() {
        for (Action action : initAction) {
            action.execute(worldMap);
        }
        renderer.print(worldMap);

    }

    public void startSimulation() {
        for (Action action : turnAction) {
            action.execute(worldMap);
        }
        renderer.print(worldMap);
    }
}
