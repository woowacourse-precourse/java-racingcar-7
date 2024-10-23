package vehicle;

import policy.RacingPolicy;

public interface Vehicle {
    RacingPolicy getRacingPolicy();
    String getVehicleName();
    Long getMoveForwardCount();
    void move();
}
