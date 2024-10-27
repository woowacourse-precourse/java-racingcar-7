package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        // TODO: 입력 오류

        String[] names = input.split(",");
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = scanner.nextInt();

        play(names, count);
    }

    private static void play(String[] names, int count) {
        List<Car> cars = new ArrayList<>();

        // Car 만들기
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        // 게임 시작
        for (int i = 0; i < count; i++) {
            // 차 전진
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).move();
                cars.get(j).print();
            }
            System.out.println();
        }

        // 경기 결과
        winner(cars);

    }

    private static void winner(List<Car> cars) {
        Collections.sort(cars, new CarComparator());
        int winningCount = cars.get(cars.size() - 1).getAdvanceCount();

        ArrayList<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getAdvanceCount() == winningCount) {
                winner.add(car.getName());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winner.size(); i++) {
            sb.append(winner.get(i));
            if (i < winner.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + sb);
    }
}
