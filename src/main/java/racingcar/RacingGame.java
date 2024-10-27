package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private InputHandler inputHandler = new InputHandler();

    public void run() {
        String[] cars = inputHandler.getCarNames();
        int tryCount = inputHandler.getTryCount();

        List<Car> carList = new ArrayList<>();

        for(String car : cars) {
            carList.add(new Car(car));
        }

        System.out.println();
        System.out.println("실행 결과");

        for(int i=0; i<tryCount; i++) {
            for (Car car : carList) {
                if(Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.count ++;
                }
                System.out.print(car.name + " : ");
                for(int j=0;j<car.count;j++){
                    System.out.print("-");
                }
            }
        }
    }
}
