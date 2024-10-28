package racingcar;

public class Game {
    private Cars cars;
    private int gameCount;

    public Game(Cars cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void playGame(){
        for (int i = 0; i < gameCount; i++) {
            cars.moveCars();
            cars.printCurrentPositions();
        }
    }
}
