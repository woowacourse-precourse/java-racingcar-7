package racingcar.model;

public class RacingCar {

    private final String name;
    private int currentPosition;

    public RacingCar(final String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public RacingCar(final String name, final int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public void move(final RacingCarMove racingCarMove, final RandomNumber randomNumber) {
        this.currentPosition += racingCarMove.move(randomNumber);
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    private String convertIntToPosition() {
        String position= "";
        for (int i = 0; i < getCurrentPosition();++i) {
            position = position.concat("-");
        }
        return position;
    }

    @Override
    public String toString() {
        return getName() + " : " + convertIntToPosition();
    }
}
