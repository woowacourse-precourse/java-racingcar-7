package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"); // 프로그램 시작
        List<String> carNames = getCarNames(); // 1번 기능: 자동차 이름 입력 및 검증
        System.out.println("입력된 자동차 이름: " + carNames); // 입력된 자동차 이름 출력 (디버깅 용도)
        // 이후 기능 구현 예정
    }
     /**
     * 사용자로부터 자동차 이름을 입력받고 유효성을 검사하는 메서드
     * @return 유효성 검사를 통과한 자동차 이름 목록
     */
    private static List<String> getCarNames() {
        String input = Console.readLine(); // 자동차 이름 입력
        String[] names = input.split(","); // 쉼표를 기준으로 이름 분리
        
        List<String> carNames = new ArrayList<>(); // 유효성 검사
        for (String name : names) {
            name = name.trim();  // 이름 앞뒤 공백 제거
            
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 빈 값이거나 5자를 초과할 수 없습니다: " + name); // 이름이 빈 값이거나 5자를 초과할 경우 예외 발생
            }
            
            carNames.add(name);
        }
        
        return carNames;
    }
}
