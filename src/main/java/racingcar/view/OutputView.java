package racingcar.view;

import java.util.List;
import racingcar.model.dto.CarStatusDto;

public class OutputView {

    private static final String NEXT_LINE = System.lineSeparator();
    private static final String FORWARD_DASH = "-";

    public void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputRacingCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRacingResultMessage() {
        System.out.println(NEXT_LINE + "실행 결과");
    }

    public void printRacingResult(List<CarStatusDto> racingResults) {
        for (CarStatusDto racingResult : racingResults) {
            String name = racingResult.name();
            int position = racingResult.position();

            String dashCount = FORWARD_DASH.repeat(position);
            System.out.println(name + " : " + dashCount);
        }
        System.out.println();
    }
}
