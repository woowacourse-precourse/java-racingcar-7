package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = inputCars();
        int attempts = inputAttempts();

        //경주 진행
        for(int i = 0; i < attempts; i++){
            moveCars(cars);
            //todo: 자동차 이동 상태 출력
        }

    }

    // 자동차 정보 입력
    private static List<Car> inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    // 시도 횟수 입력
    private static int inputAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    // 자동차 이동
    private static void moveCars(List<Car> cars){
        for(Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.increasePosition();
            }
        }
    }
}
