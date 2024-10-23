package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;

public class InputMessage {
    private static final Pattern INVALID_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputNumberOfTries(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public String[] splitCarName(String inputCarName){
        String[] carNames = inputCarName.split(",");
        validateInput(carNames);

        return carNames;
    }
    
    public void validateInput(String[] carNames){
        int carNameLimits = Constants.CAR_NAME_LIMITS;
        
        for (String carName : carNames) {
            // 자동차 이름이 5자 초과 시 예외 발생
            if (carName.trim().length() > carNameLimits) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + carName);
            }
            
            // 자동차 이름이 문자, 숫자 이외의 것들이 들어갈 시 예외 발생
            if (INVALID_PATTERN.matcher(carName.trim()).find()) {
                throw new IllegalArgumentException("자동차 이름은 영대소문자와 숫자 밖에 안 됩니다.");
            }
        }
    }
}
