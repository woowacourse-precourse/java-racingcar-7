package racingcar;


import camp.nextstep.edu.missionutils.Console;

public class Application {

    private final RacingCar racingCar;

    public Application() {

        this.racingCar = new RacingCar();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.run();
    }

    public void run() {

        String cars;
        String attempts;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = Console.readLine();

        System.out.println("시도할 횟수는 몇회인가요?");
        attempts = Console.readLine();

        racingCar.racingCars(cars, attempts);
    }
}
