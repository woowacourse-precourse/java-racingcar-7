package racingcar.model;

public class Car {
    private String name;
    private int step;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.step = 0;
    }

    public void go(int num) {
        if (num >= 4)
            this.step++;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
