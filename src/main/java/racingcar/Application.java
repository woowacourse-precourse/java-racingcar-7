package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carName = Console.readLine();
        createCarNames(carName);
    }
    public static List<String> createCarNames(String carName) {
        List<String> carNames = Arrays.stream(carName.split(","))
                .toList();

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(name + "이름이 5자리가 넘습니다");
            }
        }

        return carNames;
    }
}
