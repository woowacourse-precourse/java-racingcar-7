package racingcar.domain;

public class Car {
    private String name;
    private int movedCnt;

    public Car(String name) {
        this.name = name;
        this.movedCnt = 0;
    }

    public void increaseMovedCount() {
        movedCnt++;
    }
}
