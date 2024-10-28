package racingcar.io;

import racingcar.Car;
import racingcar.ParticipatingCars;

import java.util.List;

public class ProgramOutput {
    private static final String REQUEST_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_INFORMATION_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_INFORMATION_MESSAGE = "최종 우승자 : ";
    private static final String COLON = " : ";

    public void requestCarsName() {
        System.out.println(REQUEST_CARS_NAME_MESSAGE);
    }

    public void requestAttemptCount() {
        System.out.println(REQUEST_ATTEMPT_COUNT_MESSAGE);
    }

    public void printAttemptResult(ParticipatingCars cars, int tryCount) {
        System.out.println(EXECUTION_RESULT_INFORMATION_MESSAGE);
        racingAttempt(cars,tryCount);
    }

    private void racingAttempt(ParticipatingCars cars, int tryCount) {
        for (int currentTry = 0; currentTry < tryCount; currentTry++) {
            List<Car> racingCars = cars.racing();
            printCarResult(racingCars);
            printNewLine();
        }
    }

    public void printWinner(ParticipatingCars cars) {
        String winnerInfo = getWinnerInfo(cars);
        outputWinnerInfo(winnerInfo);
    }

    private void printCarResult(List<Car> racingCars) {
        for (Car result : racingCars) {
            System.out.print(result.getName() + COLON + result.getPositionSign().toString());
            printNewLine();
        }
    }

    private void printNewLine() {
        System.out.println();
    }

    private String getWinnerInfo(ParticipatingCars cars) {
        List<String> winnerName = cars.getWinner();
        return String.join(", ", winnerName);
    }

    private void outputWinnerInfo(String winnerInfo) {
        System.out.println(FINAL_WINNER_INFORMATION_MESSAGE + winnerInfo);
    }
}
