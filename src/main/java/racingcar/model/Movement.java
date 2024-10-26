package racingcar.model;

public class Movement {

    private Random random = new Random();

    public Boolean forward() {
        if (random.getNumber() >= 4) {
            return true;
        }
        return false;
    }
}
