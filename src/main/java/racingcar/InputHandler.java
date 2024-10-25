package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static List<Car> inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] tokens = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String token : tokens) {
            String carName = token.trim();
            if (!carName.isEmpty()) {
                validateCarName(carName);
                cars.add(new Car(carName));
            }
        }
        return cars;
    }

    private static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static int inputTurns() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int turns = Integer.parseInt(Console.readLine());
            validateTurns(turns);
            return turns;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수형이어야 합니다.");
        }
    }

    private static void validateTurns(int turns) {
        if (turns < 0) {
            throw new IllegalArgumentException("시도 횟수는 0회 이상만 가능합니다.");
        }
    }
}
