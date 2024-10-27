package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자 입력 받기
        String carNames = Console.readLine();
        int rounds = Integer.parseInt(Console.readLine());

        //자동차 게임 시작
        // 입력받은 이름 파싱
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            String trimmedName = name.trim();
            if(trimmedName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
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
            String position = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + position);
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
}
