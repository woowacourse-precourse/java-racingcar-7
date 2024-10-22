package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String carNames = readLine();
        List<String> carNameList = validCarNames(carNames);
    }

    public static List<String> validCarNames(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
        List<String> carName = List.of(carNames.split(",", -1));
        for (String name : carName) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름을 5자 이하로 적어주세요.");
            }
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
            }
        }
        return carName;
    }
}
