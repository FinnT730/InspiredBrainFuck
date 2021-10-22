package cf.finnt730;

public class Main {

    private static final int[] mem = new int[100];
    private static long _ptr = 0;
    private static int accumulator = 0;

    public static void main(String[] args) {
//        KeyWords[] code = {
//                KeyWords.ADD,KeyWords.ADD,KeyWords.ADD,KeyWords.PRINT,KeyWords.NEXT
//        };

        KeyWords[] code = ParseLang.parse("++$>++++*$");


        try {
            for (KeyWords word : code) {
                switch (word) {
                    case ADD -> {
                        if ((int) _ptr > mem.length) {
                            new Throwable("_ptr is bigger then the the size of mem");
                            break;
                        } else {
                            mem[Math.toIntExact(_ptr)] = ++accumulator;
                        }
                        break;
                    }
                    case SUB -> {
                        if ((int) _ptr > mem.length) {
                            new Throwable("_ptr is bigger then the the size of mem");
                            break;
                        } else {
                            mem[Math.toIntExact(_ptr)] = --accumulator;
                        }
                        break;
                    }
                    case MUL -> {
                        if ((int) _ptr > mem.length) {
                            new Throwable("_ptr is bigger then the the size of mem");
                            break;
                        } else {
                            mem[Math.toIntExact(_ptr)] *= accumulator;
                        }
                        break;
                    }
                    case NEXT -> {
                        if (((int) _ptr + 1) > mem.length) {
                            new Throwable("_ptr + 1 is bigger then the the size of mem");
                            break;
                        } else {
                            _ptr++;
                            accumulator = 0;
                        }
                        break;
                    }
                    case LAST -> {
                        if (((int) _ptr - 1) > 0) {
                            new Throwable("_ptr -1  is smaller then the the size of mem");
                            break;
                        } else {
                            _ptr--;
                            accumulator = 0;
                        }
                        break;
                    }
                    case PRINT -> {
                        if ((int) _ptr > mem.length) {
                            new Throwable("_ptr is bigger then the the size of mem");
                            break;
                        } else {
                            System.out.printf("Value = %o", mem[(int) _ptr]).println();
                        }
                        break;
                    }
                    default -> {
                    }
                }
            }
        } catch (Exception e) {

        }


        for (int i : mem) {
            if(i == 0) {
                continue;
            } else {
                System.out.printf("DEBUG: value: %o \t _ptr: %o\n", i, _ptr);
            }
        }
        System.out.printf("_ptr = %o", _ptr).println();

        System.out.println("SourceCode: ");
        for(KeyWords word : code) {
            System.out.printf("%s\t", word.toString());
        }

    }

}
