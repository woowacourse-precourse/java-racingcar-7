package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    public static List<String> inputCarName() {
        String input = Console.readLine();
        checkInput(input);
        List<String> carList = Arrays.asList(input.split(","));
        checkName(carList);
        return carList;
    }

    private static void checkInput(String input) {
        if(input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("빈 문자열입니다.");
    }

    private static void checkName(List<String> carList) {
        for(String carName : carList) {
            if(carName == null || carName.trim().isEmpty())
                throw new IllegalArgumentException("이름이 빈 값입니다.");
            if(carName.length() > 5)
                throw new IllegalArgumentException("각 이름은 5자 이하여야 합니다.: " + carName);
        }
    }
}
