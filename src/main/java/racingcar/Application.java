package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.vo.CarVO;

public class Application {
    public static void main(String[] args) {
        /**
         * 1. 자동차 이름 입력 및 검증
         *   - 쉼표로 구분된 자동차 이름 입력받기
         *   - 5자 이하인지 검증하고 5자를 초과하는 경우 IllegalArgumentException을 발생
         *   - 이름 리스트 반환
         * */
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputNames = Console.readLine();
        List<String> validateNames = InputValidator.validateNames(inputNames);

        /**
         * 2. 이동 횟수 입력 및 검증
         *    - 이동 횟수 입력받기
         *    - 입력 값이 숫자인지 검증하고 아닌 경우 IllegalArgumentException을 발생
         *    - 이동 횟수 반환
         * */
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputMoveCnt = Console.readLine();
        int validateMoveCnt = InputValidator.validateMoveCnt(inputMoveCnt);

        /**
         * 3. 자동차 객체 생성
         *    - 자동차 이름, 이동거리를 필드로 갖는 객체 생성
         *    - 자동차 리스트 반환
         */
        List<CarVO> carVOList = new ArrayList<>();
        for (int i = 0; i < validateNames.size(); i++) {
            String trim = validateNames.get(i).trim();
            CarVO carVO = new CarVO(trim);
            carVOList.add(carVO);
        }

        /**
         * 4. 자동차 이동 및 상태 출력
         *    - 각 자동차 객체별로 무작위 값 생성
         *    - 4 이상인 경우 이동거리 값 1 증가
         *    - 매 이동 후 자동차의 현재 상태 출력
         *    - 이동 횟수 만큼 반복
         */
        for (int i = 0; i < validateMoveCnt; i++) {
            for (CarVO carVO : carVOList) {
                carVO.move();
            }
            // 이동 후 각 자동차의 상태를 출력
            System.out.println("실행 결과");
            for (CarVO carVO : carVOList) {
                System.out.println(carVO.getCurrentState());
            }
            System.out.println();
        }
    }
}
