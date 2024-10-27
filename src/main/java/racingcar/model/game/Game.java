package racingcar.model.game;

import java.util.List;
import racingcar.model.car.CarSnapshot;
import racingcar.model.car.Cars;

public class Game {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVEMENT_CRITERIA = 4;
    private static final int MINIMUM_NUMBER_OF_CARS = 2;

    private final Cars cars;
    private final TotalRounds totalRounds;
    private final NumberPicker numberPicker;
    private final Referee referee;
    private Winners winners;
    private int currentRound;

    public Game(Cars cars, TotalRounds totalRounds, NumberPicker numberPicker, Referee referee) {
        validateQualification(cars);

        this.cars = cars;
        this.totalRounds = totalRounds;
        this.currentRound = 0;
        this.numberPicker = numberPicker;
        this.referee = referee;
    }

    private void validateQualification(Cars cars) {
        if (cars.hasFewerNumberOfCarsThan(MINIMUM_NUMBER_OF_CARS)) {
            throw new IllegalArgumentException("최소 2대 이상 출전해야 합니다.");
        }
    }

    public void playNextRound() {
        for (int index = 0; index < cars.getSize(); index++) {
            int number = numberPicker.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

            if (number >= MOVEMENT_CRITERIA) {
                cars.move(index);
            }
        }
        currentRound++;
    }

    public boolean hasMoreRounds() {
        return totalRounds.hasMoreRoundsThan(currentRound);
    }

    public void judgeWinners() {
        this.winners = referee.judgeWinners(cars);
    }

    public List<CarSnapshot> getCarSnapshots() {
        return cars.getSnapshots(currentRound);
    }

    public List<String> getNameOfWinners() {
        if (winners == null) {
            throw new IllegalArgumentException("아직 우승자들이 등록되지 않았습니다.");
        }
        return winners.getNamesOfWinner();
    }
}
