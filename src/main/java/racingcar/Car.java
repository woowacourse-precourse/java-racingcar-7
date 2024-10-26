package racingcar;

public class Car {

    public String name;

    public int score=0;

    public int randomValue;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRandomValue(int randomValue) {
        this.randomValue = randomValue;
    }

    public int getRandomValue() {
        return randomValue;
    }
}
