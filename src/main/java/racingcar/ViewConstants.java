package racingcar;

import static racingcar.RacingConstants.MAX_LENGTH_OF_CAR_NAME;
import static racingcar.RacingConstants.MIN_NUMBER_OF_ATTEMPTS;
import static racingcar.RacingConstants.MIN_NUMBER_OF_PLAYERS;

public class ViewConstants {
    public static final String ENTER_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TOTAL_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static final String RACING_RESULT = "실행 결과";
    public static final String WINNER_IS = "최종 우승자 : ";

    public static final String CAR_STATUS_FORMAT = "%s : ";
    public static final String POSITION_MARK = "-";

    public static final String NAME_DELIMITER = ",";
    public static final String ATTEMPT_REGEX = "^[0-9]+$";

    public static final String NO_COMPETITOR_ERROR_MESSAGE
            = String.format("이름을 %s개 이상 입력해야 게임이 시작됩니다.", MIN_NUMBER_OF_PLAYERS);
    public static final String NAME_LENGTH_ERROR_MESSAGE
            = String.format("자동차 이름은 %s자 이하만 가능합니다.", MAX_LENGTH_OF_CAR_NAME);
    public static final String DUPLICATE_NAME_ERROR_MESSAGE = "중복된 이름은 사용할 수 없습니다.";

    public static final String NUMBER_ONLY_ERROR_MESSAGE = "시도 횟수는 숫자만 입력해 주세요.";
    public static final String LESS_THAN_MIN_ATTEMPTS_ERROR_MESSAGE
            = String.format("시도 횟수는 %s회 이상이어야 합니다.", MIN_NUMBER_OF_ATTEMPTS);
}
