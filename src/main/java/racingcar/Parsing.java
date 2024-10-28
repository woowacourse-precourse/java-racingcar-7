package racingcar;

import static constants.ExceptionConstants.IS_NULL;
import static constants.ExceptionConstants.NOT_INTEGER;
import static constants.ExceptionConstants.STRING_LEN_OVER ;


public class Parsing implements StringContorl{

    @Override
    public String[] spliteStr(String readData){
        //String Check
        String[] str = readData.split(",");

        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > 5)  throw new IllegalArgumentException(STRING_LEN_OVER.getMessage());
            if (str[i].isEmpty())     throw new IllegalArgumentException(IS_NULL.getMessage());
        }

        return str;
    }

    @Override
    public int strToInt(String str){
        if(str.isEmpty()) throw new IllegalArgumentException(IS_NULL.getMessage());
        if( !str.matches("\\d+") ) throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        return Integer.parseInt(str);

    }
    @Override
    public String countToDash(int moveCount){
        StringBuilder dash = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            dash.append("-");
        }
        return dash.toString();
    }
}
