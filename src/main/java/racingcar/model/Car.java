package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int move(int randomNumber) {
        if (randomNumber >= 4) {
            this.position += randomNumber;
        }
        return this.position;
    }


    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
