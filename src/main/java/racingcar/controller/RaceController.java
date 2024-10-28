package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.RaceGameInputView;
import racingcar.view.RaceGameOutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceController {

    public void startGame() {
        List<Car> cars = createCars();
        int attempts = RaceGameInputView.getRaceAttempts();

        Race race = new Race(cars, attempts);
        executeRaceRounds(race);
        RaceGameOutputView.printWinners(race.findWinners());
    }

    private List<Car> createCars() {
        List<String> carNames = RaceGameInputView.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars; // 생성된 Car 리스트 반환
    }

    private void executeRaceRounds(Race race) {
        for (int i = 0; i < race.attempts(); i++) {
            race.startRace();
            RaceGameOutputView.printRaceProgress(race.cars());
        }
    }
}
