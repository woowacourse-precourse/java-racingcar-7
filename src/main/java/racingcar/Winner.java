package racingcar;

public class Winner {
    public static void printFinalWinner(Car[] cars) {
        StringBuilder finalWinner = new StringBuilder();
        int maxMove = findMaxMove(cars);
        for (Car car : cars) {
            if (maxMove == car.getMoveCount()) {
                finalWinner.append(car.getName()).append(", ");
            }
        }
        System.out.print(finalWinner.substring(0, finalWinner.length() - 2));
    }

    private static int findMaxMove(Car[] cars) {
        int maxMove = -1;
        for (Car car : cars) {
            if (maxMove < car.getMoveCount()) {
                maxMove = car.getMoveCount();
            }
        }

        return maxMove;
    }
}
