package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;

    private int position;


    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if(canMove()){  //무작위 값이 4 이상일때만 전진
            position++;
        }
    }

    private boolean canMove(){
        return Randoms.pickNumberInRange(0, 10) >= MOVE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
