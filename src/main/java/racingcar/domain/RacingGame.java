package racingcar.domain;

public class RacingGame {
    private int[] distances;

    public RacingGame(int size) {
        distances = new int[size];
    }

    public void startGame(Car[] cars) {
        for(int i = 0; i < cars.length; i++){
            distances[i] = cars[i].move();
        }
    }

    public int[] getDistances() {
        return distances;
    }
}
