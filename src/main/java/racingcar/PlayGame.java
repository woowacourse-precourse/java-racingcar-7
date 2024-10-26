package racingcar;

import java.util.List;

public class PlayGame {
    List<Car> cars;
    PrintCurrent printCurrent;

    public PlayGame() {
        printCurrent = new PrintCurrent();
    }

    public void play(List<Car> cars, int tryCount) {
        this.cars = cars;

        while(tryCount > 0) {
            for(int i = 0; i < cars.size(); i++) {
                cars.get(i).doAdvance();
            }

            printCurrent.printNow(cars);
            tryCount--;
        }
    }
}
