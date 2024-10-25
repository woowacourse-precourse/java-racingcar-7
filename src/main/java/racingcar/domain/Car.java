package racingcar.domain;

public class Car {
    private static long carCnt;
    private long carId;
    private String name;
    private int loc;

    public Car( String name ) {
        this.carId = carCnt++;

        this.name = name;
        this.loc = 0;
    }
}
