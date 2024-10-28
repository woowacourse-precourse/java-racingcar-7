package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.ErrorMessage;
import racingcar.car.Car;

import java.util.ArrayList;

public class InputException {
    public static void getCarName(ArrayList<Car> carList) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

        try {
            String[] carInput = Console.readLine().split(",");
            for (String s : carInput) {
                validateCarName(s);
                carList.add(new Car(s));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.toString());
        }
    }
    public static void validateCarName(String s) {
        if (s.length() > 5)
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME.toString());
    }
    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT.toString());
        }
    }
}
