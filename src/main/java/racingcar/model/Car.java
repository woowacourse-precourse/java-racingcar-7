package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private Integer distance;

    public Car(String name, Integer moveCount){
        this.name = name;
        tryMove(moveCount);
    }

    public void tryMove(Integer moveCount){
        for(int i = 0;  i < moveCount; i++){
            moveForward();
        }
    }

    private boolean isMoveForward(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private void moveForward(){
        if(isMoveForward()){
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
