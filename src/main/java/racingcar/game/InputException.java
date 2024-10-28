package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.ErrorMessage;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.HashSet;

public class InputException {
    public static void getCarName(ArrayList<Car> carList) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

        try {
            String[] carInput = Console.readLine().split(",");
            validateCarList(carInput);
            for (String s : carInput) {
                validateCarName(s);
                carList.add(new Car(s));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.toString());
        }
    }
    public static void validateCarList(String[] carInput) {
        HashSet<String> carNameSet = new HashSet<>();
        for (String s : carInput) {
            if (!carNameSet.add(s)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME.toString());
            }
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
