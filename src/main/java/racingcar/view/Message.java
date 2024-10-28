package racingcar.view;

public class Message {

    public static String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String COUNT = "시도할 횟수는 몇 회인가요?";

    public static String ERROR_EMPTY = "입력되지 않았습니다. 경주할 자동차 이름을 입력해주세요.";
    public static String ERROR_ONECAR = "경주를 하기 위해서는 2대 이상의 자동차가 필요합니다.";
    public static String ERROR_OVERNAME = "자동차 이름은 5자 이하로 입력해야 합니다.";
    public static String ERROR_INVALIDNAME = "자동차 이름은 알파벳, 숫자, 공백 및 특정 특수문자만 포함해야 합니다.";
    public static String ERROR_SAMENAME = "자동차 이름은 중복될 수 없습니다";
    public static String ERROR_EMPTYCOUNT = "이동 횟수가 입력되지 않았습니다. 횟수는 1 이상이어야 됩니다.";
    public static String ERROR_INVALIDCOUNT1 = "문자 및 소수점은 입력할 수 없습니다. \n시도 횟수는 정수만 입력하셔야 됩니다.";
    public static String ERROR_INVALIDCOUNT2 = "음수는 입력할 수 없습니다. \n시도 횟수는 1이상의 정수만 입력하셔야 됩니다.";
}
