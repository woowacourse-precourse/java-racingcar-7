package racingcar.Model;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String printResult() {
        String result = name + " : " + "-".repeat(position);
        return result;
    }
}
