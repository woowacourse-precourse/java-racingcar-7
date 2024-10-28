package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        String input = inputView.inputCarNames();

        // Car 라는 클래스를 만들어 List<Car>로 처리할까 -> 확장성 고려해서(나중에 후진 같은 것이 생길지도)
        // Map<String, Integer>로 처리할까

        List<Car> cars = new ArrayList<>();
        for (String carName : input.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            Car car = new Car(carName, 0);
            cars.add(car);
        }

        int tryCount = inputView.inputTryCount();
        System.out.println();

        System.out.println("실행결과");

        while (tryCount > 0) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    car.moveForward();
                }
                car.printForward();
            }

            tryCount = tryCount - 1;
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        List<Car> winningCars = Car.getMaxByForward(cars);
        for(int i=0; i< winningCars.size(); i++){
            Car car = winningCars.get(i);
            if(i == 0) car.printCarName();
            else car.printCarNameWithComma();
        }
    }

}
