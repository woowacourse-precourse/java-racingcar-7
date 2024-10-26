package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.Print;

public class Application {
    public static void main(String[] args) {
        /**
         * 자동차 이름 입력 및 라운드 입력
         * 유효성 검사는 내부적으로 작동되도록 설계되어 있음
         */
        Input input = new Input();
        Print print = new Print();

        print.carNameInputRequest();
        List<String> carsName = input.inputCarsName();
        print.roundInputRequest();
        int rount = input.inputRound();

        List<Car> carList = new ArrayList<>();

        for (String carName : carsName) {
            carList.add(new Car(carName));
        }
        System.out.println();

        /**
         * 라운드 진행
         */
        print.result();
        for (int i = 0; i < rount; i++) {
            carList.forEach(Car::move);
            System.out.println();
        }

        /**
         * 우승자 출력
         */
        print.winner(carList);

    }
}
