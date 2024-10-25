package racingcar;

import java.util.List;

public class OutputDisplayImpl implements IOutputDisplay {

    @Override
    public void print(String str) {
        System.out.print(str);
    }

    @Override
    public void printRoundResult(List<ICar> carList) {
        String positionExpression = "-";

        for (ICar car : carList) {
            String positionStr = positionExpression.repeat(car.getPosition());

            System.out.printf("%s : %s\n", car.getName(), positionStr);
        }
        System.out.println();
    }

    @Override
    public void printWinners(List<ICar> carList) {
        List<String> carNameList = carList.stream()
                .map(ICar::getName)
                .toList();

        String separator = ", ";
        System.out.printf("최종 우승자 : %s\n", String.join(separator, carNameList));
    }
}
