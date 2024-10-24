package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
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
        int tryNumber = Integer.parseInt(Console.readLine());

        // 경기 진행
//  - [x] 입력 받은 경주 자동차 이름 구분
        Map<String, Integer> cars = new LinkedHashMap<>();
        cars = Arrays.stream(carsName.split(",")).collect(Collectors.toMap(s -> s, s -> 0));

//      입력 횟수만큼 경기 진행
        for (int i = 0; i < tryNumber; i++) {
//  - [ ] 자동차 이동 조건
//  - [x] 전진 : 무작위 값이 4이상
            for (String name : cars.keySet()) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) { // 랜덤값을 변수에 담는 게 좋을지
                    cars.put(name, cars.get(name) + 1);
                    System.out.println(cars.get(name));
                }
//  - [ ] 정지 : 무작위 값이 4미만
            }
        }

//        실행 결과 출력
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            System.out.print(car.getKey() + " : ");
            for (int i = 0; i < car.getValue(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }

//        자동차 이동 메서드

//  - [ ] 우승자 조건 : 가장 많이 전진한 자동차(우승자는 2명 이상이 될 수 있다.)
        List<String> winners = new ArrayList<>();
        int first = Collections.max(cars.values());

        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            if (car.getValue() == first) {
                winners.add(car.getKey());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}