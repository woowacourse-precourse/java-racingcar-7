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
        RacingCarConsoleWriter.writeInputMessage(RacingCarConsoleWriter.InputType.READ_CAR_NAMES);
        String input = ConsoleReader.readInput();
        List<Car> cars = carFactory.createCarsFromInput(input);

        RacingCarConsoleWriter.writeInputMessage(RacingCarConsoleWriter.InputType.READ_TRY_COUNT);
        String roundCountInput = ConsoleReader.readInput();
        int roundCount;
        try {
            roundCount = Integer.parseInt(roundCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        if(roundCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }


        List<String> topCarNames = playGame(cars, roundCount, moveCondition);

        RacingCarConsoleWriter.writeWinnerMessage(topCarNames);
    }


    private List<String> playGame(List<Car> cars, int roundCount, MoveCondition moveCondition) {
        CarGame carGame = new CarGame(moveCondition, roundCount, cars);

        RacingCarConsoleWriter.writeRoundStartMessage();
        while (carGame.canPlay()) {
            carGame.playOneRound();
            List<RacingCarState> currentRacingCarStates = carGame.getCurrentRacingCarStates();
            RacingCarConsoleWriter.writeCarState(currentRacingCarStates);
        }

        return carGame.getTopCarNames();
    }


}
