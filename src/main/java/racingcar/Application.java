package racingcar;

import racingcar.domain.Car;
import racingcar.domain.CarGenerator;
import racingcar.input.InputProvider;
import racingcar.message.CarRaceMessage;
import racingcar.move.*;
import racingcar.parser.CarNameParser;
import racingcar.parser.ParserConfig;
import racingcar.parser.Parser;
import racingcar.printer.BufferedCarRacePrinter;
import racingcar.printer.Printer;
import racingcar.receiver.CarNameInputReceiver;
import racingcar.receiver.InputReceiver;
import racingcar.receiver.RoundInputReceiver;
import racingcar.input.ConsoleInputProvider;
import racingcar.service.CarRaceService;

import java.io.OutputStreamWriter;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Input Provider 설정
        InputProvider inputProvider = new ConsoleInputProvider();

        // Car Name 입력 수신기 의존성 주입 및 입력값 받기
        InputReceiver<String> carNameInputReceiver = new CarNameInputReceiver(inputProvider);
        String carNames = carNameInputReceiver.receiveWithMessage(CarRaceMessage.REQUEST_CAR_NAME);

        // 입력 파싱
        Parser parser = new CarNameParser(ParserConfig.DEFAULT);
        String[] parseCarNames = parser.parse(carNames);

        // Car 생성
        CarGenerator carGenerator = new CarGenerator(parseCarNames, 100);
        List<Car> cars = carGenerator.generate();

        // Round 입력 수신기 의존성 주입 및 입력값 받기
        InputReceiver<Integer> roundInputReceiver = new RoundInputReceiver(inputProvider, 10000);
        int round = roundInputReceiver.receiveWithMessage(CarRaceMessage.REQUEST_LAPS);

        // Move Generator 설정
        RandomNumberGenerator randomNumberGenerator = new MissionRandomNumberGenerator();
        MoveGenerator moveGenerator = new CarRaceMoveGenerator(CarRaceMoveConfig.DEFAULT, randomNumberGenerator);

        // Printer 생성 및 의존성 주입
        Printer printer = new BufferedCarRacePrinter(new OutputStreamWriter(System.out));

        // CarRaceService 의존성 주입 및 실행
        CarRaceService carRaceService = new CarRaceService(cars, round, moveGenerator, printer);
        carRaceService.startRace();
    }
}
