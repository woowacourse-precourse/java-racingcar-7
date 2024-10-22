package racingcar.racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarValidator {
    private static final RacingCarValidator RACING_CAR_VALIDATOR = new RacingCarValidator();
    private static final String MORE_THAN_ONE = "한 대 이상의 자동차 이름이 필요합니다.";
    private static final String OVER_MAX_LENGTH = "한 대 이상의 자동차 이름이 최대 길이를 초과했습니다.";
    private static final String EXIST_SAME_NAME = "동일한 이름을 가진 자동차가 존재합니다.";
    private static final String IS_NOT_NUMBER = "정수 입력이 잘못 되었습니다.";
    private static final String PUT_OVER_ZERO = "시도 횟수는 0회 이상이 입력 되어야 합니다.";

    private RacingCarValidator(){

    }

    public static RacingCarValidator getInstance() {
        return RACING_CAR_VALIDATOR;
    }
    // isExist 로 하려다가 이름이 뭔가 boolean 으로 반환 해야 할 것 같기도 하고,
    // boolean 으로 반환 해봤자 false가 갈 일이 없기도 하고,
    // 아래에 있는 메서드들이랑 일관성이 없기도 해서 이렇게 함.
    public void existCheck(String joinedCarNames) {
        if(joinedCarNames.isBlank())
            throw new IllegalArgumentException(MORE_THAN_ONE);
    }

    public void lengthCheck(List<String> carNames, int maxLength){
        for(String name:carNames){
            if(name.length()>maxLength)
                throw new IllegalArgumentException(OVER_MAX_LENGTH);
        }
    }
    public void sameNameCheck(List<String> carNames){
        Set<String> nameSet = new HashSet<>(carNames);
        if(nameSet.size()!= carNames.size())
            throw new IllegalArgumentException(EXIST_SAME_NAME);
    }

    public void numberCheck(String number){
        for(char c:number.toCharArray()){
            if(!Character.isDigit(c))
                throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }

    public void validTryTimeCheck(int tryTimes){
        if(tryTimes <= 0)
            throw new IllegalArgumentException(PUT_OVER_ZERO);
    }
}
