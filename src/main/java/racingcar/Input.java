package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.Validate.InvalidRange;

class Input {
    final String nameInput = Console.readLine();
    final String numberInput = Console.readLine();

    static ArrayList<String> splitInput(String input) {
        String[] nameContainer = input.split(",");
        ArrayList<String> names = new ArrayList<>();

        for (String name : nameContainer) {
            String trimedName = name.trim();
            Validate.checkName(trimedName);
            if (names.contains(trimedName)) {
                throw new Validate.DuplicateNameDetected();
            }
            names.add(trimedName);
        }
        return names;
    }

    static ArrayList<String> getCarNames(String input) {
        return Input.splitInput(input);
    }

    static int getNumber(String input) {
        int number = Integer.parseInt(input);
        if (!Validate.validNumber(number)) {
            throw new InvalidRange();
        }
        return number;
    }
}
