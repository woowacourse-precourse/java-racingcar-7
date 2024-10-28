package racingcar;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)){
            String[] names = nameInput(scanner);
            int count = getTryCount(scanner);
            play(names, count);

        } catch (IllegalArgumentException e) {
            throw e;
        }

    }

    private static String[] nameInput(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        String names[] = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
            }
        }
        return names;
    }

    private static int getTryCount(Scanner scanner) {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int count = scanner.nextInt();
            if (count < 1) {
                throw new IllegalArgumentException("1 이상의 숫자를 입력해 주세요.");
            }
            return count;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해 주세요.");
        }
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
            for (Car car: cars) {
                car.move();
                car.print();
            }
            System.out.println();
        }

        // 경기 결과
        List<String> winners = getWinners(cars);
        printWinners(winners);

    }

    private static List<String> getWinners(List<Car> cars) {

        int winningCount = Collections.max(cars, new CarComparator()).getAdvanceCount();
        List<String> winner = new ArrayList<>();

        for (Car car : cars) {
            if (car.getAdvanceCount() == winningCount) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

    private static void printWinners(List<String> winner) {
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
