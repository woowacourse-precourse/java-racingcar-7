package racingcar.view;

import java.util.LinkedHashMap;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    //자동차 이름을 입력 받는 메소드
    public Map<String, Integer> readCarsName() {

        Map<String, Integer> cars = new LinkedHashMap<>();

        System.out.println(READ_CAR_NAME_MESSAGE);
        String buffer = Console.readLine();
        validateInput(buffer);

        String[] carNames = buffer.split(",");

        for (String carName : carNames) {
            cars.put(carName, 0);
        }

        return cars;
    }

    //공백 입력인지 확인하는 메소드
    private void validateInput(String buffer) {
        if (buffer == null || buffer.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다");
        }
    }
}
