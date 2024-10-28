package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {

    protected String name;
    protected int moveCnt = 0;

    public Car(String name){
        this.name = name;
    }

    public Car(Car origin){
        this.name = origin.name;
        this.moveCnt = origin.moveCnt;
    }

    public String getName(){
       return this.name;
    }

    public int getMove(){
        return this.moveCnt;
    }

    public int setMove(int move){
        this.moveCnt = move;

        return move;
    }
}
