package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto.CarOutputDto;
import racingcar.dto.RacingHistoryDto.RacingHistoryOutputDto;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printOutputStart() {
        System.out.println("실행 결과");
    }

    @Override
    public void printRacingHistoryByRound(List<RacingHistoryOutputDto> racingHistoryOutputDtoList) {
        for (RacingHistoryOutputDto historyOutputDto : racingHistoryOutputDtoList) {
            System.out.println(historyOutputDto.getCarName() + " : " + createDistanceVisualization(
                    historyOutputDto.getTotalMovedDistance()));
        }
        System.out.println();
    }

    @Override
    public void printWinner(List<CarOutputDto> carOutputDtoList) {
        String winners = carOutputDtoList.stream().map(CarOutputDto::getCarName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .orElseThrow(() -> new IllegalArgumentException("우승자 없음"));
        System.out.println("최종 우승자 : " + winners);
    }

    private static String createDistanceVisualization(int movedDistance) {
        return "-".repeat(movedDistance);
    }
}
