package racingcar;

import java.util.List;

public class PrintCurrent {
    public PrintCurrent() { }

    public void printNow(List<Car> cars) {
        for(int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i).getName() + " : ");
            for(int j = 0; j < cars.get(i).getAdvance(); j++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.println();
        }
    }
}
