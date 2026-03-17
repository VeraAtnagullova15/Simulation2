package simulation;

import simulation.entities.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class WorldMap {
    private final int rowCount;
    private final int columnCount;
    private final Map<Coordinates, Entity> entities = new HashMap<>();

    public WorldMap(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void putEntity(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public Coordinates getCoordinates(Entity entity) {
        for (var ent : entities.entrySet()) {
            Entity current = ent.getValue();
            if (current.equals(entity)) {
                return ent.getKey();
            }
        }
        throw new NoSuchElementException();
    }
}