package simulation.actions;

import simulation.core.Coordinates;
import simulation.core.WorldMap;
import simulation.entities.Entity;

import java.util.Random;
import java.util.function.Supplier;

public class SpawnEntityAction extends Action {
    private Supplier<Entity> entitySupplier;
    private int entityAmount;

    public SpawnEntityAction(Supplier<Entity> entitySupplier, int entityAmount) {
        this.entitySupplier = entitySupplier;
        this.entityAmount = entityAmount;
    }

    @Override
    public void execute(WorldMap worldMap) {
        for (int i = 0; i < entityAmount; i++) {
            Entity entity = entitySupplier.get();
            Coordinates randomCoordinates = getRandomEmptyCoodrinates(worldMap);
            worldMap.putEntity(randomCoordinates, entity);
        }
    }

    private Coordinates getRandomEmptyCoodrinates(WorldMap worldMap) {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(worldMap.getRowCount());
            int column = random.nextInt(worldMap.getColumnCount());
            Coordinates coordinates = new Coordinates(row, column);

            if (worldMap.isCellAvailablePutEntity(coordinates)) {
                return coordinates;
            }
        }
    }
}
