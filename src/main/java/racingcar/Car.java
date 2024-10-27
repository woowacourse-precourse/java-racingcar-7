package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        position++;
    }

    public void printPosition() {
        System.out.println(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}
