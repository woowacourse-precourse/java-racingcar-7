package racingcar;

import java.util.List;
import racingcar.io.page.IntegerReaderPage;
import racingcar.io.page.ReaderPage;
import racingcar.io.page.SimpleTextReaderPage;
import racingcar.parser.CarNamesParser;
import racingcar.parser.Parser;
import racingcar.race.Car;
import racingcar.race.Race;
import racingcar.race.Vehicle;

public class Application {
    public static void main(String[] args) {
        // 1. 자동차 이름 입력
        String carNamesString = inputCarNames();

        // 2. 라운드 횟수 입력
        int round = inputRound();

        // 3. 자동차 이름 ',' 기준으로 구분한 리스트 변환
        List<String> carNames = parseCarNames(carNamesString);

        // 4. 자동차 이름 리스트를 Vehicle 타입 컬렉션으로 변환
        List<? extends Vehicle> vehicles = mapToVehicles(carNames);

        // 5. 자동차 경주 시작
        startRace(vehicles, round);
    }

    private static String inputCarNames() {
        ReaderPage<String, String> page = new SimpleTextReaderPage();
        page.setContent("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        page.isNewLineAtEOF(true);
        page.render();
        return page.getOutput();
    }

    private static Integer inputRound() {
        ReaderPage<String, Integer> page = new IntegerReaderPage();
        page.setContent("시도할 횟수는 몇 회인가요?");
        page.isNewLineAtEOF(true);
        page.render();
        return page.getOutput();
    }

    private static List<String> parseCarNames(String input) {
        Parser<String, List<String>> parser = new CarNamesParser();
        return parser.parse(input);
    }

    private static List<? extends Vehicle> mapToVehicles(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    private static void startRace(List<? extends Vehicle> vehicles, int round) {
        Race race = new Race(vehicles, round);
        race.start();
    }
}
