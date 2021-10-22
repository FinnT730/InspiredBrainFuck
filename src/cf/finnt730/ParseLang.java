package cf.finnt730;

import java.util.concurrent.atomic.AtomicInteger;

public class ParseLang {



    public static KeyWords[] parse(String code) {
        AtomicInteger index = new AtomicInteger();
        KeyWords[] words = new KeyWords[10000];

        code.chars().forEach(c -> {
            switch ((char) c) {
                case '+' -> {
                    words[index.get()] = KeyWords.ADD;
                    index.getAndIncrement();
                    break;
                }
                case '-' -> {
                    words[index.get()] = KeyWords.SUB;
                    index.getAndIncrement();
                    break;
                }
                case '<' -> {
                    words[index.get()] = KeyWords.LAST;
                    index.getAndIncrement();
                    break;
                }
                case '>' -> {
                    words[index.get()] = KeyWords.NEXT;
                    index.getAndIncrement();
                    break;
                }
                case '*' -> {
                    words[index.get()] = KeyWords.MUL;
                    index.getAndIncrement();
                    break;
                }
                case '$' -> {
                    words[index.get()] = KeyWords.PRINT;
                    index.getAndIncrement();
                    break;
                }
                default -> {
                }
            }
        });

        return words;
    }


}
