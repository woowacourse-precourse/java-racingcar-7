package policy;

import vehicle.Vehicle;

public class RacingCarPolicy implements RacingPolicy {
    private final  String NAME_SEPARATOR = ",";
    private final String MOVE_FORWARD_SYMBOL = "-";
    private final int nameLengthPolicy= 5;

    public RacingCarPolicy() {
    }


    @Override
    public Boolean isMoveForward(Vehicle vehicle) {
        return null;
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
