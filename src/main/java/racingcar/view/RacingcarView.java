package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.entity.Car;
public class RacingcarView {

    public String carNameInput() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            return Console.readLine().trim();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public String trialCountInput() {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            return Console.readLine().trim();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void printResult(List<Car> result) {
        for (Car car : result) {
            System.out.println(car);
        }
        System.out.println();
    }
}
