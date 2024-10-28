package racingcar;

import java.util.*;

public class Application {
    public static List<Car> getCarList() throws IllegalArgumentException {
        String inputString;
        String[] carNames;
        List<Car> carList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputString = camp.nextstep.edu.missionutils.Console.readLine();
        carNames = inputString.split(",");

        //자동차 이름 길이 확인
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            carList.add(new Car(carName));
        }

        return carList;
    }

    public static int getMoveCount() throws IllegalArgumentException {
        String inputString;
        int moveCount;

        System.out.println("시도할 횟수는 몇 회인가요?");
        inputString = camp.nextstep.edu.missionutils.Console.readLine();

        try {
            moveCount = Integer.parseInt(inputString);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (moveCount < 0) {
            throw new IllegalArgumentException();
        } else {
            return moveCount;
        }
    }

    public static int moveCar(List<Car> carList) {
        int maxPosition = 0;

        for (Car car : carList) {
            car.move();
            System.out.printf("%s : ", car.getName());
            System.out.println("-".repeat(car.getPosition()));
            maxPosition = Integer.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    public static void checkWinner(List<Car> carList, int maxPosition) {
        List<String> winnerList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winnerList));
    }

    public static void game(List<Car> carList, int moveCount) {
        int maxPosition = 0;
        System.out.println("\n실행 결과");

        //이동 및 최장 거리 계산
        while (moveCount-- > 0) {
            maxPosition = Integer.max(maxPosition, moveCar(carList));
            System.out.println();
        }

        //우승자 결정
        checkWinner(carList, maxPosition);
    }

    public static void main(String[] args) throws IllegalArgumentException {
        try {
            game(getCarList(), getMoveCount());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
