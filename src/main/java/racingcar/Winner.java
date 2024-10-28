package racingcar;

public class Winner {
    public void win(int[] arr,String[] strings){
        StringBuilder winners = new StringBuilder();
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                winners.setLength(0);
                winners.append(strings[i]);
            } else if (arr[i] == max) {
                winners.append(", ").append(strings[i]);
            }
        }
        for (int i = 0; i < strings.length; i++) {
            String score;
            if (arr[i] > 0) {
                score = String.valueOf(arr[i]);
            } else {
                score = "-";
            }
            System.out.print(strings[i] + " : " + score);
            if (i < strings.length) {
                System.out.print(", ");
            }
        }
        System.out.print("최종 우승자 : " + winners);
    }
}
