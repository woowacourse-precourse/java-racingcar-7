package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarDto;

public class OutputView {

    private static final String INPUT_CAR_NAMES_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPTS_PROMPT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String PROMPT_RUN_RESULT_TITLE = "실행 결과";
    private static final String LOCATION_FORMAT = "-";
    private static final String CAR_INFO_FORMAT = "%s : %s\n";
    private static final String MESSAGE_FINAL_WINNER_TITLE = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public void displayInputCarNamesPrompt() {
        System.out.println(INPUT_CAR_NAMES_PROMPT_MESSAGE);
    }

    public void displayAttemptsPrompt() {
        System.out.println(INPUT_ATTEMPTS_PROMPT_MESSAGE);
    }

    public void displayRoundResultHeader() {
        System.out.println();
        System.out.println(PROMPT_RUN_RESULT_TITLE);
    }

    public void displayCars(List<CarDto> cars) {
        String result = cars.stream()
                .map(this::formatCarInfo)
                .collect(Collectors.joining());
        System.out.println(result);
    }

    private String formatCarInfo(CarDto car) {
        String location = LOCATION_FORMAT.repeat(car.location());
        return CAR_INFO_FORMAT.formatted(car.name(), location);
    }

    public void displayWinners(List<String> winners) {
        System.out.print(MESSAGE_FINAL_WINNER_TITLE);
        String winnerText = String.join(WINNER_DELIMITER, winners);
        System.out.println(winnerText);
    }
}
