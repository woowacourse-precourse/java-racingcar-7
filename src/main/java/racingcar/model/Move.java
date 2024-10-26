package racingcar.model;

import java.util.Random;

public class Move {
    private static int MOVE_RATE=1;
    private static int RANDOM_VALUE_MAXIMUM=9;
    private static int RANDOM_VALUE_STANDARD=4;


    private int createRandomValue(){
        Random random = new Random();
        int randomValue = random.nextInt(RANDOM_VALUE_MAXIMUM+1);
        return randomValue;
    }

    private boolean checkMovable(int randomValue){
        if(randomValue>=RANDOM_VALUE_STANDARD) return true;
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
