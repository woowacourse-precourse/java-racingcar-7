package racingcar.service;

import racingcar.domain.CarDTO;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class RacingCarService {
    private RacingCarView view;


    public RacingCarService(RacingCarView view) {
        this.view = view;
    }


    // 자동차 이름을 입력받고 유효성을 검사
    public List<CarDTO> splitCarName() {

        String input = view.getInputCarName().getInput();
        List<CarDTO> carDTOList = new ArrayList<>();

        // 입력값이 공백이거나 null인 경우 예외 발생
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        String[] tokens = input.split(",");

        for (String token : tokens) {

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


    // 최종 우승자를 선별
    public List<String> determineWinners(List<CarDTO> cars) {
        //최고값 추출
        int maxStraight = cars.stream()
                .max(Comparator.comparingInt(CarDTO::getGoStraight))
                .orElseThrow()
                .getGoStraight();
        //우승자 리스트 리턴
        return cars.stream()
                .filter(car -> car.getGoStraight() == maxStraight)
                .map(CarDTO::getCarName)
                .collect(Collectors.toList());
    }
}
