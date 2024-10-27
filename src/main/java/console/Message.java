package console;

public class Message {

    public static final String PROMPT_FOR_RACING_CARS = """
            경주할 자동차 이름을 입력해주세요.
                        
            * 여러 차량의 이름은 쉼표(,)로 구분하세요.
            * 각 이름에는 공백을 넣지 마세요.
            * 예시: pobi,woni,jun
                        
            입력 후 엔터를 누르면 확인됩니다.""";
    public static final String PROMPT_FOR_ATTEMPTS = """
            시도할 횟수를 입력해주세요.
                        
            * 숫자만 입력 가능합니다.
            * 입력 횟수는 1이상의 정수를 입력해주세요
            * 최대 2147483647까지 입력 가능합니다.
            * 예시: 5""";
    public static final String WINNER_ANNOUNCEMENT_PREFIX = "최종 우승자 : ";
    public static final String CAR_NAME_LENGTH_ERROR = "이름은 5자 이하만 가능합니다.";
    public static final String NUMERIC_INPUT_PATTERN = "[0-9]+";
    public static final String NATURAL_NUMBER_VALIDATION_ERROR = "1이상의 정수만 입력 가능합니다.";
    public static final String NUMBER_TOO_LARGE_ERROR = "숫자가 너무 큽니다.";
    public static final String CAR_NAME_FORMAT_ERROR = "경주할 자동차 이름은 공백없이 쉼표(,)로 구분해주세요.";
    public static final String CAR_NAME_SEPARATOR_ERROR = "각 자동차는 쉼표(,)로 구분되어야 합니다.";
    public static final String VALUE_REQUIRED_ERROR = "값을 입력해주세요";
    public static final String OUTPUT_SEPARATOR = " : ";
}
