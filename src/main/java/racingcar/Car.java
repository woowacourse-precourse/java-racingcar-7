package racingcar;

public class Car {
    private final static int STANDARD_NUMBER = 4;
    private final static String CAR_INFO_DELIMITER = " : ";
    private final static String CAR_POSITION_BAR = "-";
    private final String name;
    private int position;


    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void go(int number) {
        if (number >= STANDARD_NUMBER) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.name + CAR_INFO_DELIMITER + CAR_POSITION_BAR.repeat(this.position);
    }
}
