package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Cars;

public class View {
    public static String displayCarNameInputPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine().trim();
        return carNamesInput;

    }

    public static int displayTryCountInputPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine().trim();
        return Integer.parseInt(tryCountInput);

    }

    public static void printlnRaceResult() {
        System.out.println("실행 결과");
    }

    public static void printMoveResult(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

}
