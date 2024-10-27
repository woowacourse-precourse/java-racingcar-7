package racingcar.view;

import java.util.List;
import racingcar.dto.CarPositionDTO;

public class OutputView {
    private static OutputView instance;

    private OutputView() {
    }

    // 자동차들의 이름, 위치 출력
    public void printCarPositions(List<CarPositionDTO> carPositionDTOList) {
        StringBuilder output = new StringBuilder();

        for (CarPositionDTO carPositionDTO : carPositionDTOList) {
            output.append(getPositionString(carPositionDTO));
        }

        output.append("\n");

        System.out.println(output);
    }

    public void printWinnerName(final List<String> winnerList) {
        StringBuilder output = new StringBuilder().append("최종 우승자 : ");

        output.append(winnerList.get(0));
        for (int i = 1; i < winnerList.size(); i++) {
            output.append(", ").append(winnerList.get(i));
        }

        System.out.println(output);
    }

    public void println(String content) {
        System.out.println(content);
    }

    public static synchronized OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }

        return instance;
    }

    // 현재 자동차의 이름, 위치를 출력 형태에 맞춰 문자열로 변환
    private static StringBuilder getPositionString(CarPositionDTO carPositionDTO) {
        StringBuilder output = new StringBuilder();

        output.append(carPositionDTO.getName() + " : ");

        for (int i = 0; i < carPositionDTO.getPosition(); i++) {
            output.append("-");
        }

        output.append("\n");

        return output;
    }
}
