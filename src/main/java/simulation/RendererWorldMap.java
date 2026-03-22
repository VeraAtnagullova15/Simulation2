package simulation;

import simulation.entities.Entity;
import simulation.entities.creatures.Herbivore;
import simulation.entities.creatures.Predator;
import simulation.entities.map_objects.Grass;
import simulation.entities.map_objects.Rock;
import simulation.entities.map_objects.Tree;

public class RendererWorldMap {
    private static final String REGULAR_BACKGROUD = "\u001B[44;5;106m";
    private static final String WARNING_BACKGROUND = "\u001B[48;5;214m";
    private static final String DANGER_BACKGROUND = "\u001B[48;5;160m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String CLEAR_SCREEN = "\033[2J\033[1;1H";
    private static final String EMPTY_SPACE = "\uD83D\uDD32";
//private static final String EMPTY_SPACE = "◻\uFE0F";
    private static final String PREDATOR = "\uD83D\uDC3A";
    private static final String HERBIVORE = "\uD83D\uDC07";
    private static final String GRASS = "\uD83E\uDD55";
    private static final String TREE = "\uD83C\uDF32";
    private static final String ROCK = "\uD83E\uDEA8";

    public void print(WorldMap worldMap) {
        System.out.println(CLEAR_SCREEN);
        System.out.flush();
        for (int row = 0; row < worldMap.getRowCount(); row++) {
            StringBuilder line = new StringBuilder("");
            for (int column = 0; column < worldMap.getColumnCount(); column++) {
                Coordinates coordinates = new Coordinates(row, column);
                Entity entity = worldMap.getEntity(coordinates);
                String background = REGULAR_BACKGROUD;
                line.append(background).append(String.format("%-3s", getSymbolEntities(entity))).append(ANSI_RESET);
            }
            System.out.println(line);
        }
    }

    private String getSymbolEntities(Entity entity) {
        if (entity instanceof Herbivore) {
            return HERBIVORE;
        } else if (entity instanceof Predator) {
            return PREDATOR;
        } else if (entity instanceof Grass) {
            return GRASS;
        } else if (entity instanceof Tree) {
            return TREE;
        } else if (entity instanceof Rock) {
            return ROCK;
        }
return EMPTY_SPACE;
//        throw new IllegalArgumentException("Unknown entity: " + entity);

    }

//    private String getBackgroundColor(Entity entity) {
//        if (entity instanceof Creature creature) {
//            if (creature.getHealth() <= 15 || creature.getHunger() >= 85) {
//                return DANGER_BACKGROUND;
//            } else if (creature.getHealth() <= 30 || creature.getHunger() >= 70){
//                return WARNING_BACKGROUND;
//            }
//        }
//        return REGULAR_BACKGROUD;
//    }


}
