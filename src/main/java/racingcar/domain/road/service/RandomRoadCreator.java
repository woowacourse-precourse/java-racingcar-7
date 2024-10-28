package racingcar.domain.road.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.road.entity.Road;

import static racingcar.domain.road.entity.Length.FORWARD;

public class RandomRoadCreator implements RoadCreator {

    @Override
    public void addRandomRoad(Road road){
        int addLength = Randoms.pickNumberInRange(0, 9);
        if(addLength >= 4){
            road.addRoad(FORWARD.getValue());
        }
    }
}
