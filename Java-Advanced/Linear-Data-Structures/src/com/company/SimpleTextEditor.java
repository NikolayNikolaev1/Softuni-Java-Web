package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operationsCount = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        Deque<String> pastOperations = new ArrayDeque<>();

        for (int i = 0; i < operationsCount; i++) {
            String command = scanner.nextLine();
            String commandType = command.split(" ")[0];
            String commandArgument = "";

            switch (commandType) {
                case "1":
                     commandArgument = command.split(" ")[1];
                    sb.append(commandArgument);
                    pastOperations.push("1-" + commandArgument);
                    break;
                case "2":
                    commandArgument = command.split(" ")[1];
                    String substringPart = sb.substring(0, sb.length() - 1 - Integer.parseInt(commandArgument));
                    sb.delete(sb.length() - 1 -Integer.parseInt(commandArgument), sb.length() - 1);

                    pastOperations.push("2-" + commandArgument + "-" + substringPart);
                    break;
                case "3":
                    commandArgument = command.split(" ")[1];
                    System.out.print(sb.charAt(Integer.parseInt(commandArgument) - 1));
                case "4":
                    String[] pastOperationArgs = pastOperations.pop().split("-");
                    String undoType = pastOperationArgs[0];
                    String undoArgs = pastOperationArgs[1];

                    switch (undoType) {
                        case "1":
                            sb.delete(sb.length() - 1 - undoArgs.length(), sb.length() - 1);
                            break;
                        case "2":
                            sb.insert(Integer.parseInt(undoArgs), pastOperationArgs[2]);
                            break;
                    }
                    break;
            }

        }
    }
}
