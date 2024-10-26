package racingcar.adapter.in.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.application.in.RacingCarUseCase;
import racingcar.config.context.annotation.Handler;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.exception.InvalidCarInputException;
import racingcar.domain.exception.InvalidTryCountInput;

@Handler
public class ConsoleHandler {

    private final RacingCarUseCase racingCarUseCase;

    public ConsoleHandler(RacingCarUseCase racingCarUseCase) {
        this.racingCarUseCase = racingCarUseCase;
    }

    public void startRacing() {
        List<Car> cars = readCarsFromConsole();
        int tryCount = readTryCountFromConsole();

        Racing racingResult = racingCarUseCase.startRacing(cars, tryCount);
        printWinners(racingResult);
    }

    private List<Car> readCarsFromConsole() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            String line = Console.readLine();

            List<Car> cars = Arrays.stream(line.split(","))
                    .map(String::trim)
                    .map(Car::of)
                    .collect(Collectors.toList());
            if (cars.isEmpty()) {
                throw new InvalidCarInputException();
            }

            return cars;
        } catch (NoSuchElementException e) {
            throw new InvalidCarInputException();
        }
    }

    private int readTryCountFromConsole() throws IllegalArgumentException {
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            String line = Console.readLine();

            return Integer.parseInt(line.trim());
        } catch (NoSuchElementException | NumberFormatException e) {
            throw new InvalidTryCountInput();
        }
    }

    private void printWinners(Racing racingResult) {
        System.out.println();

        System.out.println("실행 결과");
        racingResult.printHistory();

        System.out.println();

        String winners = racingResult.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winners);
    }
}
