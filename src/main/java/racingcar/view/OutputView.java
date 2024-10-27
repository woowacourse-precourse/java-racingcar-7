package racingcar.view;

import racingcar.model.dto.RacingResponseDTO;

public class OutputView {
    public void show(RacingResponseDTO racingResponseDTO) {
        System.out.println(racingResponseDTO.getRacingResult());
    }
}
