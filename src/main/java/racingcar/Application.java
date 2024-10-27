package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        Racing racing = new Racing(new InputString(str));
        racing.start();
    }
}

class Racing {

    InputString inputString;
    CarCollection carCollection;
    private final int RANDOM_NUMBER_START = 0;
    private final int RANDOM_NUMBER_END = 9;
    private final String NUMBER_FORMAT_ERROR_MESSAGE = "[error] 정상적인 숫자 입력이 아닙니다.";

    Racing(InputString inputString) {
        this.inputString = inputString;
        carCollection = inputString.getCarCollection();
    }

    public void start() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount=0;
        try {
            tryCount = Integer.parseInt(Console.readLine());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }

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
