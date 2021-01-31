package military.elite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Launcher {
    private static final String PRIVATE_COMMAND = "PRIVATE";
    private static final String LIEUTENANT_GENERAL_COMMAND = "LIEUTENANTGENERAL";
    private static final String ENGINEER_COMMAND = "ENGINEER";
    private static final String COMMANDO_COMMAND = "COMMANDO";
    private static final String SPY_COMMAND = "SPY";
    private static final String END_COMMAND = "END";

    private static final String EMPTY_STRING = "";

    private SoldierManager manager;

    public Launcher() {
        this.manager = new SoldierManager();
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = EMPTY_STRING;

        while (!END_COMMAND.equalsIgnoreCase(command = reader.readLine())) {
            String[] commandArgs = command.split("\\s+");
            this.executeCommand(commandArgs);
        }
    }

    private void executeCommand(String... commandArgs) {
        String commandName = commandArgs[0];

        switch (commandName.toUpperCase()) {
            case PRIVATE_COMMAND:
                this.privateCommand(commandArgs);
                break;
            case LIEUTENANT_GENERAL_COMMAND:
                this.lieutenantGeneralCommand(commandArgs);
                break;
        }

    }

    private void privateCommand(String... privateArgs) {
        int id = Integer.parseInt(privateArgs[1]);
        String firstName = privateArgs[2];
        String lastName = privateArgs[3];
        double salary = Double.parseDouble(privateArgs[4]);
        this.manager.createPrivate(id, firstName, lastName, salary);
    }

    private void lieutenantGeneralCommand(String... lieutenantGeneralArgs) {
        int id = Integer.parseInt(lieutenantGeneralArgs[1]);
        String firstName = lieutenantGeneralArgs[2];
        String lastName = lieutenantGeneralArgs[3];
        double salary = Double.parseDouble(lieutenantGeneralArgs[4]);
        List<Integer> privateIds = new ArrayList<>();

        for (int i = 5; i < lieutenantGeneralArgs.length; i++) {
            privateIds.add(Integer.parseInt(lieutenantGeneralArgs[i]));
        }

        this.manager.createLieutenantGeneral(id, firstName, lastName, salary, privateIds);
    }
}
