package racingcar;

import java.util.HashSet;
import java.util.List;

public class ErrorVerificationService {
    RacingCarService racingCarService = new RacingCarService();

    public void checkInputValidity(String carList, String count){
        emptyOrNull(carList);
        hasWhitespaceInCarName(carList);
        hasDelimiter(carList);
        carNameLengthOver(carList);
        checkCarNameDuplicate(carList);
        checkDelimiterDuplicate(carList);
        countNumberCheck(count);
            }

    private void emptyOrNull(String input) {
        if (input == null || input.isEmpty()){
            throw new IllegalArgumentException("공백입력 오류입니다.");
        }
    }

    private void hasWhitespaceInCarName(String input) {
        List<String> carNameList = racingCarService.getCarNameList(input);
        for (String s : carNameList){
            hasWhitespaceInCarNameCheck(s);
        }
    }

    private void hasWhitespaceInCarNameCheck(String input){
        if (input.contains(" ")){
            throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다");
        }
    }

    private void hasDelimiter(String input) {
        if (!input.contains(",")){
            throw new IllegalArgumentException("경주에는 두 대 이상의 자동차가 필요합니다");
        }
    }

    private void carNameLengthOver(String input) {
        List<String> carNameList = racingCarService.getCarNameList(input);
        boolean check = carNameList.stream().allMatch(name -> name.length() < 6);
        if (!check){
            throw new IllegalArgumentException("자동차 이름은 5글자 이하로 작성해야합니다");
        }
    }

    private void checkCarNameDuplicate(String input) {
        List<String> carNameList = racingCarService.getCarNameList(input);

        HashSet<String> carNameSet = new HashSet<>(carNameList);

        if (carNameList.size() != carNameSet.size()){
            throw new IllegalArgumentException("자동차 이름은 중복되게 지어서는 안됩니다.");
        }
    }
    private void checkDelimiterDuplicate(String input) {
        List<String> carNameList = racingCarService.getCarNameList(input);
        if (carNameList.stream().anyMatch(String::isBlank)){
            throw new IllegalArgumentException("구분자 중복 사용하여 자동차 이름이 공백이 되었습니다.");
        }
    }

    private void countNumberCheck(String input){
        for (int i = 0; i < input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("숫자만 입력가능합니다.");
            }
        }
    }

}
