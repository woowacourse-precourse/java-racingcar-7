package racingcar.view;

import racingcar.model.Car;
import racingcar.view.dto.RaceResult;

import java.util.List;

public class OutputView {
    private static final String NOTICE_STATEMENT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NOTICE_STATEMENT_CNT = "시도할 횟수는 몇 회인가요?";
    private static final String NOTICE_STATEMENT_RESULTS = "실행 결과";

    public void printNoticeStatementName() {
        System.out.println(NOTICE_STATEMENT_NAME);
    }

    public void printNoticeStatementCnt(){
        System.out.println(NOTICE_STATEMENT_CNT);
    }

    public void printRaceResults(List<RaceResult> raceResults){
        for (RaceResult raceResult : raceResults) {

        }
    }

    public void printRaceResult(RaceResult raceResult) {
        System.out.println(NOTICE_STATEMENT_RESULTS);

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
}
