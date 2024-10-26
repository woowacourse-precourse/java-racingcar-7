package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {

    String name;
    int moveCnt = 0;
    String moveChart = "";

    Car(String name){

        validateName(name);
        this.name = name;
    }

    void validateName(String input){
        int maxSize = 5;
        if(input.length() > maxSize  ){
            throw new IllegalArgumentException(" length of name is over Max length " + maxSize + " .");
        }

    }


    int moveForward(){

       if(isMoveSuccess()){
           this.moveCnt++;
           this.moveChart +="-";
       }


       System.out.println(this.name+ " : " + this.moveChart);

       return moveCnt;
    }

    boolean isMoveSuccess(){

        int val = Randoms.pickNumberInRange(0,9);

        if(val>=4){
            return true;
        }

        return false;


    }
}
