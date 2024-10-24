package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    private Cars cars;
    private Integer gameRound;

    public Game(Cars cars, Integer gameRound) {
        this.cars = cars;
        this.gameRound = gameRound;
    }

    private Cars playRound(List<Car> cars) {
        cars.forEach(car -> {
            int randomNum = Randoms.pickNumberInRange(0, 9);
        });
        return new Cars(cars);  // Cars 객체를 반환
    }

    public Integer getGameRound(){
        return this.gameRound;
    }
}
