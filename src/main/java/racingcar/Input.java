package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public List<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<String> carNames = splitCarNames(inputCarNames);
        return trimCarNames(carNames);
    }

    public int getGameCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputGameCount = Console.readLine();

        return convertStrToInt(inputGameCount);
    }

    public static List<String> splitCarNames(String inputCarNames){
        return List.of(inputCarNames.split(","));
    }

    public static List<String> trimCarNames(List<String> carNames){
        List<String> trimNames = new ArrayList<>();
        for (String carName : carNames) {
            carName = carName.trim();
            Validate.validateCarNameLength(carName);
            trimNames.add(carName);
        }
        return trimNames;
    }

    public static int convertStrToInt(String inputGameCount){
        return Integer.parseInt(inputGameCount);
    }
}
