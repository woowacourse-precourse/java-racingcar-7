package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarMoveCountDto;
import racingcar.dto.CarMoveHistoryDto;
import racingcar.exception.RaceException;
import racingcar.utility.StringUtility;

public class Car {

    private final static int MIN_RANDOM_NUMBER = 0;
    private final static int MAX_NAME_LEN = 5;
    private final static int MAX_RANDOM_NUMBER = 9;
    private final static int CAN_MOVE_RANDOM_NUMBER = 4;
    private final static String INVALID_CAR_NAME_MESSAGE = "유효하지 않은 자동차 이름입니다. (특수문자 사용불가, 5글자 이하)";
    private final static String MOVE_INDICATOR = "-";

    private final String name;
    private final StringBuilder currentMoveStringBuilder = new StringBuilder();
    private int moveCount;

    public Car(String name) {
        if(!isNameValid(name)){
            throw new RaceException(INVALID_CAR_NAME_MESSAGE);
        }
        this.name = name;
        this.moveCount = 0;
    }

    private boolean isNameValid(String name) {
        if(StringUtility.containsSpecialCharacter(name)){
            return false;
        }
        if(name.isEmpty()){
            return false;
        }
        if(name.length() > MAX_NAME_LEN){
            return false;
        }
        return true;
    }

    private boolean isCanMove(){
        int randomNum = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER,MAX_RANDOM_NUMBER);
        if(randomNum >= CAN_MOVE_RANDOM_NUMBER) {
            return true;
        }
        return false;
    }

    public void move(){
        if(isCanMove()){
            this.moveCount++;
            addMoveHistory();
        }
    }

    private void addMoveHistory() {
        currentMoveStringBuilder.append(MOVE_INDICATOR);
    }

    public CarMoveHistoryDto toMoveHistoryDto(){
        return new CarMoveHistoryDto(name,currentMoveStringBuilder.toString());
    }

    public CarMoveCountDto toMoveCountDto(){
        return new CarMoveCountDto(name,moveCount);
    }
}
