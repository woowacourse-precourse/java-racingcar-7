package racingcar;

import com.sun.jdi.ArrayReference;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 자동차 입력 받고 쉼표 기준으로 나누기
        String inputCarNames = Console.readLine();
        String[] carNamesList = inputCarNames.split(",");

        for (String carName : carNamesList) {
            // 나눌 때 앞뒤로 있을 수 있는 공백 제거
            carName = carName.trim();
            // 공백이 있다면 예외 발생
            if (carName == null || carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 공백입니다.");
            } else if (carName.length() >= 6) {
                throw new IllegalArgumentException("자동차 이름이 6글자 이상입니다.");
            }
        }

    }
}
