package racingcar;

import java.util.Arrays;

import static racingcar.RacingProcess.*;
import static racingcar.ResultPrint.*;
import static racingcar.WinnerPrint.*;

public class Application {

    public static String[] nameList;
    public static int racingNumber;
    public static String[] processResult;
    public static int[] resultNum;

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarInput = camp.nextstep.edu.missionutils.Console.readLine();

        nameList = CarList.carList(CarInput);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputNumber = camp.nextstep.edu.missionutils.Console.readLine();

        racingNumber = RacingNum.numValid(inputNumber);

        //횟수만큼 결과 반영 및 출력 반복

        processResult = new String[carNumber];
        Arrays.fill(processResult, "");

        resultNum = new int[carNumber];
        Arrays.fill(resultNum, 0);

        System.out.println("실행 결과");

        for (int i = 0; i < racingNumber; i++) {
            racingProcess();
            resultPrint();
        }

        winnerPrint();

    }
}