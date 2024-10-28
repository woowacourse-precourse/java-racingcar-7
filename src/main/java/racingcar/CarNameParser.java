package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class CarNameParser {
    private static final String DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public String inputCarNames(){
        return Console.readLine();
    }

    public String[] splitCarNamesByComma(String carNames){
        return carNames.split(DELIMITER);
    }

    public void validateCarName(String carName){
        if(carName.isEmpty()){
            throw new IllegalArgumentException("자동차 이름이 빈 문자열 입니다.");
        }

        if(carName.length() > MAX_CAR_NAME_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void hasDuplicateCarNames(List<String> carNames){
        Set<String> carNamesSet = new HashSet<>(carNames);
        if(carNamesSet.size() != carNames.size()){
            throw new IllegalArgumentException("중복되는 이름이 있습니다.");
        }
    }

    public List<String> getValidatedCarNames(String[] splitCarNames) {
        // 자동차 이름 유효성 검증
        List<String> validatedCarNames = Arrays.stream(splitCarNames)
                .peek(this::validateCarName)
                .toList();
        // 중복 검증
        hasDuplicateCarNames(validatedCarNames);

        return validatedCarNames;
    }
}
