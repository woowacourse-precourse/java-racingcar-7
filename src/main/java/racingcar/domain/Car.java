package racingcar.domain;

public class Car {

    final String name;
    private int moveCount;

    public Car(String name){
        this.name = name;
    }

    public void moveCarForward(){
        this.moveCount += 1;
    }

    public String getName(){
        return name;
    }

    public int getMoveCount(){
        return moveCount;
    }

}
