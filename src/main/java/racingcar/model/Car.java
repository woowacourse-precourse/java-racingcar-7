package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private Long distance;

    public Car(String name, Long moveCount){
        this.name = name;
        tryMove(moveCount);
    }

    public void tryMove(Long moveCount){
        for(long i = 0;  i < moveCount; i++){
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
}
