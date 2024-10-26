package racingcar;

import java.util.ArrayList;

public class Car {
    private static ArrayList<String> moveList;

    ArrayList<String> move(){
        if(RandomNumber.getRandomNum() >= 4){
            moveList.add("-");
        }
        return moveList;
    }

    public static ArrayList<String> getMoveList() {
        return moveList;
    }
}
