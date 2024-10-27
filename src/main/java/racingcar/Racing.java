package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

class Racing {

    InputString inputString;
    CarCollection carCollection;
    private final int RANDOM_NUMBER_START = 0;
    private final int RANDOM_NUMBER_END = 9;

    Racing(InputString inputString) {
        this.inputString = inputString;
        carCollection = inputString.getCarCollection();
    }

    public void start(int tryCount) {
        System.out.println("\n실행 결과");
        while (tryCount-- > 0) {
            moveCars();
            printCars();
        }
        printResult();
    }

    private void printCars() {
        StringBuilder sb = new StringBuilder();
        List<String> carNames = carCollection.getCarNames();
        for (int i = 0; i < carCollection.carCount(); i++) {
            sb.append(carNames.get(i) + " : ");
            List<Integer> carMoveCountList = carCollection.getCarMoveCount();
            sb.append("-".repeat(carMoveCountList.get(i))).append("\n");
        }
        System.out.println(sb);
    }


    private void moveCars() {
        for (int i = 0; i < carCollection.carCount(); i++) {
            int randomNum = Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
            carCollection.moveCar(i, randomNum);
        }
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        String result = String.join(", ", carCollection.getWinnerList());
        sb.append(result);
        System.out.println(sb);
    }
}

