package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;


public class RacingcarModel {

    private static final int ADVANCE = 4;

    private List<Car> cars = new ArrayList<>();

    // 자동차 이름 초기화 (입력받은 자동차 이름으로 빈 상태 초기화)
    public void initializeCars(String[] carNames) {
        System.out.println("자동차 이름 초기화 시작...");
        for (String name : carNames) {
            cars.add(new Car(name));
            System.out.println("자동차 이름 초기화 완료: " + cars);
        }

    }

    // 현재 자동차 상태 반환 (차수별로 출력할 수 있는 형식으로 반환)
    public List<Car> getCarStates() {
        return cars;
    }


    // 랜덤 값 생성
    private int generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 자동차 전진 여부 확인 및 전진
    public void advanceCar(Car car) {
        int randomValue = generateRandomValue();
        System.out.println("자동차: " + car + "의 랜덤 값: " + randomValue);
        if (shouldAdvance(randomValue)) {
            car.move();
        } else {
            System.out.println("자동차: " + car + " 멈춤 -> 현재 상태: " + car.getDistance());
        }
    }

    // 랜덤 값이 4 이상인지 확인하여 전진할지 여부를 결정
    private boolean shouldAdvance(int randomValue) {
        return randomValue >= ADVANCE;
    }

    // 자동차 전진 (자동차의 상태 업데이트)
    public void raceOneRound(){
        for(Car car: cars){
            advanceCar(car);
        }
    }

    // 우승자 결정 (가장 긴 "-"를 가진 자동차 반환)
    public String getWinners() {
        int maxDistance = calculateMaxDistance();
        StringBuilder winners = new StringBuilder();

        System.out.println("우승자 계산 중...");
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(car.getName());
            }
        }

            System.out.println("최종 우승자: " + winners);
            return winners.toString();
        }


    // 가장 많이 이동한 거리 계산
    private int calculateMaxDistance() {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(0);
    }


}
