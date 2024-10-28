package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private Race race;

    public RaceGame(Race race) {
        this.race = race;
    }

    public void playRacing() {
        for (int i = 0; i < race.getTryCount(); i++) {
            carsMove();
            OutputView.printRacingResult(race.getCars());
        }

        OutputView.printWinner(getWinner());
    }

    private void carsMove() {
        for (Car car : race.getCars()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.moveCar();
            }
        }
    }

    private List<String> getWinner() {
        int maxPosition = 0;
        List<String> winner = new ArrayList<>();

        for (Car car : race.getCars()) {
            maxPosition = getMaxPosition(car.getPosition(), maxPosition);
        }

        for (Car car : race.getCars()) {
            if (car.getPosition() == maxPosition) {
                winner.add(car.getName());
            }
        }

        return winner;
    }

    private int getMaxPosition(int position, int maxPosition) {
        if (position >= maxPosition) {
            return position;
        }

        return maxPosition;
    }
}
