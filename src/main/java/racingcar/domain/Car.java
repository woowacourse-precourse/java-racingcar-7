package racingcar.domain;

import static racingcar.constant.DomainConstant.MOVE_THRESHOLD;

public class Car {
    private int position;

    public int getPosition(){
        return position;
    }

    public void move(int randomValue){
        if(randomValue >= MOVE_THRESHOLD){
            this.position += 1;
        }
    }
}
