package racingcar.domain.road.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.road.entity.Road;

public class RandomRoadCreator implements RoadCreator {

    @Override
    public void addRandomRoad(Road road){
        int addLength = Randoms.pickNumberInRange(0, 9);
        if(addLength >= 4){
            road.addRoad(1);
        }
    }
}
