package day1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class Trebuchet {

    private static HashMap<String, Integer> numberMap = new HashMap<>();
    public static void main(String[] args) throws Exception {
        numberMap.put("one", 1);
        List<String> inputLines = Files.readAllLines(Path.of("day1/input.txt"));
        int total = 0;
        for (String line : inputLines) {
            int firstNumber = -1;
            int secondNumber = -1;
            StringBuilder tempNumBuiler = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                if (Character.isDigit(currentChar)) {
                    // Part 1
                    if (firstNumber == -1) {
                        firstNumber = currentChar - '0';
                    } else {
                        int tempNum = currentChar - '0';
                        secondNumber = tempNum;
                    }
                    tempNumBuiler.setLength(0);
                } else {
                    // Part 2
                    tempNumBuiler.append(currentChar);
                    
                }
            }

            if (firstNumber == -1)
                continue;

            if (secondNumber == -1) {
                secondNumber = firstNumber;
            }

            total += firstNumber * 10 + secondNumber;
        }
        System.out.println(total);
    }
}