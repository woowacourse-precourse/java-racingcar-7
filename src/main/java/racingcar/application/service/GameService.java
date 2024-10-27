package racingcar.application.service;

import racingcar.infrastructure.constant.Boundary;
import racingcar.application.dto.RacingGameRequest;
import racingcar.application.port.inbound.GameUseCase;
import racingcar.application.port.outbound.OutputPort;
import racingcar.infrastructure.exception.InvalidNumberFormatException;
import racingcar.infrastructure.exception.NegativeNumberException;
import racingcar.domain.service.CarRacingManager;
import racingcar.infrastructure.exception.OutOfBoundNumberException;

public class GameService implements GameUseCase {
    private final OutputPort outputPort;
    private CarRacingManager carRacingManager;

    public GameService(OutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public void execute(RacingGameRequest request) {
        carRacingManager = CarRacingManager.from(request.cars());

        validateRepeatNumber(request.repeat());
        final int count = Integer.parseInt(request.repeat());

        writeStart();
        for (int turn = 0; turn < count; turn++) {
            carRacingManager.moveAllCar();
            writeAllCar();
        }
        writeResult();
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

    private void validateRepeatNumber(String input) {
        try {
            final int repeat = Integer.parseInt(input);
            if (repeat < 1) {
                throw new NegativeNumberException();
            }
            if (repeat > Boundary.REPEAT_MAX) {
                throw new OutOfBoundNumberException();
            }
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException();
        }
    }
}
