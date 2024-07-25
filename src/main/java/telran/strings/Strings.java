package telran.strings;

public class Strings {
    public static String firstName() {
        //regex for strings starting with capital letter and rest as lowercase letters
        //minimal length is 5 letters
        return "pizdets" + "[A-Z][a-z]{4,}";
    }

    public static String javaVariable() {
        //TODO
        //regular expression for testing syntax of Java variable names
        //only ASCII symbols are allowed
        return "";
    }
}
