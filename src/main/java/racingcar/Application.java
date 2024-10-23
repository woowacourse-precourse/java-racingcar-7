package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 이름입력 기능
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        // 이름 판단
        List<String> carNameList = Validate.carName(inputCarName);
        System.out.println(carNameList);
    }
}
