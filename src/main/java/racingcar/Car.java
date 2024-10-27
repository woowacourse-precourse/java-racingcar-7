package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private int distance;

    public Car(String name){
        this.carName = name;
        this.distance = 0;
    }

    public String getCarName(){
        return carName;
    }

    public int getDistance(){
        return distance;
    }

    public void takeTurn(){
        //조건에 맞으면 거리 1만큼 증가
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if(randomNumber >= 4){
            distance = distance + 1;
        }
    }

}
