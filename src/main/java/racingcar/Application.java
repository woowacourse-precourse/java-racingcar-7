package racingcar;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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

        processResult = new String[RacingProcess.carNumber];
        Arrays.fill(processResult, "");

        resultNum = new int[RacingProcess.carNumber];
        Arrays.fill(resultNum, 0);

        for (int i = 0; i < racingNumber; i++) {
            RacingProcess.racingProcess();
            ResultPrint.resultPrint();
        }




        public static void winnerPrint() {
            int maxNumber = resultNum[0];
            for (int i : resultNum) {
                if (i > maxNumber) {
                    maxNumber = i;
                }
            }
            List<String> result = new ArrayList<>();
            for (int i : resultNum) {
                if (i == maxNumber) {
                    result.add(nameList[i]);
                }
            }

            System.out.println("최종 우승자 : " + String.join(",",result));
        }
    }
}