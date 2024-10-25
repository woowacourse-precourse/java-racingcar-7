package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static utils.Input.getInput;

import dto.RacingInput;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // 여기서 사용되지 않는 코드는 필요 없는 코드가 아닐까?
        // 절차지향으로 TDD 한 뒤에 리팩토링 하면서 함수 쪼개고 TDD 하기

        // 입력 기능
        RacingInput input = getInput();

        // 자동차 이름 추출 기능
        String[] cars = input.cars().split(",");

        // 자동차 이름 유효성 검증
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5글자 입니다.");
            }
        }

        // 자동차 전진 기능
        int[] stepsForward = new int[cars.length];

        // 실행 및 출력
        System.out.println("실행 결과");
        for (int i = 0; i < Integer.parseInt(input.repeatCount()); i++) {
            // 자동차 전진 기능
            for (int j = 0; j < stepsForward.length; j++) {
                int goAndStop = pickNumberInRange(0, 9);
                if (goAndStop >= 4) {
                    stepsForward[j]++;
                }
            }

            // 출력 기능
            for (int j = 0; j < stepsForward.length; j++) {
                String forwardsViewer = "";
                for (int k = 0; k < stepsForward[j]; k++) {
                    forwardsViewer += "-";
                }
                System.out.println(cars[j] + " : " + forwardsViewer);
            }
            System.out.println("");
        }

        // 우승 차량 선별 기능
        ArrayList<String> winningCars = new ArrayList<>();
        int max = Arrays.stream(stepsForward).max().orElse(0);
        for (int i = 0; i < stepsForward.length; i++) {
            if (stepsForward[i] == max) {
                winningCars.add(cars[i]);
            }
        }

        // 우승자 출력
        String result = String.join(", ", winningCars);
        System.out.println("최종 우승자 : " + result);
    }
}
