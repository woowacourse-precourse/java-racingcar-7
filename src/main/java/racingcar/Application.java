package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

// 출력
//  - [x] 입력 안내 문자 출력 (경주 자동차 이름, 시도 횟수)
        System.out.println("경주할 자동차 이름을 입력하세요.");
        System.out.println("시도한 횟수는 몇 회인가요?");
        System.out.println("실행 결과");

// 입력
//  - [x] 경주 자동차 이름 입력 받기
//    [ ] (쉼표 기준으로 구분, 5자 이하 이름만 허용)
//  - [x] 시도 횟수 입력 받기
//    [ ] (시도 횟수는 양수만 허용)
        String carsName = Console.readLine();
        String tryNumber = Console.readLine();

    }
}
