package racingcar.view;

import racingcar.model.Car;
import racingcar.view.dto.RaceResult;

import java.util.List;

public class OutputView {
    private static final String NOTICE_STATEMENT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NOTICE_STATEMENT_CNT = "시도할 횟수는 몇 회인가요?";
    private static final String NOTICE_STATEMENT_RESULTS = "실행 결과";
    private static final String NOTICE_STATEMENT_WINNER = "최종 우승자";

    public void printNoticeStatementName() {
        System.out.println(NOTICE_STATEMENT_NAME);
    }

    public void printNoticeStatementCnt() {
        System.out.println(NOTICE_STATEMENT_CNT);
    }

    public void printRaceResults(List<RaceResult> raceResults) {
        System.out.println(NOTICE_STATEMENT_RESULTS);

        for (RaceResult raceResult : raceResults) {
            printRaceResult(raceResult);
        }
    }

    private void printRaceResult(RaceResult raceResult) {
        List<Car> cars = raceResult.getCars();

        for (Car car : cars) {
            final String line = getPositionDisplay(car);

            System.out.println(line);
        }

        System.out.println();
    }

    private String getPositionDisplay(Car car) {
        StringBuilder display = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            display.append("-");
        }
        return display.toString();
    }

    public void printWinner(List<String> names) {
        String line = getWinnerDisplay(names);
        System.out.println(line);
    }

    private String getWinnerDisplay(List<String> names) {
        StringBuilder display = new StringBuilder(NOTICE_STATEMENT_WINNER + " :");

        for (int i = 0; i < names.size(); i++) {
            display.append(" ").append(names.get(i));
            if (i < names.size() - 1) {
                display.append(",");
            }
        }

        return display.toString();
    }
}
