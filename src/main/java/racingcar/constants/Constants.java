package racingcar.constants;

public class Constants {

    public static final String INPUT_CAR_LIST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static final int NAME_MAX_LENGTH = 5;
    //    public static final String CAR_LIST_PATTERN = "^([a-zA-Z0-9가-힣])(,[a-zA-Z0-9가-힣])*$";
    public static final String CAR_LIST_PATTERN = "^[a-zA-Z0-9가-힣]+[a-zA-Z0-9가-힣" + "," + "]*[a-zA-Z0-9가-힣]";

    public static final int GO_NUMBER = 4;
}
