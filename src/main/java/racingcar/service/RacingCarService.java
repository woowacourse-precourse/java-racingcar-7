package racingcar.service;

import racingcar.domain.CarDTO;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private RacingCarView view;

    // RacingCarView를 생성자 주입으로 받음
    public RacingCarService(RacingCarView view) {
        this.view = view;
    }


    // 자동차 이름을 입력받고 유효성을 검사하는 메서드
    public List<CarDTO> splitCarName() {

        String input =  view.getInputCarName().getInput();
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

            // 유효한 자동차 이름을 DTO에 추가
            CarDTO carDTO = new CarDTO(trimmedName);
            carDTOList.add(carDTO);

        }
        return carDTOList;
    }

}
