package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operationsCount = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        Deque<String> pastOperations = new ArrayDeque<>();

        for (int i = 0; i < operationsCount; i++) {
            String command = scanner.nextLine();
            String commandType = command.split(" ")[0];
            String commandArgument = "";

            switch (commandType) {
                // adds text
                case "1":
                    commandArgument = command.split(" ")[1];
                    sb.append(commandArgument);
                    // saves information about saved text
                    pastOperations.push("1-" + commandArgument);
                    break;
                // remove text
                case "2":
                    commandArgument = command.split(" ")[1];
                    String substringPart = sb.substring(sb.length() - Integer.parseInt(commandArgument), sb.length());
                    sb.delete(sb.length() - Integer.parseInt(commandArgument), sb.length());
                    //saves information about removed text // commandarg uselss.
                    pastOperations.push("2-" + commandArgument + "-" + substringPart);
                    break;
                // prints index
                case "3":
                    commandArgument = command.split(" ")[1];
                    System.out.println(sb.charAt(Integer.parseInt(commandArgument) - 1));
                    break;
                case "4":
                    // undoes past saved operation
                    String[] pastOperationArgs = pastOperations.pop().split("-");
                    String undoType = pastOperationArgs[0];
                    String undoArgs = pastOperationArgs[1];

                    switch (undoType) {
                        case "1":
                            sb.delete(sb.length() - undoArgs.length(), sb.length());
                            break;
                        case "2":
                            sb.append(pastOperationArgs[2]);
                            break;
                    }
                    break;
            }

        }
    }
}
