package racingcar.common;

public class Constants {
    public static String GET_CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String GET_GAME_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

    public static Long START_LOCATION = 0L;
    public static Integer MAX_NAME_LENGTH = 5;
    public static String ONLY_POSITIVE = "^[1-9]\\d*$";


    public static String DUPLICATED_CAR_NAMES = "차 이름은 중복이 될 수 없습니다.";
    public static String INVALID_CAR_NAME = "차 이름은 1자 이상 5자 이내여야 합니다.";
    public static String INVALID_GAME_COUNT = "게임 횟수는 1 이상의 수를 입력해야 합니다.";
    }
