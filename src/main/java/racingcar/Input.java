package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<String> carNames = splitCarNames(inputCarNames);
        List<String> trimCarNames = trimCarNames(carNames);
        Validate.vaildateCar(trimCarNames);
        return trimCarNames;
    }

    public int getGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputGameCount = Console.readLine();
        Validate.validateGameCountIsNumber(inputGameCount);
        int gameCount = convertStrToInt(inputGameCount);
        Validate.validateGameCount(gameCount);
        return gameCount;
    }

    public static List<String> splitCarNames(String inputCarNames) {
        return List.of(inputCarNames.split(","));
    }

    public static List<String> trimCarNames(List<String> carNames) {
        List<String> trimNames = new ArrayList<>();
        for (String carName : carNames) {
            trimNames.add(carName.trim());
        }
        return trimNames;
    }

    public static int convertStrToInt(String inputGameCount) {
        return Integer.parseInt(inputGameCount);
    }
}
