package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.io.InputReader;
import racingcar.io.OutputWriter;
import racingcar.strategy.RandomMoveStrategy1;

public class Application {
    public static void main(String[] args) {

        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = inputReader.carName();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = inputReader.attemptCount();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Race race = new Race(cars, attemptCount, outputWriter);
        race.start(new RandomMoveStrategy1());

    }
}
