package racingcar.car;

public class RacingCar {
    String name;
    int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0; // 초기 위치 0
    }

    public void position() {
        this.position++;
    }

    public static String getName() {
        return name;
    }

    public static int getPosition() {
        return position;
    }
}
