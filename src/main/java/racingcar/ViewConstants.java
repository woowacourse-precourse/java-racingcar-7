package racingcar;

import static racingcar.RacingConstants.MAX_LENGTH_OF_CAR_NAME;

public class ViewConstants {
    public static final String ENTER_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TOTAL_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static final String RACING_RESULT = "실행 결과";
    public static final String WINNER_IS = "최종 우승자 : ";

    public static final String CAR_STATUS_FORMAT = "%s : ";
    public static final String POSITION_MARK = "-";

    public static final String NAME_LENGTH_ERROR_MESSAGE
            = String.format("자동차 이름은 %s자 이하만 가능합니다.", MAX_LENGTH_OF_CAR_NAME);
}
