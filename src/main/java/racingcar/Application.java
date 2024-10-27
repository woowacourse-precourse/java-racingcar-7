package racingcar;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarInput = camp.nextstep.edu.missionutils.Console.readLine();

        String[] nameList = CarList.carList(CarInput);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputNumber = camp.nextstep.edu.missionutils.Console.readLine();

        int racingNumber = RacingNum.numValid(inputNumber);

        //횟수만큼 결과 반영 및 출력 반복
        int carNumber = nameList.length;

        String[] processResult = new String[carNumber];
        Arrays.fill(processResult, "");

        int[] resultNum = new int[carNumber];
        Arrays.fill(resultNum,0);

        public static int[] racingProcess () {

            int[] processNum = new int[carNumber];
            Arrays.fill(processNum, -1);

            for (int i : processNum) {
                i = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
            }

            for (int i = 0; i < carNumber; i++) {
                if (processNum[i] >= 4) {
                    processResult[i] += " -";
                    resultNum[i]++;
                }
            }
        }

        public static void resultOutput() {
            System.out.println("실행 결과");
            for (int i = 0; i < carNumber; i++) {
                System.out.println(nameList[i] + " :" + processResult[i]);
            }
            System.out.println();
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