package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.validation.InputValidator;
import racingcar.domain.acceleration.RandomAcceleration;
import racingcar.domain.race.Race;
import racingcar.domain.race.service.RaceService;

public class Application {

    private final static InputValidator inputValidator = new InputValidator();
    private final static RaceService raceService = new RaceService();

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        inputValidator.validateCarNames(carNames);

        System.out.println("시도할 회수는 몇 회인가요?");
        int rounds = Integer.parseInt(Console.readLine());

        Race race = Race.of(carNames, new RandomAcceleration());

        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            race.lap();
            System.out.println(race.getResult());
            System.out.println();
        }

        System.out.println(String.format("최종 우승자 : %s", raceService.findWinners(race).stream()
            .map(car -> car.getName())
            .reduce((a, b) -> a + ", " + b)
            .orElse("")));

    }
}
