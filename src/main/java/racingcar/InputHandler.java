package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static List<Car> getCarNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            name = name.trim();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
            cars.add(new Car(name));
        }
        return cars;
    }

    public static int getTrialCountFromUser() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int trials = Integer.parseInt(Console.readLine().trim());
            if (trials <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }
            return trials;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
