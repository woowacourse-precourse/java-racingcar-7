package racingcar.view;

import racingcar.dto.RaceProgressDto;

public class OutputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String SEPARATOR = " : ";
    private static final String PROGRESS_MARK = "-";

    private OutputView() {
    }

    public static void showCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public static void showTryCountInputMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public static void showResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void showRaceProgress(RaceProgressDto raceProgressDto) {
        raceProgressDto.getCarProgressList().forEach(carProgress -> {
            String progress = carProgress.getName()
                    + SEPARATOR
                    + PROGRESS_MARK.repeat(carProgress.getPosition());
            System.out.println(progress);
        });
    }
}
