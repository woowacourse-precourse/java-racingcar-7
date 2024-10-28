package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.WordsController;
import racingcar.view.InputView;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        // 1. 문자열 입력받기
        String words = InputView.inputWords();

        // 2. 문자열이 공백 또는 쉼표로 시작하는 경우, 또는 하나의 자동차만 있어
        // 자동차 경주 게임을 하는 의미가 없는 경우 IllegalArgumentException를 발생시킴
        if (!WordsController.isValid(words) | !WordsController.moreThanOne(words)) {
            throw new IllegalArgumentException();
        }

        // 3. 쉼표를 기준으로 경주할 자동차 이름을 분리
        List<String> carNames = List.of(words.split(","));

        // 4. 자동차 이름 시작과 끝이 공백인지 확인
        // 그렇다면 잘못된 값이므로 IllegalArgumentException를 발생시킴
        for (String carName : carNames) {
            if (carName.startsWith(" ") | carName.endsWith(" ")) {
                throw new IllegalArgumentException();
            }
        }

        // 5. 자동차 이름의 길이가 1 이상 5 이하이며
        // 한글 또는 영어대소문자 또는 숫자로 이루어져 있는지 확인
        // 아니라면 잘못된 값이므로 IllegalArgumentException를 발생시킴
        for (String carName : carNames) {
            if (!carName.matches("^[A-Za-z0-9가-힣]{1,5}$")) {
                System.out.println(carName);
                throw new IllegalArgumentException();
            }
        }

        // 6. 자동차 이름을 key, 전진한 거리를 value로 가지는 맵을 만듦
        // key는 중복을 허용하지 않으므로 이와 같은 특성을 활용해
        // 같은 이름이 2개 이상 존재하는지 확인
        HashMap<String, Integer> carPositions = new HashMap<>();

        for (String carName : carNames) {

            // 6-1. 만약 해당 자동차 이름을 key로 가진
            // value가 존재한다면 이전에 나왔던 이름이라는 것이므로
            // IllegalArgumentException를 발생시킴
            if (carPositions.containsKey(carName)) {
                throw new IllegalArgumentException();

            // 6-2. 아니라면 전진한 거리를 파악할 수 있도록
            // 전진한 거리를 0으로 초기값을 설정해 저장
            } else {
                carPositions.put(carName, 0);
            }
        }

        // 7. 시도할 횟수 입력받기
        int tryNumber = InputView.inputTryNumbers();

        // 8. 시도할 횟수가 자연수인지 확인
        if (tryNumber <= 0) {
            throw new IllegalArgumentException();
        }

        // 9. 자동차 게임 시작
        System.out.println("");
        System.out.println("실행 결과");

        for (int i = 0; i < tryNumber; i++) {
            for (String carName : carNames) {

                // 9-1. 시도할 횟수만큼 각 자동차마다 무작위 값을 구함
                int randomNumber = Randoms.pickNumberInRange(0, 9);

                // 9-2. 무작위 값이 4 이상일 경우 한 칸 앞으로 전진
                if (randomNumber >= 4) {
                    carPositions.put(carName, carPositions.get(carName)+1);
                }
            }

            // 9-3. 한 회가 마무리되면 차수별 실행 결과를 예시에 따라 출력
            for (String carName : carNames) {
                System.out.println(carName + " : " + "-".repeat(carPositions.get(carName)));
            }
            System.out.println("");
        }

        // 10. 가장 멀리 간 거리를 측정해 최종 우승자 선발
        List<String> winners = new ArrayList<>();
        int winnerPosition = Collections.max(carPositions.values());

        for (String carName : carNames) {
            if (carPositions.get(carName) == winnerPosition) {
                winners.add(carName);
            }
        }

        // 11. 최종 우승자의 수에 따라 예시에 맞게 출력
        String result = "최종 우승자 : ";
        if (winners.size() == 1) {
            result += winners.get(0);
        } else {
            result += String.join(", ", winners);
        }

        System.out.println(result);
    }
}