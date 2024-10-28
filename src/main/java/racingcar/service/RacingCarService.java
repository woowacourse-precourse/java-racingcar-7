package racingcar.service;

import racingcar.domain.CarDTO;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


//자동차이름 5글자 이상인지 판단
//공백만 들어온 경우에 대한 예외처리
//,를 기준으로 앞 뒤에 공백은 지우고 중간 문자열 중간의 공백은 유지
public class RacingCarService {
    private RacingCarView view;


    public RacingCarService(RacingCarView view) {
        this.view = view;
    }


    // 자동차 이름을 입력받고 유효성을 검사하는 메서드
    public List<CarDTO> splitCarName() {

        String input = view.getInputCarName().getInput();
        List<CarDTO> carDTOList = new ArrayList<>();

        // 입력값이 공백이거나 null인 경우 예외 발생
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        // ','를 기준으로 문자열 분리
        String[] tokens = input.split(",");

        for (String token : tokens) {
            // 각 자동차 이름의 앞뒤 공백 제거
            String trimmedName = token.trim();

            // 자동차 이름이 5글자 이상인 경우 예외 발생
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 미만이어야 합니다. 잘못된 이름: " + trimmedName);
            }


            CarDTO carDTO = new CarDTO(trimmedName);
            carDTOList.add(carDTO);

        }
        return carDTOList;
    }

    // 한 라운드 진행
    private void playOneRound(List<CarDTO> cars) {
        for (CarDTO car : cars) {
            if (isCarMoveForward()) {
                car.moveForward();
            }
        }
    }

    //랜덤 값에 따라 전진
    private boolean isCarMoveForward() {
        int randomValue = pickNumberInRange(0, 9);
        return randomValue >= 4;
    }


    // 최종 우승자를 계산하는 메서드
    public List<String> determineWinners(List<CarDTO> cars) {
        int maxStraight = cars.stream()
                .max(Comparator.comparingInt(CarDTO::getGoStraight))
                .orElseThrow()
                .getGoStraight();

        return cars.stream()
                .filter(car -> car.getGoStraight() == maxStraight)
                .map(CarDTO::getCarName)
                .collect(Collectors.toList());
    }
}
