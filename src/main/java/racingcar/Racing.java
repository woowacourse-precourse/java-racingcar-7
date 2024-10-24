package racingcar;

import java.util.List;

public class Racing {

    private final RacingCars racingCars;

    public Racing(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public static Racing from(RacingCars racingCars) {
        return new Racing(racingCars);
    }

    public List<String> getWinnerCarNames() {
        return racingCars.getWinners();
    }

    public void moveCars() {
        for (RacingCar racingCar : racingCars.getCars()) {
            if (canMove()) {
                racingCar.move();
            }
        }
    }

    private boolean canMove() {
        int start = 0;
        int end = 9;
        int conditionNumber = 4;

        return RandomNumber.generateInRange(start, end) >= conditionNumber;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (RacingCar racingCar : racingCars.getCars()) {
            builder.append(getRacingCarData(racingCar));
        }
        builder.append("\n");

        return builder.toString();
    }

    private String getRacingCarData(RacingCar racingCar) {
        String positionMark = "-";

        return String.format(
            "%s : %s\n",
            racingCar.getName(),
            positionMark.repeat(racingCar.getPosition())
        );
    }
}
