package view;

import camp.nextstep.edu.missionutils.Console;
import error.ExceptionMessage;

public class InputView {

    public String inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.CARS_INPUT_EMPTY);
        }
        return cars;
    }

    public int inputCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String countString = Console.readLine();
        if (countString.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.COUNTS_INPUT_EMPTY);
        }
        return Integer.parseInt(countString);
    }

}
