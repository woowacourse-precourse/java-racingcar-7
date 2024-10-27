package racingcar.domain;

public class Player {
    private String carName;
    private int position;

    public Player(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static Player createPlayer(String carName) {
        return new Player(carName, 0);
    }

    public void moveCar(int add) {
        position += add;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
