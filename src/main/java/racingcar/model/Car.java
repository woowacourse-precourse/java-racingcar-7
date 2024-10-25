package racingcar.model;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private String name;
    private int movedNumber;

    public Car(String name){
        this.name = name;
        this.movedNumber = 0;
    }

    public void move(int movedNumber){
        if(canCarMove(movedNumber)){
            this.movedNumber += movedNumber;
        }
    }

    public int getMovedNumber(){
        return this.movedNumber;
    }

    private boolean canCarMove(int moveNumber){
        return moveNumber >= MOVE_THRESHOLD;
    }

    public String getName(){
        return this.name;
    }
}
