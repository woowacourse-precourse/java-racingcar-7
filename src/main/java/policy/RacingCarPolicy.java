package policy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingCarPolicy implements RacingPolicy {
    private final  String NAME_SEPARATOR = ",";
    private final String MOVE_FORWARD_SYMBOL = "-";
    private final int nameLengthPolicy= 5;
    private final List<Integer> baseNumbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    private final Integer moveCriterion = 4;

    public RacingCarPolicy() {
    }

    /**
     * 전진 정책 : 0~9사이 값 중 무작위 값 4이상일 경우 전진한다.
     * 전진에 해당할경우 true를 리턴한다.
     */
    @Override
    public Boolean isMoveForward() {
        List<Integer> shuffle = Randoms.shuffle(baseNumbers);
        return Randoms.pickNumberInList(shuffle) > moveCriterion;
    }

    @Override
    public String getMoveForwardSymbol() {
        return MOVE_FORWARD_SYMBOL;
    }

    @Override
    public String getNameSeparator() {
        return NAME_SEPARATOR;
    }

    @Override
    public int getNameLengthPolicy() {
        return nameLengthPolicy;
    }

}
