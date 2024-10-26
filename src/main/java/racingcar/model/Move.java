package racingcar.model;

import java.util.List;
import java.util.Random;

public class Move {
    private static int MOVE_RATE=1;
    private static int RANDOM_MAXIMUM=9;

    private int createRandomValue(){
        Random random = new Random();
        int randomValue = random.nextInt(RANDOM_MAXIMUM+1);
        return randomValue;
    }

    private boolean checkMovable(int randomValue){
        if(randomValue>=4) return true;
        return false;
    }

    public void moveFoward(Car car){
        int randomValue = createRandomValue();
        boolean isMovable = checkMovable(randomValue);
        if(isMovable){
            car.settingPosition(car.getPosition()+MOVE_RATE);
        }
    }
}
