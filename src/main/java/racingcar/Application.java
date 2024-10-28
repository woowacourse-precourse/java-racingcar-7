package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    //쉼표가 아닌 구분자 예외처리
    //공백 처리
    public static List<String> splitCarNames(String userInputNames) throws IllegalAccessError {
        List<String> carNames = Arrays.asList(userInputNames.split(","));
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(carName + "은 5글자가 넘습니다.");
            }
        }
        return carNames;
    }
}
