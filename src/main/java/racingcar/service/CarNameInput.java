package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class CarNameInput implements CarManager{

    public List<String> carNameInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 "+SEPARATOR_NAME+"("+SEPARATOR+") 기준으로 구분)");
        String carNames = Console.readLine();
        List<String> carNameList = carNamesSplit(carNames);

        return carNameList;
    }

    private List<String> carNamesSplit(String carNames) {
        validateCarNameEmpty(carNames);
        validateCarNameFormat(carNames);
    }

    private void validateCarNameEmpty(String carNames) {
        if(carNames == null || carNames.isEmpty())
            throw new IllegalArgumentException("error: 입력받은 문자열이 빈문자열 또는 null입니다");
    }

    private void validateCarNameFormat(String carNames) {
        if(!carNames.matches(VALID_INPUT_PATTERN))
            throw new IllegalArgumentException("error: 입력받은 문자열의 형식이 불일치합니다");
    }
}
