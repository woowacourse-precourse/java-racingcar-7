package racingcar.service;

import racingcar.repository.CarRepository;

public class GameServiceImpl implements GameService {

    private final CarRepository carRepository;

    public GameServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void executeRace(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            moveCarsRandomly();
        }
    }

    private void moveCarsRandomly() {

    }
}
