package simulation.dialogs;

import java.util.List;

public class EnglishLetterSelectDialog extends AbstractDialog<Character>{
    List<Character> keys;
    public EnglishLetterSelectDialog(String title, String error, List<Character> keys) {
        super(title, error);
        this.keys = keys;
    }

    @Override
    protected boolean isTypeValid(String input) {
        return input.length() == 1;
    }

    @Override
    protected Character parseInput(String input) {
        return input.charAt(0);
    }

    @Override
    protected boolean isAllowed(Character result) {
        result = Character.toUpperCase(result);
        return keys.contains(result);
    }

    @Override
    public Character input() {
        while (true) {
            showTitle();
            String input = scanner.nextLine();

            if (isTypeValid(input)) {
                Character result = parseInput(input);
                if (isAllowed(result)) {
                    return result;
                }
            }
            showError();
        }
    }
}
