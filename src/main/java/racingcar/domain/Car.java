package racingcar.domain;

public class Car {
    String name;
    int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move(int number){
        if (number >= 4){
            this.moveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
