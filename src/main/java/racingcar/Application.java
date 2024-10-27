package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자 입력 받기
        String carNames = Console.readLine();
        int rounds = Integer.parseInt(Console.readLine());

        //자동차 게임 시작
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        // 실행
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
            }
            printRoundResults(cars);
        }
        // 결과 출력
        printWinners(cars);
    }

    // 차수별 실행결과 출력 함수
    private static void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + car.getPosition());
        }
        System.out.println();
    }
    // 결과 출력 함수
    private static void printWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }

    // car 클래스 생성
    static class Car {
        private String name;
        private int position = 0;

        public Car(String name) {
            this.name = name;
        }

        public void move() {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                position++;
            }
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }
    }
}
