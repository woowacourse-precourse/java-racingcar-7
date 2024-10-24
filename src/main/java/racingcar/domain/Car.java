package racingcar.domain;

import java.io.UnsupportedEncodingException;

public class Car {
    private static final int MAX_LEGNTH = 5;
    private final String carName;
    private int stepCount = 0;


    public Car(String carName){
        checkValidCarName(carName);
        this.carName = carName;
    }


    private void checkValidCarName(String carName){
        checkCarNameLength(carName);
        checkNameInSpace(carName);
    }
    private void checkCarNameLength(String carName) {
        try{
            if(carName.getBytes("UTF-8").length < 1) throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
            if(carName.getBytes("UTF-8").length > MAX_LEGNTH) throw new IllegalArgumentException("이름이 최대 길이를 넘어갑니다.");
        }
        catch (UnsupportedEncodingException e){
            throw new IllegalArgumentException("자바에서 지원하지 않은 문자인코딩을 사용했습니다.");
        }
    }
    private void checkNameInSpace(String carName){
        if(carName.matches(".*[ ]+.*")) throw new IllegalArgumentException("이름 내에 띄어쓰기가 포함되어 있습니다.");
    }

    public void nextStep(){
        this.stepCount += 1;
    }
    public int getStepCount() {
        return stepCount;
    }

    public String getCarName() {
        return carName;
    }
}
