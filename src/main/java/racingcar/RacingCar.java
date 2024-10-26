package racingcar;

import java.util.Objects;

public class RacingCar {
    String carName;
    String currentLocation;
    int currentDistance;

    RacingCar(){
        this.carName = "";
        this.currentLocation = "";
        this.currentDistance = 0;
    }

    // 한글 영어 포함 정규 표현식 /^[가-힣a-zA-Z]+$/
    void setCarName(String name) throws Exception{

        if (name.matches("^[(가-힣a-zA-Z)]{1,5}$")) {
            this.carName = name;
        }
        else{
            throw new IllegalArgumentException("이름은 5글자 이하의 한글 또는 영어로 구성되어야 합니다.");
        }

    }
}
