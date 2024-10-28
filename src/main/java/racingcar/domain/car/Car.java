package racingcar.domain.car;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public String showStatus() {
        String progress = "-".repeat(position);
        String format = "%s : %s";

        return String.format(format, name, progress);
    }
}
