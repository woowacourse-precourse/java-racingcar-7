package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final int MAX_TRY_COUNT = 100000000;

    public List<String> getInputCars(){
        String input = Console.readLine();
        return validateCarNames(input);
    }

    public int getInputCount(){
        try {
            String input = Console.readLine();

            // 실수 여부를 확인하기 위해 float 과 int 비교
            float floatTryCount = Float.parseFloat(input);
            int intTryCount = (int)floatTryCount;
            if(intTryCount != floatTryCount){
                throw new IllegalArgumentException("입력된 횟수가 실수입니다.");
            }
            if(intTryCount <= 0){
                throw new IllegalArgumentException("입력된 횟수가 0 이하 입니다.");
            }
            if (intTryCount > MAX_TRY_COUNT) {
                throw new IllegalArgumentException("입력된 횟수가 비현실적으로 큽니다.");
            }
            return intTryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수가 숫자 형식이 아닙니다.");
        }
    }

    public static List<String> validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비어 있을 수 없습니다.");
        }

        List<String> carNames = Arrays.stream(input.split(",")).toList();
        if(carNames.size() <= 1) {
            throw new IllegalArgumentException("자동차 이름을 두 개 이상 입력해야 합니다.");
        }

        return carNames;
    }
}
