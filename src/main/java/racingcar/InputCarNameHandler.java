package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputCarNameHandler {
    public List<String> getCarNames(){
        List<String> carNames = new ArrayList<>();
        String inputCarNames;

        System.out.print("경주할 자동차 이름을 2대 이상 입력하세요. : ");
        inputCarNames = Console.readLine().trim();

        String[] names = inputCarNames.split(",");

        for (String name : names) {
            String trimmedName = name.trim();
            carNames.add(trimmedName);
        }
        return carNames;
    }
}

