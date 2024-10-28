package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    // 차의 이름을 저장하는 필드, 고유 식별자로 판단하여 final 설정
    private final String carName;

    // 차의 위치를 출력하기 위한 리피터, 생성자를 통해 설정

    private String repeater;
    // 차의 위치를 저장하는 필드

    private int position;
    public RacingCar(String carName, int position, String repeater) {
        this.carName = carName;
        this.repeater = repeater;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean isMovable){
        if(isMovable){
            this.position++;
        }
    }

    public String getPositionAsString(){
        return repeater.repeat(position);
    }

    public void setRepeater(String repeater) {
        this.repeater = repeater;
    }



}