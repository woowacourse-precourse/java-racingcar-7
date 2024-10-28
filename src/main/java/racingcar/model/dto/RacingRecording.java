package racingcar.model.dto;

import java.util.List;

/** 자동차 주행 과정과 결과 정보를 담아 전달하는 DTO */
public record RacingRecording(List<String> result) {

    @Override
    public String toString() {
        return String.join("\n", result);
    }

}
