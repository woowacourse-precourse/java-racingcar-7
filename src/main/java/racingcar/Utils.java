package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.Constants.ATTEMPTS_REGEXP;
import static racingcar.Constants.CAR_NAME_REGEXP;

public class Utils {
    public static int generateRandomValue() {
        return pickNumberInRange(0, 9);
    }

    public static boolean checkMoveCondition(int randomNum) {
        return randomNum >= 4;
    }

    public static boolean validateInput(final String regExp, String input) {
        if (input.isEmpty() || input.isBlank() || !input.matches(regExp)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static boolean validateNameLimit(final ArrayList<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUniqueName(ArrayList<String> carNames) {
        Set<String> carNameSet = new HashSet<>();
        for (String name : carNames) {
            if (!carNameSet.add(name)) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<String> convertCarNames(final String nameInput) {
        ArrayList<String> carNames = new ArrayList<>();

        if (validateInput(CAR_NAME_REGEXP, nameInput)) {
            carNames = new ArrayList<>(Arrays.asList(nameInput.split(",")));
        }

        if (carNames.isEmpty() || !validateNameLimit(carNames) || !isUniqueName(carNames)) {
            throw new IllegalArgumentException();
        }
        return carNames;
    }

    public static int convertAttempts(final String countInput) {
        if (validateInput(ATTEMPTS_REGEXP, countInput)) {
            return Integer.parseInt(countInput);
        }
        return 0;
    }

    public static void println(String args) {
        System.out.println(args);
    }

}
