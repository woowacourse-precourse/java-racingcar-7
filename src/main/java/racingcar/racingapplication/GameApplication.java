package racingcar.racingapplication;

import java.util.List;
import racingcar.NameSeparator;
import racingcar.Printer;
import racingcar.Reader;
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
        List<String> carNames = nameSeparator.separatingNames(origin);

        printer.print("시도할 횟수는 몇 회인가요?");
        int gameNumber = reader.readGameNumber();

        List<Cars> afterRaceCars = RacingApplication.race(gameNumber,
            Cars.makeOriginCars(carNames));
        Result result = Result.of(afterRaceCars);
        List<String> winners = result.findWinners();
        printer.printAfterGameResult(result.finalResultCars());
        printer.printFinalWinner(winners);
    }
}
