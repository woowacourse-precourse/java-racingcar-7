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

    public static void game(List<Car> carList, int moveCount) {
        int maxPosition = 0;

        //이동 및 최장 거리 계산
        while (moveCount-- > 0) {
            //maxPosition = Integer.max(maxPosition, moveCar());
        }

        //우승자 결정
        //checkWinner(List<car> carList, int maxPosition);
    }

    public static void main(String[] args) {
        game(getCarList(), getMoveCount());
    }
}
