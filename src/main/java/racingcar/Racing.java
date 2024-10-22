package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Racing {
    public void race() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        List<String> carNames = List.of(carNameInput.split(","));

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = Console.readLine();
        int number = Integer.parseInt(numberInput);

        Console.close();
    }
}
