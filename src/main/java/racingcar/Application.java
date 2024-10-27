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
    }
}