package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataParser {
    public static List<RacingCar> parseName(String input) {
        List<String> list = Arrays.asList(input.split(","));

        for (int i = 0; i < list.size(); i++) {
            isNonEmpty(list.get(i));
            list.set(i, list.get(i).trim());
            checkLenght(list.get(i));
            isAlphaNumeric(list.get(i));
        }
        isSame(list);
        return createRacingCar(list);
    }

    private static void isNonEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkLenght(String input) {
        final int MAX_LENGHT = 5;

        if (input.length() > MAX_LENGHT) {
            throw new IllegalArgumentException();
        }
    }

    private static void isAlphaNumeric(String input) {
        isLetterOrDigit(input);
    }

    private static void isSame(List<String> list) {
        Set<String> set = new HashSet<>(list);
        if (set.size() < list.size()) {
            throw new IllegalArgumentException("중복 작성");
        }
    }

    private static List<RacingCar> createRacingCar(List<String> list) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            RacingCar racingCar = new RacingCar(list.get(i));
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }

    public static int parseCount(String tryCount) {
        for (char c : tryCount.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(tryCount);
    }

    private static void isLetterOrDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                throw new IllegalArgumentException();
            }
        }
    }
}