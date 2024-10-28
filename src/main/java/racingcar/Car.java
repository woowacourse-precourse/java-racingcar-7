package racingcar;

public class Car {
    private String name;
    private int forwardCount = 0;

    public Car(String name) {
        this.name = name;
    }

    void incrementFowardCount(int randomNumber) {
        if (randomNumber >= 4) {forwardCount++;}
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
