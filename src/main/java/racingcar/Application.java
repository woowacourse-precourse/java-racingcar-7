package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        // 1. 문자열 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String words = Console.readLine();

        // 2. 문자열의 시작과 끝이 공백이거나 쉼표인지 확인
        // 그렇다면 잘못된 값이므로 IllegalArgumentException를 발생시킴
        if (words.startsWith(" ") | words.startsWith(",") | words.endsWith(" ") | words.endsWith(",")) {
            throw new IllegalArgumentException();
        }

        // 3. 문자열에 쉼표가 있는지 확인
        // 3-1. 쉼표가 없다면 하나의 자동차만 있는 것이므로 우승자가 정해져 있고
        // 전진하지 않아도 우승을 하므로 자동차 경주 게임을 하는 의미가 없음
        // 따라서 잘못된 값을 입력했다고 판단하고 IllegalArgumentException를 발생시킴
        if (!words.contains(",")) {
            throw new IllegalArgumentException();
        }

        // 3-2. 쉼표가 있다면 쉼표를 기준으로 경주할 자동차 이름을 분리
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
        // 입력받은 시도할 횟수가 정수 형태가 아닐 경우
        // NumberFormatException가 발생하는 것을 이용해
        // 이에 해당할 경우 IllegalArgumentException를 발생시킴
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNumber;
        try {
            tryNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}