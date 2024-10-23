package racingcar.model;

public class Car {
    private String name;
    private String moveCount;
    private int moving;

    public Car(String name, String moveCount) {
        this.name = name;
        this.moveCount = moveCount;
        this.moving = 0;
    }
    
    public String getName() {
        return this.name;
    }

    public String getMoveCount() {
        return this.moveCount;
    }

}
