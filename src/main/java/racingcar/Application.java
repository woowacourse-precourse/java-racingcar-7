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
        if (attempts < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        //경주 진행
        for(int i = 0; i < attempts; i++){
            moveCars(cars);
            printRaceResult(cars);
        }
        printWinners(cars);

    }

    // 자동차 정보 입력
    private static List<Car> inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            carName = carName.trim();

            cars.add(new Car(carName));
        }

        return cars;
    }

    private static void validateCarName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }else if (name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
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

    // 자동차 이동 결과 출력
    private static void printRaceResult(List<Car> cars){
        for (Car car : cars){
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static void printWinners(List<Car> cars){
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(RuntimeException::new);
        List<String> winners = new ArrayList<>();
        for(Car car:  cars){
            if(car.getPosition() == maxPosition){
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
