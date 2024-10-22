package racingcar.racingapplication;

import java.util.List;
import racingcar.NameSeparator;
import racingcar.Printer;
import racingcar.Reader;
import racingcar.configuration.AppConfig;
import racingcar.domain.Cars;

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
        Cars cars = Cars.makeOriginCars(carNames);
        printer.print("시도할 횟수는 몇 회인가요?");
        int gameNumber = reader.readGameNumber();
        List<Cars> afterGameResult = runEachGame(List.of(cars), gameNumber);
        printer.printAfterGameResult(afterGameResult);
    }

    public List<Cars> runEachGame(List<Cars> cars, int gameNumber) {
        for (int i = 0; i < gameNumber; i++) {
            Cars nowCars = cars.getLast();
            Cars nextCars = nowCars.eachGame();
            cars.add(nextCars);
        }
        return cars;
    }
}
