package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
    public static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final int ADVANCE_STANDARD = 4;
    public static final int MAX_NAME_SIZE = 5;
    private static int ADVACE_COUNT;

    public static int getAdvaceCount() {
        return ADVACE_COUNT;
    }

    public static void setAdvaceCount(int advaceCount) {
        Utils.ADVACE_COUNT = advaceCount;
    }
    public static int getRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
