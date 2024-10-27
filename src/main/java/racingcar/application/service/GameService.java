package racingcar.application.service;

import racingcar.application.constant.MoveConditionBoundary;
import racingcar.application.constant.RandomNumberBoundary;
import racingcar.application.port.inbound.GameUseCase;
import racingcar.application.port.inbound.InputPort;
import racingcar.application.port.outbound.OutputPort;
import racingcar.infrastructure.exception.EmptyInputException;
import racingcar.infrastructure.exception.NegativeNumberException;
import racingcar.domain.service.CarRacingManager;
import racingcar.domain.util.RandomNumberGenerator;

import java.util.List;

public class GameService implements GameUseCase {
    private final InputPort inputPort;
    private final OutputPort outputPort;
    private final RandomNumberGenerator randomNumberGenerator;
    private CarRacingManager carRacingManager;

    public GameService(InputPort inputPort, OutputPort outputPort) {
        this.inputPort = inputPort;
        this.outputPort = outputPort;
        this.randomNumberGenerator = new RandomNumberGenerator(RandomNumberBoundary.MIN, RandomNumberBoundary.MAX);
    }

    @Override
    public void execute() {
        final String carInput = readCarInput();
        validateCarInput(carInput);
        final String repeat = readRepeatInput();
        validateRepeatNumber(repeat);

        carRacingManager = CarRacingManager.from(carInput);
        final int count = Integer.parseInt(repeat);

        writeStart();
        for (int turn = 0; turn < count; turn++) {
            moveAllCar();
            writeAllCar();
        }
        writeResult();
    }

    private String readCarInput() {
        outputPort.writeMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return inputPort.get();
    }

    private String readRepeatInput() {
        outputPort.writeMessage("시도할 횟수는 몇 회인가요?");
        return inputPort.get();
    }

    private void writeStart() {
        outputPort.writeMessage("\n실행 결과");
    }

    private void writeResult() {
        final String winners = carRacingManager.getWinners();
        outputPort.writeMessage(String.format("최종 우승자 : %s", winners));
    }

    private void writeAllCar() {
        final StringBuilder stringBuilder = new StringBuilder();

        carRacingManager.getList().forEach(car -> {
            stringBuilder.append(car.toString());
        });
        stringBuilder.append('\n');

        outputPort.writeMessage(stringBuilder.toString());
    }

    private void validateCarInput(String input) {
        if (input.trim().isEmpty()) {
            throw new EmptyInputException();
        }
    }

    private void validateRepeatNumber(String input) {
        try {
            final int repeat = Integer.parseInt(input);
            if (repeat < 1) {
                throw new NegativeNumberException();
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private void moveAllCar() {
        List<String> names = carRacingManager.getNames();
        names.forEach(name -> {
            if (canMove(randomNumberGenerator.pick())) {
                moveCar(name);
            }
        });
    }

    private boolean canMove(final int num) {
        return num >= MoveConditionBoundary.MORE_THAN_EQUAL;
    }

    private void moveCar(final String name) {
        carRacingManager.moveForward(name);
    }
}
