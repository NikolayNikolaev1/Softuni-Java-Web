package football.team.generator.models;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        boolean isPlayerInTeam = players.stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(playerName));

        if (!isPlayerInTeam) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        }

        this.players.removeIf(p -> p.getName().equalsIgnoreCase(playerName));
    }

    public double getRating() {
        return this.players
                .stream()
                .mapToDouble(Player::overallSkillLevel)
                .summaryStatistics()
                .getAverage();
    }
}
