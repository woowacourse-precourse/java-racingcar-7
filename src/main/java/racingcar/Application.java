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

        // 경기 진행
//  - [x] 입력 받은 경주 자동차 이름 구분
        Map<String, Integer> cars = new LinkedHashMap<>();
        cars = Arrays.stream(carsName.split(",")).collect(Collectors.toMap(s -> s, s -> 0));
        System.out.println(cars);
//  - [ ] 자동차 이동 조건
//    - [ ] 전진 : 무작위 값이 4이상
//    - [ ] 정지 : 무작위 값이 4미만
//  - [ ] 우승자 조건 : 가장 많이 전진한 자동차(우승자는 2명 이상이 될 수 있다.)
    }
}
