package racingcar.model;

public class Car {
    private final String name;
    private int stickcnt = 0;

    public Car(String name) {
        this.name = name;
    }

    public void carMove(int randomNum) {
        if (randomNum >= 4) {
            stickcnt++;
        }
    }

    public String getName() {
        return name;
    }

    public int getStickcnt() {
        return stickcnt;
    }
}
