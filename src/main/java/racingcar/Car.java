package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private int position;

    public Car(String carName) {
        isCarNameString(carName);
        isCarNameLengthFive(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4){
            position++;
        }
    }

    public static void isCarNameString(String carName){
        for (int i = 0; i < carName.length(); i++) {
            if(Character.isDigit(carName.charAt(i))){
                throw new IllegalArgumentException("문자 이외의 값은 입력할 수 없습니다.");
            }
        }
    }

    public static void isCarNameLengthFive(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 제한됩니다.");
        }
    }
}
