package racingcar.validation;

import racingcar.exception.CustomException;
import racingcar.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    /**
     * 자동차 이름이 5글자를 초과한지 검증하는 메서드
     * @param car 자동차 이름
     */
    public static void checkNameLength(String car){
        if(car.length() > 5){
            throw new CustomException(ErrorMessage.INVALID_NAME_LENGTH);
        }
    }

    /**
     * 자동차 이름이 비어 있는지 검증하는 메서드
     * @param car 자동차 이름
     */
    public static void checkNameNull(String car){
        if(car.isBlank()){
            throw new CustomException(ErrorMessage.INVALID_NAME_INPUT);
        }
    }

    /**
     * 입력 받은 문자열 숫자를 int형으로 변환해주고 변환된 숫자가 양수인지와 숫자가 맞는지 검증 해주는 메서드
     * @param number 시도 횟수
     * @return 시도 횟수
     */
    public static int checkIfNumber(String number){
        try{
            int count = Integer.parseInt(number);

            if(count <= 0 ){
                throw new CustomException(ErrorMessage.NEGATIVE_NUMBER);
            }

            return count;
        } catch (NumberFormatException e){
            throw new CustomException(ErrorMessage.INVALID_NUMBER);
        }
    }

    /**
     * 자동차 이름이 중복 되는지 검증하는 메서드
     * @param carNames 자동차 이름들
     */
    public static void checkDuplicateNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new CustomException(ErrorMessage.DUPLICATE_NAME);
        }
    }

}
