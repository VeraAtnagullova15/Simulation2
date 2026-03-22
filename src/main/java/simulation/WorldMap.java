package simulation;

import simulation.entities.Entity;
import simulation.entities.creatures.Creature;

import java.util.*;

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

    public Map<Coordinates, Entity> getEntities() {
        return new HashMap<>(entities);
    }

    private boolean isCellEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    private boolean isCellInside(Coordinates coordinates) {
        return  ((coordinates.row() >= 0 && coordinates.row() < getRowCount()) &&
        (coordinates.column() >= 0 && coordinates.column() < getColumnCount()));
    }

    public boolean isCellAvailablePutEntity(Coordinates coordinates) {
        return isCellInside(coordinates) && isCellEmpty(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void putEntity(Coordinates coordinates, Entity entity) {
        if (isCellAvailablePutEntity(coordinates)) {
            entities.put(coordinates, entity);
        }
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

    private void removeEntity(Entity entity) {
        Coordinates coordinates = getCoordinates(entity);
        entities.remove(coordinates);
    }

    public void moveEntity(Entity entity, Coordinates to) {
        if (isCellAvailablePutEntity(to)) {
            removeEntity(entity);
            putEntity(to, entity);
        }
    }

    public <T extends Entity> List<T> getAllCreatures(Class<T> clazz) {
        List<T> creatures = new ArrayList<>();
        for (Entity type : getEntities().values()) {
            if (clazz.isInstance(type)) {
                creatures.add(clazz.cast(type));
            }
        }
        return creatures;
    }

}