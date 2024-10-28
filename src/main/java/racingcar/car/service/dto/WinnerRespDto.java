package racingcar.car.service.dto;

import racingcar.car.domain.Car;

public class WinnerRespDto {
    private String winner;

    public WinnerRespDto(String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }

    public static WinnerRespDto from(Car car) {
        return new WinnerRespDto(car.getName());
    }
}
