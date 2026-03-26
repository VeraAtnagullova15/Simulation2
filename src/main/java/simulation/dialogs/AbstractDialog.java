package simulation.dialogs;

import java.util.Scanner;

public abstract class AbstractDialog<E> implements Dialog<E> {

    protected final String title;
    protected final String error;
    public final Scanner scanner = new Scanner(System.in);

    public AbstractDialog(String title, String error) {
        this.title = title;
        this.error = error;
    }

    protected void showTitle() {
        System.out.println(title);
    }

    protected void showError() {
        System.out.println(error);
    }

    abstract protected boolean isTypeValid(String input);

    abstract protected E parseInput(String input);

    abstract protected boolean isAllowed(E result);

}
