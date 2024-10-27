package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    public static void run() {
        String carNames[] = InputView.startView();
        int tryNum = InputView.tryNum();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        Race race = new Race(cars);

        for (int i = 0; i < tryNum; i++) {
            race.racing();
            OutputView.printResult(race.getCars());
        }

        List<String> winners = findWinner(race);
        OutputView.printWinner(winners);
    }

    private static List<String> findWinner(Race race) {
        int max = race.getCars().stream().mapToInt(Car::getStickcnt).max().orElse(0);
        return race.getCars().stream().filter(Car -> Car.getStickcnt() == max).map(Car::getName)
                .collect(Collectors.toList());
    }
}
