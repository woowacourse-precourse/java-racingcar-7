package racingcar.domain;

import java.util.List;

public class Game {
    private Long id;
    private final List<Car> cars;
    private final int progress;
    private int currentProgress = 0;

    public Game(List<Car> cars, int progress) {
        this.cars = cars;
        this.progress = progress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void incrementProgress() {
        this.currentProgress++;
    }
}
