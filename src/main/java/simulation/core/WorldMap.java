package simulation.core;

import simulation.entities.Entity;

import java.util.*;

public class WorldMap {
    private final int ROW_COUNT;
    private final int COLUMN_COUNT;
    private final Map<Coordinates, Entity> entities = new HashMap<>();

    public WorldMap() {
        ROW_COUNT = 12;
        COLUMN_COUNT = 12;
    }

    public int getROW_COUNT() {
        return ROW_COUNT;
    }

    public int getCOLUMN_COUNT() {
        return COLUMN_COUNT;
    }

    public Map<Coordinates, Entity> getEntities() {
        return new HashMap<>(entities);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        if (!isCellInside(coordinates)) {
            throw new NoSuchElementException();
        }
        return !entities.containsKey(coordinates);
    }

    public boolean isCellInside(Coordinates coordinates) {
        return  ((coordinates.row() >= 0 && coordinates.row() < getROW_COUNT()) &&
        (coordinates.column() >= 0 && coordinates.column() < getCOLUMN_COUNT()));
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

    public void removeEntity(Entity entity) {
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