package racingcar;

import java.util.LinkedHashMap;

public class CarInformation {

    public static LinkedHashMap<String, Integer> getCarInformation() {
        String carName = Input.inputCarName();

        LinkedHashMap<String, Integer> carNameAndScore = new LinkedHashMap<>();
        String[] names = carName.split(",");

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            if (!name.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException("자동차 이름은 영문으로 입력해주세요.");
            }
            carNameAndScore.put(name, 0);

        }
        return carNameAndScore;
    }
}
