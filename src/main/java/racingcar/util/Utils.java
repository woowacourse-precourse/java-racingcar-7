package racingcar.util;

public class Utils {
    public static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static int advanceCount;

    public int getAdvanceCount() {
        return advanceCount;
    }

    public static void setAdvanceCount(int advanceCount) {
        Utils.advanceCount = advanceCount;
    }
}
