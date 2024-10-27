package racingcar.repository;

import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static racingcar.view.CommonMessage.ERROR_MESSAGE_PREFIX;

/**
 * CarRepository 클래스는 차량 목록을 관리하고, 각 차량의 이동 결과를 처리하는 역할을 한다.
 */
public class CarRepository {

    private static final List<Car> cars = new ArrayList<>();   // 모든 차량 객체를 저장하는 리스트

    /**
     * 입력된 이름 리스트로 차량 객체들을 생성하여 저장한다.
     * - 유효성 검사: 리스트가 비어 있지 않은지, 중복된 이름이 없는지 확인
     */
    public static void makeCars(List<String> carsNames) {
        validateNotEmpty(carsNames);   // 리스트가 비어 있지 않은지 확인
        validateOverlappedName(carsNames);   // 중복된 이름이 없는지 확인
        carsNames.forEach(carName -> cars.add(new Car(carName)));   // 이름 리스트로 차량 생성
    }

    /**
     * 각 차량을 이동시키고, 이동 결과를 맵으로 반환한다.
     * - 키: 차량 이름, 값: 이동 거리
     */
    public static Map<String, Integer> move(NumberGenerator numberGenerator) {
        Map<String, Integer> moveResults = new LinkedHashMap<>();   // 이동 결과 저장 맵
        cars.forEach(car ->
                moveResults.put(car.getName(), car.movePosition(numberGenerator.generate()))
        );   // 각 차량에 대해 난수 생성 후 이동 결과 저장
        return moveResults;
    }

    /**
     * 이동 거리가 가장 긴 차량(우승자)을 반환한다.
     * - 여러 차량이 공동 1위일 경우, 모두 우승자로 포함한다.
     */
    public static List<String> getWinners() {
        List<String> winners = new ArrayList<>();   // 우승자 목록 저장 리스트
        for (Car targetCar : cars) {
            long count = cars.stream().filter(targetCar::lessMoveThan).count();   // 각 차량과 거리 비교
            if (count == 0) {   // 이동 거리가 최대일 경우에만 우승자로 추가
                winners.add(targetCar.getName());
            }
        }
        return winners;
    }

    /**
     * 이름 리스트가 비어 있을 때 예외를 발생시킨다.
     */
    private static void validateNotEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "아무것도 입력하지 않았습니다.");
        }
    }

    /**
     * 중복된 이름이 존재할 경우 예외를 발생시킨다.
     */
    private static void validateOverlappedName(List<String> names) {
        long distinctNamesCount = names.stream()
                .distinct()
                .count();   // 중복 없이 집계한 이름의 개수
        if (distinctNamesCount != names.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "중복된 자동차 이름이 있습니다.");
        }
    }
}
