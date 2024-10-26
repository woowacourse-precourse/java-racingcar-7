package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.entity.Road;

public class RandomRoadCreator implements RoadCreator {

    @Override
    public void addRandomRoad(Road road){
        int addLength = Randoms.pickNumberInRange(0, 9);
        road.addRoad(addLength);
    }
}
