package utils;

import constant.Constant;

public class ContentParser {
    public static String[] parsingContentToGroup(String targetContent){
        String[] parsedGroup = splitting(targetContent);
        for(int i = 0; i < parsedGroup.length; i++){
            parsedGroup[i] = removingWhiteSpace(parsedGroup[i]);
        }
        return parsedGroup;
    }

    private static String[] splitting(String targetContent){
        return targetContent.split(Constant.CONTENT_PASRE_DELIMITER);
    }

    private static String removingWhiteSpace(String targetContent){
        return targetContent.strip();
    }
}
