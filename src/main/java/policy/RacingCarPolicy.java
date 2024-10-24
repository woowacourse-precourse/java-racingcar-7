package policy;

public class RacingCarPolicy implements RacingPolicy {
    private static final  String NAME_SEPARATOR = ",";
    private static final String MOVE_FORWARD_SYMBOL = "-";
    private static final int nameLengthPolicy= 5;
    private static final Integer moveCriterion = 4;

    public RacingCarPolicy() {
    }

    /**
     * 전진 정책 : 0~9사이 값 중 무작위 값 4이상일 경우 전진한다.
     * 전진에 해당할경우 true를 리턴한다.
     */
    @Override
    public Boolean isMoveForward(int randomNumber) {
        return randomNumber>= moveCriterion;
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
