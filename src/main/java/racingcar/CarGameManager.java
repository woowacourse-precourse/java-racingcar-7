package racingcar;

import java.util.List;

public class CarGameManager {
    private final CarFactory carFactory;
    private final MoveCondition moveCondition;

    public CarGameManager(CarFactory carFactory, MoveCondition moveCondition) {
        this.carFactory = carFactory;
        this.moveCondition = moveCondition;
    }

    public void startGame() {
        String input = readCarInput();
        List<Car> cars = carFactory.createCarsFromInput(input);

        int roundCount = readRoundCount();

        playGame(cars, roundCount, moveCondition);
    }

    private String readCarInput() {
        RacingCarConsoleWriter.writeInputMessage(RacingCarConsoleWriter.InputType.READ_CAR_NAMES);
        return ConsoleReader.readInput();
    }

    /**
     * 시도 횟수를 입력받는다.
     * 양의 정수가 아닌 경우 예외를 발생시킨다.
     */
    private int readRoundCount() {
        RacingCarConsoleWriter.writeInputMessage(RacingCarConsoleWriter.InputType.READ_TRY_COUNT);
        String roundCountInput = ConsoleReader.readInput();
        int roundCount;
        try {
            roundCount = Integer.parseInt(roundCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        if (roundCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return roundCount;
    }


    /**
     * `CarGame`을 생성하고, 게임을 진행한다.
     * 게임 진행 내역을 매 라운드마다 출력하고, 게임이 끝나면 우승자를 출력한다.
     */
    private void playGame(List<Car> cars, int roundCount, MoveCondition moveCondition) {
        CarGame carGame = new CarGame(moveCondition, roundCount, cars);

        RacingCarConsoleWriter.writeRoundStartMessage();
        while (carGame.canPlay()) {
            carGame.playOneRound();
            List<RacingCarState> currentRacingCarStates = carGame.getCurrentRacingCarStates();
            RacingCarConsoleWriter.writeCarState(currentRacingCarStates);
        }

        List<String> topCarNames = carGame.getTopCarNames();
        RacingCarConsoleWriter.writeWinnerMessage(topCarNames);
    }


}
