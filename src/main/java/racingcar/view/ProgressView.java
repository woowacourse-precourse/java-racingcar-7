package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class ProgressView {
    private static final String FIRST_PROGRESS_MESSAGE = "실행 결과\n";

    public void printFirstProgressMessage() {
        System.out.println(FIRST_PROGRESS_MESSAGE);
    }

    public void printProgressMessage(List<CarDto> CarDtoList) {
        for (CarDto carDto : CarDtoList) {
            String carName = carDto.name();
            System.out.print(carName + " : ");

            long position = carDto.position();
            printDashesByPosition(position);

            System.out.println();
        }
        System.out.println();
    }

    private void printDashesByPosition(long position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}
