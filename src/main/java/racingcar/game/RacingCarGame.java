package racingcar.game;

import java.util.List;
import racingcar.car.RacingCar;
import racingcar.car.RacingCars;
import racingcar.generator.Generator;

public class RacingCarGame {
    private final StringBuilder progress = new StringBuilder();
    private final Generator generator;

    public RacingCarGame(Generator generator) {
        this.generator = generator;
    }

    public String execute(final RacingCars racingCars, final int round) {
        playRound(round, racingCars);
        return progress.toString();
    }

    private void playRound(int round, RacingCars racingCars) {
        List<RacingCar> cars = racingCars.getCars();
        for (int i = 0; i < round; i++) {
            playSingleRound(cars);
            storeProgress(cars);
        }
    }

    private void playSingleRound(List<RacingCar> cars) {
        cars.forEach(car -> {
            int pickedNumber = generator.generate();
            car.moveIfRandomNumberIsAbove(pickedNumber);
        });
    }

    private void storeProgress(List<RacingCar> cars) {
        cars.forEach(car -> progress.append(String.format("%s : %s%n", car.getName(), car.getProgress())));
        progress.append("\n");
    }
}
