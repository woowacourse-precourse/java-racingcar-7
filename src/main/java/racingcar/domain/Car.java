package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int LIMIT = 4;
    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void move(){
        if(Randoms.pickNumberInRange(0, 9) >= LIMIT ){
            distance++;
        }
    }

    public String getName(){
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validateName(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("이름은 빈 문자열이 불가능합니다.");
        }
        if(name.length() >= 6){
            throw new IllegalArgumentException("이름은 5자 이하로 작성해야합니다.");
        }
    }
}