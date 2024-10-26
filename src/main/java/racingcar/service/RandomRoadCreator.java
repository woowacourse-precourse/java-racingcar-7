package racingcar.service;

import racingcar.entity.Road;

import java.util.Random;

public class RandomRoadCreator implements RoadCreator {
    private Random random = new Random();

    @Override
    public void addRandomRoad(Road road){
        int addLength = random.nextInt(10);
        road.addRoad(addLength);
    }
}
