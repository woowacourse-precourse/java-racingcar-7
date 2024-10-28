package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.vo.CarVO;

public class Application {
    public static void main(String[] args) {
        List<String> validateNames = getStrings();
        int validateMoveCnt = getValidateMoveCnt();
        List<CarVO> carVOList = getCarVOS(validateNames);
        extracted(validateMoveCnt, carVOList);
        List<String> collect = getStrings(carVOList);

        // 우승자 출력 메서드
        System.out.println("최종 우승자 : " + String.join(", ", collect));
    }

    /**
     * 1. 자동차 이름 입력 및 검증
     * - 쉼표로 구분된 자동차 이름 입력받기
     * - 5자 이하인지 검증하고 5자를 초과하는 경우 IllegalArgumentException을 발생
     * - 이름 리스트 반환
     */
    private static List<String> getStrings() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputNames = Console.readLine();
        List<String> validateNames = InputValidator.validateNames(inputNames);
        return validateNames;
    }

    /**
     * 2. 이동 횟수 입력 및 검증
     * - 이동 횟수 입력받기
     * - 입력 값이 숫자인지 검증하고 아닌 경우 IllegalArgumentException을 발생
     * - 이동 횟수 반환
     */
    private static int getValidateMoveCnt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputMoveCnt = Console.readLine();
        int validateMoveCnt = InputValidator.validateMoveCnt(inputMoveCnt);
        return validateMoveCnt;
    }

    /**
     * 3. 자동차 객체 생성
     * - 자동차 이름, 이동거리를 필드로 갖는 객체 생성
     * - 자동차 리스트 반환
     */
    private static List<CarVO> getCarVOS(List<String> validateNames) {
        List<CarVO> carVOList = new ArrayList<>();
        for (int i = 0; i < validateNames.size(); i++) {
            String trim = validateNames.get(i).trim();
            CarVO carVO = new CarVO(trim);
            carVOList.add(carVO);
        }
        return carVOList;
    }

    /**
     * 4. 자동차 이동 및 상태 출력
     * - 각 자동차 객체별로 무작위 값 생성
     * - 4 이상인 경우 이동거리 값 1 증가
     * - 매 이동 후 자동차의 현재 상태 출력
     * - 이동 횟수 만큼 반복
     */
    private static void extracted(int validateMoveCnt, List<CarVO> carVOList) {
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

    /**
     * 5. 우승자 결정 및 출력
     * - 이동 횟수만큼 반복 후, 이동거리가 가장 큰 자동차들을 결정
     * - 여러명일 경우 쉼표로 구분하여 출력
     */
    private static List<String> getStrings(List<CarVO> carVOList) {
        int maxPosition = carVOList.stream()
                .mapToInt(CarVO::getPosition)
                .max()
                .orElse(0);

        List<String> collect = carVOList.stream()
                .filter(carVO -> carVO.getPosition() == maxPosition)
                .map(CarVO::getCarName)
                .collect(Collectors.toList());
        return collect;
    }
}
