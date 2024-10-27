package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class CarNameParser {
    private static final String DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    /**
     * 자동차 이름을 입력받는 메서드
     *
     * @return 사용자가 입력한 자동차 이름 문자열
     * */
    public String inputCarNames(){
        return Console.readLine();
    }

    /**
     * 자동차 이름을 쉼표를 기준으로 구분하고 배열로 반환하는 메서드
     *
     * @param carNames 사용자가 입력한 자동차 이름 문자열
     * @return 쉼표를 기준으로 분리한 자동차 이름 배열
     */
    public String[] splitCarNamesByComma(String carNames){
        return carNames.split(DELIMITER);
    }

    /**
     * 자동차 이름의 유효성을 검증하는 메서드
     *
     * @param carName: 유효성 검증할 자동차 이름
     * @throws IllegalStateException 자동차 이름이 빈 문자열 인 경우
     * @throws IllegalStateException 자동차 이름이 5자를 초과할 경우
     * */
    public void validateCarName(String carName){
        if(carName.isEmpty()){
            throw new IllegalArgumentException("자동차 이름이 빈 문자열 입니다.");
        }

        if(carName.length() > MAX_CAR_NAME_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    /**
     * 중복되는 자동차 이름이 있는지 확인하는 메서드
     * */
    public void hasDuplicateCarNames(List<String> carNames){
        Set<String> carNamesSet = new HashSet<>(carNames);
        if(carNamesSet.size() != carNames.size()){
            throw new IllegalArgumentException("중복되는 이름이 있습니다.");
        }
    }

    /**
     * 자동차 이름 배열을 검증하고 리스트로 반환하는 메서드
     *  -자동차 이름 유효성 검증과 중복 검증 후 리스트 반환
     * @param splitCarNames 쉼표 기준으로 분리한 문자열 배열
     * @return 유효성이 검증된 자동차 이름 리스트
     * */
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
