package simulation.actions;

import simulation.factory.EntityFactory;
import simulation.factory.RealEntityFactory;
import simulation.core.Coordinates;
import simulation.core.WorldMap;
import simulation.entities.Entity;
import simulation.entities.creatures.Herbivore;
import simulation.entities.creatures.Predator;
import simulation.entities.map_objects.Grass;
import simulation.entities.map_objects.Rock;
import simulation.entities.map_objects.Tree;

import java.util.Map;
import java.util.Random;

public abstract class SpawnAction extends Action {
    private static final int HERBIVORE_AMOUNT = 10;
    private static final int PREDATOR_AMOUNT = 5;
    private static final int GRASS_AMOUNT = 12;
    private static final int ROCK_AMOUNT = 5;
    private static final int TREE_AMOUNT = 5;

    protected final static Map<Class<? extends Entity>, Integer> ENTITY_MAX_NUMBER = Map.of(
            Herbivore.class, HERBIVORE_AMOUNT,
            Predator.class, PREDATOR_AMOUNT,
            Grass.class, GRASS_AMOUNT,
            Rock.class, ROCK_AMOUNT,
            Tree.class, TREE_AMOUNT
            );

    private EntityFactory factory;

    public SpawnAction() {
        factory = new RealEntityFactory();
    }

    protected void spawn(WorldMap worldMap, Class<? extends Entity> entityType, int amount) {
        for (int i = 0; i < amount; i++) {
            Entity entity = factory.create(entityType);
            Coordinates randomCoordinates = getRandomEmptyCoodrinates(worldMap);
            worldMap.putEntity(randomCoordinates, entity);

        }
    }

    private Coordinates getRandomEmptyCoodrinates(WorldMap worldMap) {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(worldMap.getROW_COUNT());
            int column = random.nextInt(worldMap.getCOLUMN_COUNT());
            Coordinates coordinates = new Coordinates(row, column);

            if (worldMap.isCellAvailablePutEntity(coordinates)) {
                return coordinates;
            }
        }
    }


}
