package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringProcessor {

    private final static String COMMA = ",";
    private final static String SPACE = " ";
    private final static int ONE = 1;

    public static String[] process(String input){

        String[] tokens = split(input);

        return Arrays.stream(tokens)
            .map(StringProcessor::trim)
            .toArray(String[]::new);
    }

    public static String formatWinner(List<String> winners){
        if(checkIfSingleWinner(winners)){
            return getFirstWinner(winners);
        }

        StringBuilder formattedWinnerString = new StringBuilder();
        formattedWinnerString.append(getFirstWinner(winners));
        for(int i = 1; i<winners.size(); i++){
            String currentWinner = winners.get(i);
            formattedWinnerString.append(formatSecondOrMoreWinner(currentWinner));
        }

        return formattedWinnerString.toString();
    }

    private static String getFirstWinner(List<String> winners){
        return winners.get(0);
    }


    private static String formatSecondOrMoreWinner(String winner){
        return COMMA + SPACE + winner;
    }

    private static boolean checkIfSingleWinner(List<String> winner){
        return winner.size() == ONE;
    }

    private static String trim(String input){
        return input.trim();
    }

    private static String[] split(String input){
        return input.split(COMMA);
    }
}
