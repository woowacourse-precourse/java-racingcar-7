package policy;

import vehicle.Vehicle;

public interface RacingPolicy {
    Boolean isMoveForward(Vehicle vehicle);
    String getMoveForwardSymbol();
    String getNameSeparator();
}
