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
        System.out.println("실행 결과");

        while(tryCount > 0) {
            for(int i = 0; i < cars.size(); i++) {
                cars.get(i).doAdvance();
            }

            printCurrent.printNow(cars);
            tryCount--;
        }
    }
}
