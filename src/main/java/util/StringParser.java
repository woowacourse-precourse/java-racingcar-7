package util;

public class StringParser {
    public static String[] parseString(String context, String parser){
        return context.split(parser);
    }
}
