package racingcar;

import java.util.List;

public class Play {
    private List<Car> cars;

    public Play(List<Car> cars) {
        this.cars = cars;
    }

    public void play(String tryCountString) {
        try {
            int tryCount = Integer.parseInt(tryCountString);
        } catch (NumberFormatException npe) {
            throw new IllegalArgumentException();
        }
        
    }

    
}
