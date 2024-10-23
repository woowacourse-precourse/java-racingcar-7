package racingcar.racingapplication;

import java.util.List;
import racingcar.RandomNumberGenerator;
import racingcar.configuration.AppConfig;
import racingcar.domain.Cars;
import racingcar.domain.Result;

public class GameApplication {

    private final NameSeparator nameSeparator;
    private final Reader reader;
    private final Printer printer;

    public GameApplication(AppConfig appConfig) {
        this.nameSeparator = appConfig.nameSeparator();
        this.reader = appConfig.reader();
        this.printer = appConfig.printer();
    }

    public void run() {
        printer.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String origin = reader.readOrigin();
        List<String> carNames = nameSeparator.separateNames(origin);

        printer.print("시도할 횟수는 몇 회인가요?");
        int gameNumber = reader.readGameNumber();

        RacingApplication racingApplication = new RacingApplication(new RandomNumberGenerator());
        List<Cars> afterRaceCars = racingApplication.race(gameNumber, Cars.makeOriginCars(carNames));
        Result result = Result.of(afterRaceCars.subList(1, afterRaceCars.size()));
        List<String> winners = result.findWinners();
        printer.printAfterGameResult(result.finalResultCars());
        printer.printFinalWinner(winners);
    }
}
