package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptCountString = Console.readLine();
        int attemptCount = Integer.parseInt(attemptCountString);

        List<Car> carList = splitCarNames(carNames, attemptCount);
    }

    public static List<Car> splitCarNames(String carNames, int attemptCount) {
        String[] carNamesArray = carNames.split(",");
        List<Car> carNameList = new ArrayList<>();

        for (String carName : carNamesArray) {
            carNameList.add(new Car(carName, attemptCount));
        }

        return carNameList;
    }
}
