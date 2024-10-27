package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;


public class RaceGame {

    List<Car> carList = new ArrayList<>();

    void start() {
        inputCarNames();
    }

    @Test
    @DisplayName("자동차 이름을 입력하는 메서드")
    void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputText = Console.readLine();
        String[] carNames = inputText.split(",");
        for(String carName : carNames) {
            // 자동차 이름이 비어있거나, 이름이 5자를 초과할 경우 예외 처리
            if(carName.isEmpty() || carName.length() > 5) {
                throw new RuntimeException();
            }
            carList.add(new Car(carName));
        }
    }

}