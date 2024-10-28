package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map.Entry;


public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String stringInput = Console.readLine();
        List<String> carNames = Validator.checkInputCarNames(stringInput);

        System.out.println("시도 할 횟수 몇 회인가요?");
        String numInput = Console.readLine();
        Integer round = Validator.checkInputRound(numInput);

        RacingCar racingCar = new RacingCar(carNames, round);

        racingCar.race();
    }
}
