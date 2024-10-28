package racingcar;

public class RaceRunner {

    public void run() {
        try {
            String[] carNames = InputView.inputCar();
            int attemptCount = InputView.inputCount();

            String finalMovements = MoveDecider.move(carNames, attemptCount);
            RaceWinner.findWinner(finalMovements);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}


