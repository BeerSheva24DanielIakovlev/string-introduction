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
        return "^(?!_\\b)(?!.*\\b("+ ServiceWords() +")\\b)[A-Za-z_$][\\w_$]*$";
    }

    static final String ServiceWords() {
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

    public static String number0_300() {
        return "[1-9]?\\d|[1-2]\\d\\d|300";
    }

    public static String ipV40ctet() {
        return "^([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))$";
    }

    public static String ipV4Adress() {
        String octetExpr = ipV40ctet();
        return String.format("%s(\\.%s){3}", octetExpr, octetExpr);
    }

    public static String stringWithJavaNames(String names) {
        String [] tokens = names.split("\\s+");
        int i = getFirstJavaNameIndex(tokens, -1);
        String res = "";
        if (i >= 0) {
            res = tokens[i];
        }
        while((i = getJavaNameIndex(tokens, i)) > 0) {
            res += " " + tokens[i];
        }
        return res;
    }

    private static int getFirstJavaNameIndex(String[] tokens, int i) {
        i++;
        while(i < tokens.length && isJavaName(tokens[i])) {
            i++;
        }
        return i < tokens.length ? i : -1;
    }

    private static boolean isJavaName(String string) {
        return string.matches(javaVariable()) && Arrays.binarySearch(keyWords, string) < 0;
    }

    public static boolean isArithmeticExpression(String expr) {
        //TODO
        //1. brackets 
        //right position of open / close bracket is matter of regex
        //matching between open and close bracket is matter of the method you are supposed to write
        //based on a counter. If counter is negarive - no matching;
        //if at ending up going throw a string the counter doesn't equal 0 - no matching
        //matching may be only in one case: at the ending up of going the counter will be 0
        //only binary operations
        //Operator - regular expression for one out of 4 arithmetic operators [*/+-]
        //Operand May be either Java variable name or number (better any)
        //binary operator is delimiter between two 
        
        return false;
    }
}
