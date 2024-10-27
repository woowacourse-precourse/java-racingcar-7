package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Racingcars {
    private final List<Racingcar> racingcarList;

    public Racingcars() {
        this.racingcarList = new ArrayList<>();
    }

    public void addCar(Racingcar racingcar) {
        racingcarList.add(racingcar);
    }

    public List<Racingcar> getRacingcarList() {
        return racingcarList;
    }

    public void makeMiddleResult(StringBuilder middleResult) {

        for (Racingcar racingcar : racingcarList) {
            racingcar.move(middleResult);
        }
        middleResult.append("\n");
    }

    public String makeFinalResult() {
        int max = 0;
        String winner = "";
        for (Racingcar racingcar : racingcarList) {
            int compareDistance = racingcar.getDistanceLength();
            if (max < compareDistance) {
                max = compareDistance;
                winner = racingcar.getName();
                continue;
            }
            if (max == compareDistance) {
                winner += ", " + racingcar.getName();
            }
        }
        return winner;
    }
}
