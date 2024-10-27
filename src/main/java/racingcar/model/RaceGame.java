package racingcar.model;

public class RaceGame {
    private final RaceCars raceCars;
    private final Movement movement;

    public RaceGame(RaceCars raceCars, Movement movement) {
        this.raceCars = raceCars;
        this.movement = movement;
    }

    public void moveAllCars() {
        raceCars.moveAllCars(movement);
    }

    public RaceCars getRaceCars() {
        return raceCars;
    }
}
