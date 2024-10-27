package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Source.inputCarNames(Console.readLine());
        List<Car> cars = Arrays.stream(names)
                .map(Car::new)
                .toList();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int rounds = Source.inputAttempts(Console.readLine());

        Race race = new Race(cars);
        race.run(rounds);

        List<Car> winners = race.getWinners();
        Result.printWinners(winners);
    }
}
