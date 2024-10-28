package racingcar;

public class Rule {
    private static final String NAME_OVER_LENGTH = "[Error] 이름은 5자를 넘어가면 안됩니다";
    private static final String NOT_EXIST_COMMA = "[Error] 자동차의 이름을 입력할 때 쉼표가 필요합니다";
    private static final String ROUND_IS_NOT_NORMALITY = "[Error] 시도 횟수가 자연수가 아닙니다";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int MINIMUM_ROUND = 1;

    private Rule(){
        //유틸리티 클래스의 인스턴스화를 막기 위해 private 으로 선언
    }
    public static void validateNameLength(String name){
        if(name.length() > NAME_MAX_LENGTH){
            throw new IllegalArgumentException(NAME_OVER_LENGTH);
        }
    }
    public static void validatePlayersInput(String input) {
        if (input != null && !input.contains(",")) {
            throw new IllegalArgumentException(NOT_EXIST_COMMA);
        }
    }

    public static void validateNaturalNumber(int round) {
        if (round < MINIMUM_ROUND) {
            throw new IllegalArgumentException(ROUND_IS_NOT_NORMALITY);
        }
    }
}
