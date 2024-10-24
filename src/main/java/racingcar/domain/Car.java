package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.RacingConstant;

public class Car {
    private String name;
    private int position;

    private Car(String name){
        this.name = name;
        this.position = 0;
    }

    public static Car from(String name){
        return new Car(name);
    }

    public void move(){
        if(Randoms.pickNumberInRange(RacingConstant.RANDOM_MIN_NUMBER, RacingConstant.RANDOM_MAX_NUMBER)
                >= RacingConstant.MOVE_STANDARD_NUMBER){
            position++;
        }
    }

    private void validateName(String name){
        checkNameEmpty(name);
        checkNameSize(name, RacingConstant.NAME_SIZE_LIMIT);
    }

    private void checkNameEmpty(String name){
        if(name.isBlank()){
            throw new IllegalArgumentException("자동차의 이름은 공백이나 빈 칸으로 이루어질 수 없습니다.");
        }
    }

    private void checkNameSize(String name, int size){
        if(name.length() <= size){
            throw new IllegalArgumentException("자동차의 이름이 너무 큽니다.");
        }
    }
}
