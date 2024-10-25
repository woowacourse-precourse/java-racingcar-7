package domain;

public class Car {
    private RandomGenerator generator;
    private String carName;
    private int carLocation;
    public static final int MOVABLENUMBER = 4;

    // 생성자(객체)
    public Car(final String carName, final int carLocation) {
        this.carName = carName;
        this.carLocation = carLocation;
        this.generator = new RandomGenerator();
    }

    public String getCarName() {
        return carName;
    }

    // 자동차의 현재 위치
    public int getCarLocation() {
        return carLocation;
    }

    // 값이 4 이상이라면 전진
    public void move() {
        final int value = generator.randomGenerator();
        if (value >= MOVABLENUMBER) {
            carLocation++;
        }
    }
}
