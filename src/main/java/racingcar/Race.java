package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<RacingCar> racingCars;

    public Race(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void startRacing(int inputMoves) {
        System.out.println("실행 결과");
        for (int i = 0; i < inputMoves; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.move();
            }
            OutputHandler.printCars(racingCars);
        }
    }

    public List<String> getWinners() {
        int maxPosition = racingCars.stream().mapToInt(RacingCar::getPosition).max().orElse(0);

        List<String> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() == maxPosition) {
                winners.add(racingCar.getName());
            }
        }
        return winners;
    }
}
