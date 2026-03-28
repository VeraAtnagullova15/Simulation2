package simulation;

import simulation.core.RendererWorldMap;
import simulation.core.Simulation;
import simulation.core.SimulationThread;
import simulation.core.WorldMap;
import simulation.dialogs.Dialog;
import simulation.dialogs.EnglishLetterSelectDialog;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final static char START = 'S';
    private final static char STEP = 'T';
    private final static char PAUSE = 'P';
    private final static char RESTART = 'R';
    private final static char QUIT = 'Q';
    private final static List<Character> COMMANDS = List.of(START, STEP, PAUSE, RESTART, QUIT);

    public static void main(String[] args) {

        WorldMap worldMap = new WorldMap();
        RendererWorldMap renderer = new RendererWorldMap();
        Simulation simulation = new Simulation(worldMap, renderer);
        Runnable job = new SimulationThread(simulation);
        simulation.start();
        Thread thread = new Thread(job);
        Dialog<Character> letterSelectDialog = getEnglishLetterSelectDialog();

        while (true) {
            char type = letterSelectDialog.input();
            type = Character.toUpperCase(type);
            switch (type) {
                case 'T' -> {
                    simulation.nextTurn();
                }
                case 'S' -> {
                    if (!thread.isAlive())
                        thread.start();
                }
                case 'P' -> {
                    simulation.pauseSimulation();
                }
                case 'R' -> simulation.restartSimulationLoop();
                case 'Q' -> {
                    simulation.quitSimulation();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        }
    }

    private static Dialog<Character> getEnglishLetterSelectDialog() {
        String title = """
                Введите T - сделать один шаг, S - запустить симуляцию, P - пауза
                    R - рестарт симуляции после паузы, Q - завершение программы
                """;
        String error = "Неверная команда";
        return new EnglishLetterSelectDialog(title, error, COMMANDS);
    }
}
