package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(","));
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptInput = Console.readLine();

        try {
            validateAttemptInput(attemptInput);
            int attempts = Integer.parseInt(attemptInput);

            Race race = new Race(cars);
            race.startRace(attempts);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private static void validateAttemptInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        int attempts = Integer.parseInt(input);
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
