package racingcar.game;

import java.util.List;
import racingcar.car.Car;

public class RacingCarGame {
    private final int loop;
    private final List<Car> cars;

    private RacingCarGame(int loop, List<Car> cars) {
        this.loop = loop;
        this.cars = cars;
    }

    public static RacingCarGame createLoopedRacingCarGame(int loop, List<Car> cars) {
        final int GAME_MINIMUM_CARS= 2;
        final int GAME_MAXIMUM_CARS_= 5;

        final int GAME_MINIMUM_LOOP = 1;
        final int GAME_MAXIMUM_LOOP_= 100;

        if(cars.size() < GAME_MINIMUM_CARS){
                throw new IllegalArgumentException("자동차 최소 2대부터 게임 가능합니다.");
        }

        if(cars.size() > GAME_MAXIMUM_CARS_){
                throw new IllegalArgumentException("자동차 최대 5대까지 게임 가능합니다.");
        }

        if(loop < GAME_MINIMUM_LOOP){
                throw new IllegalArgumentException("게임횟수 최소 1번부터 게임 가능합니다");
        }

        if(loop > GAME_MAXIMUM_LOOP_){
            throw new IllegalArgumentException("게임횟수 최대 100번까지 게임 가능합니다");
        }

        return new RacingCarGame(loop,cars);
    }
}
