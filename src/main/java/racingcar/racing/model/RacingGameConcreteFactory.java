package racingcar.racing.model;

import java.util.List;

public class RacingGameConcreteFactory implements RacingGameFactory {
    private final Game game;
    private final List<Car> cars;
    private final Winner winner;

    // todo: createLst 시 Factory에 의존적인 생성? 혹은 createCar 추가? 고민하기
    @Override
    public List<Car> createCars(List<String> carNameList, int totalCarNumber) {
        return null;
    }

    // todo: 의존성 주입 확인
    public RacingGameConcreteFactory(List<String> carNameList, int totalCarNumber) {
        this.game = new Game();
        this.cars = createCars(carNameList, totalCarNumber);
        this.winner = new Winner();
    }
}
