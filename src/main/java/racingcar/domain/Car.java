package racingcar.domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isMoved(int randomNumber) {
        return randomNumber >= 4;
    }

    public void move() {
        distance++;
    }

    public void printEachStep() {
        System.out.print(name + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
