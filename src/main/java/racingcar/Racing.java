package racingcar;

public class Racing {

    private final RacingCars racingCars;
    private final Track track;

    public Racing(RacingCars racingCars, Track track) {
        this.racingCars = racingCars;
        this.track = track;
    }

    public void startRacing() {
        while (track.isLapInProgress()) {
            moveRacingCars();
            track.decrementLap();
        }
    }

    private void moveRacingCars() {
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
}
