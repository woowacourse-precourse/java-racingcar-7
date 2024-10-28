package util;

public class StringParser {
    public static String[] stringParser(String context, String parser){
        return context.split(parser);
    }
}
