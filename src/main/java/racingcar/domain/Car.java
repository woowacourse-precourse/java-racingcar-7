package racingcar.domain;

public class Car {
    String name;
    int racingStatus;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRacingStatus() {
        return racingStatus;
    }

    public void go() {
        this.racingStatus += 1;
    }

    public void printStatus() {
        System.out.print(name + " : ");
        for (int i = 1; i <= this.racingStatus; i++) {
            System.out.print("-");
        }
        ;
    }


}
