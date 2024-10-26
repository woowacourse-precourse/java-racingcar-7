package racingcar;

import java.util.ArrayList;
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
        String carNamesString = inputCarNames();

        int round = inputRound();

        List<String> carNames = parseCarNames(carNamesString);

        List<Vehicle> vehicles = mapToVehicles(carNames);

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

    private static List<Vehicle> mapToVehicles(List<String> carNames) {
        List<Vehicle> vehicles = new ArrayList<>();
        carNames.forEach((it) -> vehicles.add(new Car(it)));
        return vehicles;
    }

    private static void startRace(List<Vehicle> vehicles, int round) {
        Race race = new Race(vehicles, round);
        race.start();
    }
}
