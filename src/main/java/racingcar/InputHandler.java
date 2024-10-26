package racingcar;

import  java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static List<String> getCarNames(String input) {
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : names) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty() || trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자이상 5자이하로 설정해야합니다!");
            }
            carNames.add(trimmedName);
        }
        return carNames;
    }
}
