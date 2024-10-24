package racingcar;

public class Car {
    private String name;
    private String moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = "";
    }

    public String getName() {
        return name;
    }

    public String getMoveCount() {
        return moveCount;
    }

    public void move(){
        moveCount+="-";
    }
}
