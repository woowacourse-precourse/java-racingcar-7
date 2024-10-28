package racingcar.car;

import racingcar.name.Name;
import racingcar.utils.RandomNumberGenerator;

public class Car {

    private final int MOVEABLE_NUMBER = 4;
    private final String COLON_WITH_BLANK = " : ";
    private final String HYPHAN = "-";

    private final Name name;
    private int status;

    public Car (Name name){
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }

    public int getStatus(){
        return status;
    }

    public void shellMove() {
        move(RandomNumberGenerator.getRandomNum());
    }

    public void move(int num){
        if (num >= MOVEABLE_NUMBER) {
            status++;
        }
    }

    public boolean isWinner(Car car, int winnerMovement) {
        return car.getStatus() == winnerMovement;
    }

    public String getRaceStatus(){
        return name + COLON_WITH_BLANK + HYPHAN.repeat(status);
    }

    @Override
    public String toString() {
        return name.toString();
    }

}
