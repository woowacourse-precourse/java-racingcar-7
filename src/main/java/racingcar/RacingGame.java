package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingCarRepository;
import racingcar.service.CarService;
import racingcar.service.RacingCarService;

public class RacingGame {

    // Todo: 생성자로 초기하는게 좋은 것인가?
    private final static CarRepository carRepository = new RacingCarRepository();
    private final static CarService carService = new RacingCarService(carRepository);

    // Todo: 입력 함수 분리를 통해 생성자로 초기화
    //    private static int tryCount;


    // Todo: 자동차 이름 입력 + 시도 횟수 입력
    public void start() {
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = Console.readLine().split(",");

        System.out.println("시도할 횟수");
        int tryCount = Integer.parseInt(Console.readLine());

        for (String car : cars) {
            carService.register(new Car(car));
        }

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            move();
            printResult();
        }

        printWinner();
    }

    // Todo: 전진 조건에 따른 자동차 이동
    public void move() {
        for (Car car : carService.getAllCars()) {
            int moveCondition = Randoms.pickNumberInRange(0, 9);
            if (moveCondition >= 4) {
                car.move();
            }
        }
    }

    // Todo: 게임 결과 출력
    public void printResult() {

        for (Car car : carService.getAllCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    // Todo: 최종 우승자 출력
    public void printWinner() {
        int maxPosition = 0;
        for (Car car : carService.getAllCars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        System.out.print("최종 우승자 : ");
        for (Car car : carService.getAllCars()) {
            if (car.getPosition() == maxPosition) {
                System.out.print(car.getName() + ", ");
            }
        }
    }
}
