package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {

    public void checkCarName(String input) {
        checkLastIndexCar(input);
        List<String> racerNames = new ArrayList<>(Arrays.asList(input.split(",")));
        for (String racerName : racerNames) {
            checkValidCarName(racerName);
        }
        checkCarNameDuplicate(racerNames);
    }

    public void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    public void checkLastIndexCar(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
    }

    private static void checkValidCarName(String racerName) {
        if (racerName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (racerName.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
        if (racerName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 없어야 합니다.");
        }
    }

    private void checkCarNameDuplicate(List<String> racerNames) {
        for (int i = 0; i < racerNames.size() - 1; i++) {
            for (int j = i + 1; j < racerNames.size(); j++) {
                checkEqualsName(racerNames, i, j);
            }
        }
    }

    private static void checkEqualsName(List<String> racerNames, int i, int j) {
        if (racerNames.get(i).equals(racerNames.get(j))) {
            throw new IllegalArgumentException("같은 이름을 가진 자동차가 존재합니다.");
        }
    }
}
