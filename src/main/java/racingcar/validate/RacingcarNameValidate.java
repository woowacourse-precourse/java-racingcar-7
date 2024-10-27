package racingcar.validate;

import java.util.List;

public class RacingcarNameValidate {

    public void isBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 공백");
        }
    }

    public void isDuplicate(List<String> carList) {
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 중복");
        }
    }

    public void isMoreThanFiveLetters(List<String> carList) {
        if (carList.stream().anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름 글자수 초과");
        }
    }
}
