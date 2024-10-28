package racingcar.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        if (name.length() > 6) {
            throw new IllegalArgumentException("이름 길이가 6 이상입니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름이 없습니다");
        }
    }

    public ArrayList<String> changeSameName(ArrayList<String> cars) {
        Map<String, Long> checkSameName = new HashMap<>();

        for (String name : cars) {
            checkSameName.put(name, checkSameName.getOrDefault(name, 0L) + 1);
        }

        for (String name : checkSameName.keySet()) {
            if (checkSameName.get(name) == 1) {
                checkSameName.remove(name);
            }
        }

        for (int i = cars.size() - 1; i >= 0; i--) {
            String car = cars.get(i);
            Long counter = checkSameName.get(car);

            car += "-" + counter.toString();
            checkSameName.put(car, counter - 1);

            cars.set(i, car);
        }

        return cars;
    }

    public Long convertTryCount(String input) {
        try {
            return Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
