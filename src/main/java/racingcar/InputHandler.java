package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static List<Car> getValidateCarName(String input) {
        Validator.validateUserInput(input);
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            Validator.validateCarName(name.trim());
            cars.add(new Car(name.trim()));
        }

        return cars;
    }

    public static List<Car> getUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String input = Console.readLine();
        return getValidateCarName(input);
    }

    public static int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 숫자여야 합니다.");
        }
    }
}