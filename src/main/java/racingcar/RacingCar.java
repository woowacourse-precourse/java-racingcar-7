package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private String name;
    private String distance;

    public RacingCar(String name){
        this.name = name;
        this.distance = "";
    }

    // 랜덤하게 자동차를 전진한다.
    public void move(){
        int rand = Randoms.pickNumberInRange(0, 9);
        if(rand >= 4){
            distance += '-';
        }
    }

    // 현제 자동차 이동상태를 출력한다.
    public void printMoveState(){
        System.out.println(name + " : " + distance);
    }

    // 자동차 이름을 가져온다.
    public String getName(){
        return name;
    }

    // 자동차 이동 거리를 출력한다.
    public int getDistance(){
        return distance.length();
    }
}
