package racingcar.view;

import java.util.List;
import racingcar.dto.RoundSnapshotDto;
import racingcar.dto.RoundSnapshotDto.CarSnapshotDto;
import racingcar.dto.WinnersDto;

public class OutputView {
    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void displayWinners(WinnersDto winnersDto) {
        System.out.print("최종 우승자 : ");

        List<String> nameOfWinners = winnersDto.nameOfWinners();

        if (nameOfWinners.size() == 1) {
            System.out.println(nameOfWinners.getFirst());
            return;
        }

        String winners = String.join(", ", nameOfWinners);
        System.out.println(winners);
    }

    public void displayRoundSnapshots(List<RoundSnapshotDto> roundSnapshotDtos) {

        System.out.println("실행 결과");

        for (RoundSnapshotDto roundSnapshotDto : roundSnapshotDtos) {
            roundSnapshotDto.getCarSnapshotDtos().forEach(this::displayCarSnapshots);
            System.out.println();
        }

    }

    private void displayCarSnapshots(CarSnapshotDto carSnapshotDto) {
        String name = carSnapshotDto.name();
        int position = carSnapshotDto.position();

        String result = name + " : " + "-".repeat(position);
        System.out.println(result);
    }
}