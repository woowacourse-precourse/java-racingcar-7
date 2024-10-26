package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParser {
    public static List<RacingCar> parseName(String input) {
        List<String> list = Arrays.asList(input.split(","));

        isNonEmpty(list);
        checkLenght(list);
        isAlphaNumeric(list);
        return createRacingCar(list);
    }

    public static int parseCount(String tryCount) {
        for (char c : tryCount.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(tryCount);
    }

    private static List<RacingCar> createRacingCar(List<String> list) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            RacingCar racingCar = new RacingCar(list.get(i));
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }

    private static void isAlphaNumeric(List<String> list) {
        for (String input : list) {
            isLetterOrDigit(input);
        }
    }

    private static void isLetterOrDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkLenght(List<String> list) {
        final int MAX_LENGHT = 5;

        for (String s : list) {
            if (s.length() > MAX_LENGHT) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isNonEmpty(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isBlank()) {
                throw new IllegalArgumentException();
            }
            list.set(i, list.get(i).trim());
        }
    }

}
