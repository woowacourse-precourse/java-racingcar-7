package racingcar;

public class Constants {
    public static final String CAR_NAME_REGEXP = "[\\w\\s,|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+";
    public static final String ATTEMPTS_REGEXP = "\\d+";
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    public static final String INPUT_ATTEMPTS = "시도할 횟수는 몇 회인가요?";
    public static final String RESULT_NOTICE = "실행 결과";
    public static final String WINNER_NOTICE = "최종 우승자 : ";
}
