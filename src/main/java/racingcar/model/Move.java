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

    public void MoveFoward(Car car){

    }
}
