package racingcar;

public class OutputManager {

    private static final String GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static void printGuideMessage() {
        System.out.println(GUIDE_MESSAGE);
    }
}
