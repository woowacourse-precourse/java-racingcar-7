package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String NEXT_LINE = "\n";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String COLON_SIGN = " : ";
    private static final String DISTANCE_SIGN = "-";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String COMMA_SIGN = ", ";

    public void printRequestCarNames(){
        System.out.println(INPUT_CAR_NAMES);
    }

    public void printRequestTryCount(){
        System.out.println(INPUT_TRY_COUNT);
    }

    public void printExecutionResult(){
        System.out.println(NEXT_LINE + EXECUTION_RESULT);
    }

    public void printRoundByExecutionResults(final RacingCars racingCars){
        StringBuilder resultByRound = new StringBuilder();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            resultByRound
                    .append(racingCar.getRacingCarName())
                    .append(COLON_SIGN)
                    .append(DISTANCE_SIGN.repeat(racingCar.getLocation()))
                    .append(NEXT_LINE);
        }
        System.out.println(resultByRound);
    }

    public void printRacingCarWinnerResult(final RacingCars racingCars){
        List<String> winners = racingCars.findRacingWinners();
        StringBuilder winnerRacingCars = new StringBuilder();
        winnerRacingCars
                .append(FINAL_WINNER)
                .append(COLON_SIGN);
        for (int i = 0; i < winners.size(); i++) {
            winnerRacingCars.append(winners.get(i));
            if (isJointWinner(i, winners)){
                winnerRacingCars.append(COMMA_SIGN);
            }
        }
        System.out.println(winnerRacingCars);
    }
    private boolean isJointWinner(int idx, List<String> winners) {
        return idx < (winners.size() - 1);
    }
}
