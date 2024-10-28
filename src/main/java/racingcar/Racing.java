package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Racing {
    public static void startRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = Console.readLine();

        List<Car> cars = nameCars(carNames);
        
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();

        Play play = new Play(cars);
        System.out.println();
        play.play(tryCount);
        play.printWinner();
    }

    private static List<Car> nameCars(final String carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }

            cars.add(new Car(carName));
        }

        return cars;
    }
}
