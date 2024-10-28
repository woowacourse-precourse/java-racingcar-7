package racingcar;

public class Race {
    public void play(Cars cars, PlayCount playCount) {
        int count = playCount.getPlayCount();

        for (int i = 0; i < count; i++) {
            cars.foward();
        }
    }
}
