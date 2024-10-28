package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.controller.CarController;
import racingcar.model.Car;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        List<Car> carList = CarController.makeCarList(CarController.makeCarNameList(userInput));

        System.out.println("시도할 횟수는 몇 회인가요?");
        int roundNumber = Integer.valueOf(Console.readLine());

        System.out.println("\n실행 결과");
        CarController.gameResult(carList, roundNumber);
    }
}
