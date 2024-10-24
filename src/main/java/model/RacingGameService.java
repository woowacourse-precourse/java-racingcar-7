package model;

import java.util.List;

public interface RacingGameService {
    void progress(List<RacingCar> cars, int round);
}
