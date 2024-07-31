package telran.strings;

import java.util.Arrays;

public class Strings {
    static final String keyWords[] = { "abstract", "assert", "boolean",
    "break", "byte", "case", "catch", "char", "class", "const",
    "continue", "default", "do", "double", "else", "enum", "extends", "false",
    "final", "finally", "float", "for", "goto", "if", "implements",
    "import", "instanceof", "int", "interface", "long", "native",
    "new", "null", "package", "private", "protected", "public",
    "return", "short", "static", "strictfp", "super", "switch",
    "synchronized", "this", "throw", "throws", "transient", "true",
    "try", "void", "volatile", "while" };

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

    public static String chisla() {
        return "[0-9]*";
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

    public static String number0_300() {
        return "[1-9]?\\d|[1-2]\\d\\d|300";
    }

    public static String ipV40ctet() {
        return "([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
    }

    public static String ipV4Adress() {
        String octetExpr = ipV40ctet();
        return String.format("%s(\\.%s){3}", octetExpr, octetExpr);
    }

    public static String stringWithJavaNames(String names) {
        String [] tokens = names.split("\\s+");
        int i = getJavaNameIndex(tokens, -1);
        String res = "";
        if (i >= 0) {
            res = tokens[i];
        }
        while((i = getJavaNameIndex(tokens, i)) > 0) {
            res += " " + tokens[i];
        }
        return res;
    }

    private static int getJavaNameIndex(String[] tokens, int i) {
        i++;
        while(i < tokens.length && !isJavaName(tokens[i])) {
            i++;
        }
        return i < tokens.length ? i : -1;
    }

    private static boolean isJavaName(String string) {
        return string.matches(javaVariable()) && Arrays.binarySearch(keyWords, string) < 0;
    }

    public static boolean isArithmeticExpression(String expr) {
        boolean res = true;
        boolean res2 = false;

        boolean res1 = brackets(expr);
        
        String[] expr1 = stringWithTokens(expr); 

        for(String c : expr1) {
           /*String regex = javaVariable() + chisla();
            if(!c.matches(regex)) {
                res2 = false;
                break;
            }*/
            String regex1 = javaVariable();
            String regex2 = chisla();
            if(c.matches(regex1) || c.matches(regex2)) {
                res2 = true; 
            }
        } 
         
        if(!res1 || !res2) {
            res = false;
        }

        return res;
    }

    public static String[] stringWithTokens(String names) {
        String[] tokens = names.split("[^A-Za-z0-9_$]+");
        return tokens;
    }

    public static boolean brackets(String names) {
        char[] stroka = names.toCharArray();
        int a = 0;
        boolean res = true;
        for(char c : stroka) {
            if (c == '(') {
                a++;
            }
            else if (c == ')') {
                a--;
                if (a < 0) {
                    res = false;
                    break;
                }
            }
        }
        if (a != 0) {
            res = false;
        }
        return res;
    }
}