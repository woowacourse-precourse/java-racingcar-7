package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CarsNameParser {


    static Set<String> parse(String carNamesInput) {
        Set<String> carNames = new HashSet<>();
        for (String carName : carNamesInput.split(",", -1)) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("이름이 비어있습니다.");
            }
            if (carName.contains(" ")) {
                throw new IllegalArgumentException("이름에 공백 문자가 있습니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름이 5글자 이상입니다.");
            }
            carNames.add(carName);
        }
        return carNames;
    }


}
