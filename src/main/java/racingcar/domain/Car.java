package racingcar.domain;


import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;

    public Car(String name){
        this.name = name;
        position = 0;
    }

    public void move(){
        if(isMovable()) position++;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

    private boolean isMovable(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
