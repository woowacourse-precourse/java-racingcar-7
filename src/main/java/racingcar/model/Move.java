package racingcar.model;

import java.util.Random;

public class Move {

    private int createRandomValue(){
        Random random = new Random();
        int randomValue = random.nextInt(10);
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
            car.settingPosition(car.getPosition()+1);
        }
    }
}
