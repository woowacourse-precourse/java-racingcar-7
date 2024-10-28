package racingcar;

public class Game {
    private Cars cars;
    private int gameCount;
    private Output output;

    public Game(Cars cars, int gameCount, Output output) {
        this.cars = cars;
        this.gameCount = gameCount;
        this.output = output;
    }

    public Game(Cars cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void playGame(){
        for (int i = 0; i < gameCount; i++) {
            cars.moveCars();
            output.printCurrentPositions(cars);
        }
        output.printWinners(cars);
    }
}
