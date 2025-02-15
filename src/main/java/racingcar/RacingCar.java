package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int moveCount;

    public RacingCar(String name){
        this.name = name;
        this.moveCount = 0;
    }

    public String getName(){
        return this.name;
    }
    public int getMoveCount(){
        return this.moveCount;
    }

    public void moveForward(){
        if(Randoms.pickNumberInRange(0, 9) >= 4){
            this.moveCount++;
        }
    }
}
