package racingcar.dto;

import racingcar.domain.Car;

import java.util.List;

public class RaceResponse {

    private final List<Car> carStates;

    private final String winner;

    public RaceResponse(List<Car> carStates, String winner) {
        this.carStates = carStates;
        this.winner = winner;
    }

    public List<Car> getCarStates() {
        return carStates;
    }

    public String getWinner() {
        return winner;
    }
}
