package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class RacingGameController {
    public void run() {
        String carNames = inputCarNames();

        Cars cars = new Cars();

        List<String> names = Arrays.stream(splitInput(carNames)).toList();

        cars.registerAll(names);

        System.out.println(cars);

        String inputTryCount = inputTryCount();

        TryCountDto tryCountDto = new TryCountDto(inputTryCount);

        int count = Integer.parseInt(tryCountDto.input());

        TryCount tryCount = TryCount.from(count);

        System.out.println(tryCount);

        RacingGame racingGame = new RacingGame(cars, tryCount);
        racingGame.play();
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = readLine();
        return inputCarNames;
    }

    public String inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputTryCount = readLine();
        return inputTryCount;
    }

    public String[] splitInput(String input) {
        return input.split(",",-1);
    }

}
