package racingcar.model;

import racingcar.validator.CarNameValidator;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private String name;
    private int movedNumber;

    public Car(String name, CarNameValidator carNameValidator){
        carNameValidator.isValidCarName(name);
        this.name = name;
        this.movedNumber = 0;
    }

    public boolean isWinner(int maxMovedNumber){
        return maxMovedNumber == this.movedNumber;
    }

    public void move(int movedNumber){
        if(canCarMove(movedNumber)){
            this.movedNumber += movedNumber;
        }
    }

    private boolean canCarMove(int moveNumber){
        return moveNumber >= MOVE_THRESHOLD;
    }

    public String getName(){
        return this.name;
    }

    public int getMovedNumber(){
        return this.movedNumber;
    }
}
