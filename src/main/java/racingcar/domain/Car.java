package racingcar.domain;

public class Car {
    private final String name;
    public int move;

    public Car(String name, int move){
        this.name = name;
        this.move = move;
    }

    public String getName(){
        return name;
    }
    public int getMove(){
        return move;
    }
}
