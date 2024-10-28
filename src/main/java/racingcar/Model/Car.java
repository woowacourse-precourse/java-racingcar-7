package racingcar.Model;

import racingcar.Constants;
import racingcar.Utils;

public class Car {
    private String name;
    private int position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public void go(){
        if(Utils.getRandomNum() >= Constants.MOVE){
            this.position++;
        }
    }
    public String getName(){
        return this.name;
    }
    public int getPosition(){
        return this.position;
    }
    public String getRoundResult(){
        return this.name + " : " + Utils.repeatDash(this.position);
    }
    public boolean checkWinner(int winnerDistance){
        return this.position == winnerDistance;
    }
}
