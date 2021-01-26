package football.team.generator;

import football.team.generator.models.Player;
import football.team.generator.models.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String ADD_TEAM_COMMAND = "TEAM";
    private static final String ADD_PLAYER_COMMAND = "ADD";
    private static final String REMOVE_PLAYER_COMMAND = "REMOVE";
    private static final String RATING_COMMAND = "RATING";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) throws IOException {
        List<Team> teams = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] commandArgs = reader.readLine().split(";");

        while (!END_COMMAND.equalsIgnoreCase(runCommand(teams, commandArgs))) {
            commandArgs = reader.readLine().split(";");
        }

    }

    private static String runCommand(List<Team> teams, String... commandArgs) {
        String commandName = commandArgs[0];

        try {
            switch (commandName.toUpperCase()) {
                case ADD_TEAM_COMMAND:
                    addTeamCommand(teams, commandArgs);
                    return ADD_TEAM_COMMAND;
                case ADD_PLAYER_COMMAND:
                    addPlayerCommand(teams, commandArgs);
                    return ADD_PLAYER_COMMAND;
                case REMOVE_PLAYER_COMMAND:
                    removePlayerCommand(teams, commandArgs);
                    return REMOVE_PLAYER_COMMAND;
                case RATING_COMMAND:
                    ratingTeamCommand(teams, commandArgs);
                    return RATING_COMMAND;
                case END_COMMAND:
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return commandName.toUpperCase();
        }

        return END_COMMAND;
    }

    private static void addTeamCommand(List<Team> teams, String... teamArgs) {
        String name = teamArgs[1];
        Team team = new Team(name);
        teams.add(team);
    }

    private static void addPlayerCommand(List<Team> teams, String... playerArgs) {
        String teamName = playerArgs[1].trim();
        checkIfTeamExist(teams, teamName);

        String playerName = playerArgs[2].trim();
        int endurance = Integer.parseInt(playerArgs[3]);
        int sprint = Integer.parseInt(playerArgs[4]);
        int dribble = Integer.parseInt(playerArgs[5]);
        int passing = Integer.parseInt(playerArgs[6]);
        int shooting = Integer.parseInt(playerArgs[7]);
        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);

        teams.stream()
                .filter(t -> t.getName().equalsIgnoreCase(teamName))
                .forEach(t -> t.addPlayer(player));
    }

    private static void removePlayerCommand(List<Team> teams, String... playerArgs) {
        String teamName = playerArgs[1].trim();
        String playerName = playerArgs[2].trim();

        teams.stream()
                .filter(t -> t.getName().equalsIgnoreCase(teamName))
                .forEach(t -> t.removePlayer(playerName));
    }

    private static void ratingTeamCommand(List<Team> teams, String... teamArgs) {
        String name = teamArgs[1];

        checkIfTeamExist(teams, name);
        teams.forEach(t -> System.out.printf("%s - %d%s",
                t.getName(), Math.round(t.getRating()), System.lineSeparator()));
    }

    private static void checkIfTeamExist(List<Team> teams, String teamName) {
        boolean doesTeamExist = teams
                .stream()
                .anyMatch(t -> t.getName().equalsIgnoreCase(teamName));

        if (!doesTeamExist) {
            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
        }
    }
}
