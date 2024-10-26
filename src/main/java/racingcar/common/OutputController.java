package racingcar.common;

import racingcar.model.CarName;

import java.util.List;

public class OutputController {
    public static void printCarNamePromptMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRaceCountPromptMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printWinnerName(List<CarName> carNameList){
        List<String> carNameStringList = carNameList.stream()
                .map(CarName::carName)
                .toList();

        System.out.println(String.join(", ", carNameStringList));
    }
}
