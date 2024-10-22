package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class RacingcarModel {

    private Map<String, String> car = new HashMap<>();

    // 자동차 이름 초기화 (입력받은 자동차 이름으로 빈 상태 초기화)
    public void initializeCars(String[] carNames) {
        System.out.println("자동차 이름 초기화 시작...");
        for (String name : carNames) {
            initializeCar(name);
        }
        System.out.println("자동차 이름 초기화 완료: " + car);
    }

    // 개별 자동차 초기화
    private void initializeCar(String carName) {
        car.put(carName, "");
        System.out.println("자동차 이름: " + carName + " 초기화 완료.");
    }

    // 현재 자동차 상태 반환 (차수별로 출력할 수 있는 형식으로 반환)
    public Map<String, String> getCarStates() {
        System.out.println("현재 자동차 상태 반환: " + car);
        return car;
    }

    // 랜덤 값 생성
    private int generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 자동차 전진 여부 확인 및 전진
    public void advanceCar(String carName) {
        int randomValue = generateRandomValue();
        System.out.println("자동차: " + carName + "의 랜덤 값: " + randomValue);
        if (shouldAdvance(randomValue)) {
            updateCarPosition(carName);
        } else {
            System.out.println("자동차: " + carName + " 멈춤 -> 현재 상태: " + car.get(carName));
        }
    }

    // 랜덤 값이 4 이상인지 확인하여 전진할지 여부를 결정
    private boolean shouldAdvance(int randomValue) {
        return randomValue >= 4;
    }

    // 자동차 전진 (자동차의 상태 업데이트)
    private void updateCarPosition(String carName) {
        car.put(carName, car.get(carName) + "-");
        System.out.println("자동차: " + carName + " 전진 -> 현재 상태: " + car.get(carName));
    }

    // 우승자 결정 (가장 긴 "-"를 가진 자동차 반환)
    public String getWinners() {
        int maxDistance = calculateMaxDistance();
        StringBuilder winners = new StringBuilder();

        System.out.println("우승자 계산 중...");
        for (Map.Entry<String, String> entry : car.entrySet()) {
            addIfWinner(entry, winners, maxDistance);
        }

        System.out.println("최종 우승자: " + winners);
        return winners.toString();
    }

    // 가장 많이 이동한 거리 계산
    private int calculateMaxDistance() {
        return car.values().stream().mapToInt(String::length).max().orElse(0);
    }

    // 우승자를 계산하여 StringBuilder에 추가
    private void addIfWinner(Map.Entry<String, String> entry, StringBuilder winners, int maxDistance) {
        System.out.println(entry.getKey() + "의 이동 거리: " + entry.getValue().length());
        if (entry.getValue().length() == maxDistance) {
            if (winners.length() > 0) {
                winners.append(", ");
            }
            winners.append(entry.getKey());
        }
    }
}
