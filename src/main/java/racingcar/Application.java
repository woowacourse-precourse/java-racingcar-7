package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 경주 자동차 리스트, 시도 횟수 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<RacingCar> carList = car_input(Console.readLine());
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = count_input(Console.readLine());

        // 경주 시작
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            for (RacingCar car : carList) {
                car.move();
                System.out.println(car.getName() + " : " + car.getlength(car.getDistance()));
            }
            System.out.println();
        }

        // 경주 결과 출력
        int maxDistance = getMaxDistance(carList);
        String winners = findWinner(carList, maxDistance);

        System.out.println("최종 우승자 : " + winners);


    }

    public static List<RacingCar> car_input(String input) {
        validateCar(input);
        String[] carArray = input.split(",");
        List<RacingCar> cars = new ArrayList<>();
        for (String name : carArray) {
            validateCarLength(name);
            cars.add(new RacingCar(name.trim()));
        }
        return cars;
    }

    public static int count_input(String input) {
        validateCount(input);
        return Integer.parseInt(input);
    }


    public static int getMaxDistance(List<RacingCar> carList) {
        int maxDistance = carList.stream()
                .mapToInt(RacingCar::getDistance)
                .max()
                .orElse(0);
        return maxDistance;
    }

    public static String findWinner(List<RacingCar> carList, int maxDistance) {
        StringBuilder winner = new StringBuilder();
        for (RacingCar car : carList) {
            if (car.getDistance() == maxDistance) {
                if (winner.length() > 0) {
                    winner.append(", ");
                }
                winner.append(car.getName());
            }
        }
        return winner.toString();
    }

    public static void validateCar(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 형식이 맞지 않습니다.");
        }
    }

    public static void validateCarLength(String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("길이가 너무 깁니다.");
        }
    }

    public static void validateCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 시도 횟수입니다. 숫자 형식의 정수를 입력해 주세요.");
        }

    }


}


