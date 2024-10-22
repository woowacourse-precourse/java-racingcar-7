package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;

public class InputMessage {
    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String[] splitCarName(String inputCarName){
        String[] carNames = inputCarName.split(",");
        carNameMoreThan5CharactersException(carNames);

        return carNames;
    }

    @DisplayName("자동차 이름이 5자 초과 시 예외 발생")
    public void carNameMoreThan5CharactersException(String[] carNames){
        int carNameLimits = Constants.CAR_NAME_LIMITS;

        for (String carName : carNames) {
            if (carName.trim().length() > carNameLimits) {  // trim()은 앞뒤 공백 제거
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + carName);
            }
        }
    }
}
