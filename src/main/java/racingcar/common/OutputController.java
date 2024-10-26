package racingcar.common;

import racingcar.model.CarName;
import racingcar.model.RacingCar;

import java.util.List;

public class OutputController {
    public static void printCarNamePromptMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRaceCountPromptMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printWinnerName(List<CarName> carNameList) {
        List<String> carNameStringList = carNameList.stream()
                .map(CarName::carName)
                .toList();


        System.out.println("최종 우승자 : " + String.join(", ", carNameStringList));
    }

    public static void printExecutionResultPromptMessage() {
        System.out.println("실행 결과");
    }

    public static void printRacingCarsPosition(List<RacingCar> racingCarList) {
        racingCarList.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }
}
