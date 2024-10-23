package policy;

import vehicle.Vehicle;

public class RacingCarPolicyImpl implements RacingPolicy {
    private final static String NAME_SEPARATOR = ",";
    private final static String MOVE_FORWARD_SYMBOL = "-";

    public RacingCarPolicyImpl() {
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

}
