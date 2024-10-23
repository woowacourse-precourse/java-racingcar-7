package racingcar;

public class Model {

    String[] getCarNames(String inputString) {
        String[] carNames = inputString.split(",");

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과합니다.");
            }
        }
        return carNames;
    }
}
