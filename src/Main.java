package ru.iteco;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = false;
        while (flag != true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String title = scanner.nextLine();
                Number.CheckNumber(title);
                Repeat.CheckRepeat(title);
                System.out.println("Строка подходит!");
                flag = true;
            } catch (RepeatException ex) {
                System.out.println(ex.getMessage());

                System.out.println(ex.getName());
            } catch (NumberException e) {
                System.out.println(e.getMessage());

                System.out.println(e.getNumber());
            }
        }

    }

    static class RepeatException extends Exception {
        private char name;

        public char getName() {
            return name;
        }

        public RepeatException(String str, char letter) {
            super(str);
            name = letter;

        }
    }

    static class Repeat {
        public static void CheckRepeat(String s) throws RepeatException {

            int k = 1;
            char r1;
            char r2;

            for (int i = 0; i < (s.length() - 1); i++) {
                r1 = s.charAt(i);
                r2 = s.charAt(i + 1);
                if (r1 == r2) {
                    k = k + 1;
                    if (k >= 3) {
                        throw new RepeatException("Ошибка и буква ", r2);
                    }
                }
                }
            }
        }

        ///
        static class NumberException extends Exception {
            private char num;

            public char getNumber() {
                return num;
            }

            public NumberException(String messag, char number) {
                super(messag);
                num = number;

            }
        }

        static class Number {
            public static void CheckNumber(String s) throws NumberException {

                for (int i = 0; i < (s.length()); i++) {
                    if (Character.isDigit(s.charAt(i))) {
                        throw new NumberException("Ошибка и цифра ", s.charAt(i));
                    }
                }


            }
        }
    }


