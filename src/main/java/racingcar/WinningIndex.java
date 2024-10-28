package racingcar;

import java.util.ArrayList;

public class WinningIndex {

    public int[] processingResult(String[] stringList){
        int[] stringLength=lengthList(stringList);
        int[] resultList = winnigIndex(stringLength);
        return resultList;
    }

    private int[] lengthList(String[] stringList){
        int[] stringLength = new int[stringList.length];
        for(int i=0;i<stringList.length;i++){
            stringLength[i]=stringList[i].length();
        }
        return stringLength;
    }

    private int[] winnigIndex(int[] lnegthList){
        ArrayList<Integer> index = new ArrayList<>();
        index.add(0);
        int comparer = lnegthList[0];
        for (int i=1;i< lnegthList.length;i++){
            if (comparer==lnegthList[i]){
                index.add(i);
            }
            else if (comparer<lnegthList[i]) {
                index = new ArrayList<>();
                index.add(i);
                comparer= lnegthList[i];
            }
        }

        int[] resultList = new int[index.size()];
        for (int i = 0; i < index.size(); i++)
            resultList[i] = index.get(i).intValue();

        return resultList;
    }
}
