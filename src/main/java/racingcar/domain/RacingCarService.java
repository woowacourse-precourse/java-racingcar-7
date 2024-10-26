package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.RacingCarOutput;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private List<RacingCar> cars;
    private Integer number;
    private RacingCarOutput racingCarOutput = new RacingCarOutput();
    private List<RacingCar> winners = new ArrayList<>();

    public RacingCarService(List<RacingCar> cars, Integer number) {
        this.number = number;
        this.cars = cars;
    }

    public boolean rollMoveDice() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void moveRacingCars() {
        for (RacingCar car : cars) {
            if (rollMoveDice()) {
                car.moveForward();
            }
        }
    }

    public void startRacing() {
        for (int i = 0; i < number; i++) {
            moveRacingCars();
            racingCarOutput.printCurrentScore(this.cars);
        }
        findWinner();
    }

    public void findWinner() {
        winners.clear();
        for (RacingCar car : cars) {
            if (winners.isEmpty()) {
                winners.add(car);
                continue;
            }
            if (car.getPosition() == winners.getFirst().getPosition()) {
                winners.add(car);
                continue;
            }
            if (car.getPosition() > winners.getFirst().getPosition()) {
                winners.clear();
                winners.add(car);
            }
        }
    }

    public List<RacingCar> getWinners() {
        return winners;
    }
}
