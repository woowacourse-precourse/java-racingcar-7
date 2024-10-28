package racingcar.validator;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Validator {

    public ArrayList<String> splitByComma(String input) {
        ArrayList<String> result = new ArrayList<>();
        for (String name : input.split(",")) {
            name = name.trim();
            nameLengthCheck(name);
            result.add(name);
        }

        return result;
    }

    private static void nameLengthCheck(String name) {
        if (name.length() >= 6) {
            throw new IllegalArgumentException("이름 길이가 6 이상입니다.");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("이름이 없습니다");
        }
    }

    public ArrayList<String> changeSameName(ArrayList<String> cars) {
        Map<String, Long> checkSameName = new ConcurrentHashMap<>();

        cars.forEach(car ->
                plusCarCount(car, checkSameName)
        );

        for (String name : checkSameName.keySet()) {
            eraseOnlyOneCar(name, checkSameName);
        }

        for (int i = cars.size() - 1; i >= 0; i--) {
            modifySameName(cars, i, checkSameName);
        }

        return cars;
    }

    private static void plusCarCount(String car, Map<String, Long> checkSameName) {
        checkSameName.compute(car, (key, value) -> {
            if (value == null) {
                return 1L;
            } else {
                return value + 1;
            }
        });
    }

    private static void eraseOnlyOneCar(String name, Map<String, Long> checkSameName) {
        if (checkSameName.get(name) == 1) {
            checkSameName.remove(name);
        }
    }

    private static void modifySameName(ArrayList<String> cars, int index, Map<String, Long> checkSameName) {
        String car = cars.get(index);
        Long counter = checkSameName.get(car);

        if (counter == null) {
            return;
        }

        checkSameName.put(car, counter - 1);
        car += "-" + counter;

        cars.set(index, car);
    }

    public Long convertTryCount(String input) {
        try {
            return Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
