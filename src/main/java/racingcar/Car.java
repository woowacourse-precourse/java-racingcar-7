package racingcar;

public class Car {

    private String name;
    private int moveDistance;

    public Car(String name) {
        this.name = name;
        this.moveDistance = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveDisctance() {
        return moveDistance;
    }

    public void move(int randomNumber){
        if(randomNumber >= 4){
            moveDistance++;
        }
    }
}
