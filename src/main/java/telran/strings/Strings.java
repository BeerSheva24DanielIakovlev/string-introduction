package telran.strings;

public class Strings {
    public static String firstName() {
        //regex for strings starting with capital letter and rest as lowercase letters
        //minimal length is 5 letters
        return "[A-Z][a-z]{4,}";
    }

    public static String javaVariable() {
        //regular expression for testing syntax of Java variable names
        //only ASCII symbols are allowed 
        
        return "^(?!.*\\b("+ ServiceWords() +")\\b)[A-Za-z_$][A-Za-z0-9_$]*$";
    }

    public static String ServiceWords() {
        String serviceWords = "";
        String[] service_words = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
        "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
        "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "null", "package", "private", "protected",
        "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
        "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false"};
        for (int i = 0; i < service_words.length - 1; i++) {
            serviceWords += service_words[i] + "|";       
        }
        
        serviceWords += service_words[service_words.length - 1];
        
        return serviceWords;
    }
}
