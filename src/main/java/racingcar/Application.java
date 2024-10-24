package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 자동차 경주 게임을 진행하는 클래스
 * - ','를 기준으로 자동차 이름을 입력받음
 * 이름은 5자 이하만 가능
 * - 몇 회차까지 할 건지 입력받음
 * - 입력받은 횟수만큼 랜덤을 돌린다.
 * - 회차별로 실행결과를 출력한다.
 * ex) 실행 결과
 * pobi : -
 * woni : 
 * jun : -
 * 반복하여 입력받은 회차까지 실행한다.
 * - 최종 우승자를 출력한다.(이때 우승자는 한명 이상일 수 있다.)
 * 최종결과 작성 방식
 * ex) 최종 우승자 : pobi
 * ex) 최종 우승자 : pobi, jun
 */

public class Application {
    public static void main(String[] args) {
        // 스캐너 생성
        Scanner scanner = new Scanner(System.in);

        // 자동차 이름을 출력
        System.out.println("자동차들: ");
        String input = scanner.nextLine();

        // 자동차 이름을 ','를 기준으로 나누어 리스트에 저장
        List<String> carNames = List.of(input.split("\\s*,"));
        // for(int i = 0; i < carNames.length; i++) {
        //     System.out.println(test[i]);
        // }
        System.out.println(carNames);
        // 라운드 출력
        System.out.println("라운드: ");
        int round = scanner.nextInt();

        // 레이싱 게임 생성 및 플레이
        RacingGame racingGame = new RacingGame(carNames, round);
        racingGame.play();
    }
}

class Car {
    private String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이상이여만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
        
    }
}

class RacingGame {
    private List<Car> cars;
    private int round;

    public RacingGame(List<String> names, int round) {
        // stream은 names를 차례로 처리 -> "name1", "name2" ...
        // map은 Car 객체로 변환 -> Car("name1"), Car("name2") ...
        // collect는 List로 변환 -> [Car("name1"), Car("name2"), ...]
        // 최종적으로 this.cars에 리스트로 된 객체 Car들을 저장
        this.cars = names.stream().map(Car::new).collect(Collectors.toList());
        this.round = round;
    }

    public void play() {
        
    }
}