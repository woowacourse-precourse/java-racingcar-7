package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String racingCarNameInput = inputString("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> racingCars = Arrays.asList(racingCarNameInput.split(","));
    }

    private static String inputString() {
        return inputString(null);
    }

    private static String inputString(String message) {
        if (message == null) {
            return Console.readLine();
        }
        System.out.println(message);
        return Console.readLine();
    }
}
