package racingcar;

public class Winner {
    public void checkWinner(int[] racingResult, int[] winnerCount) {
        int maxValue = findMaxValue(racingResult);
        for (int i = 0; i < racingResult.length; i++) {
            if (maxValue == racingResult[i]) {
                winnerCount[i]++;
            }
        }
    }

    public void printFinalWinner(String[] carList, int[] winnerCount) {
        int maxValue = findMaxValue(winnerCount);
        for (int i = 0; i < winnerCount.length; i++) {
            if (maxValue == winnerCount[i]) {
                System.out.println(carList[i]);
            }
        }
    }

    private int findMaxValue(int[] racingResult) {
        int maxValue = -1;
        for (int i = 0; i < racingResult.length; i++) {
            if (maxValue < racingResult[i]){
                maxValue = racingResult[i];
            }
        }
        return maxValue;
    }
}
