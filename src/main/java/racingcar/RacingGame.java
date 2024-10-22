package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private static String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String GAME_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public void start() {
        System.out.println(START_MESSAGE);
        String names = readLine();
        List<Car> cars = Stream.of(names.split(",")).map(name -> new Car(name.trim(), 0)).collect(Collectors.toList());
        System.out.println(GAME_COUNT_MESSAGE);
        int count = Integer.parseInt(readLine());
    }

    private void nameCheck(List<Car> cars) {
        for (Car car : cars) {
            if (car.name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
