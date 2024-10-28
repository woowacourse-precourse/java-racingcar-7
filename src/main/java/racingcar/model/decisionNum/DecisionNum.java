package racingcar.model.decisionNum;

import camp.nextstep.edu.missionutils.Randoms;

public class DecisionNum {

    private static final int MIN_RANDOM_NUM = 0;
    private static final int MAX_RANDOM_NUM = 9;
    private static final int GO_LIMIT = 4;

    public static int GenerateDecisionNum() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }

    public static boolean isGo(int decisionNum) {
        if (decisionNum <= GO_LIMIT) {
            return true;
        }
        return false;
    }

}
