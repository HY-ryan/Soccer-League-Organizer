package com.teamtreehouse.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {
    protected String mTeamName;
    protected String mCoachName;
    private List<Player> mPlayers;

    public Team(String teamName, String coachName) {
        mTeamName = teamName;
        mCoachName = coachName;
        mPlayers = new ArrayList<Player>();
    }

    public String getTeamName() {
        return mTeamName;
    }

    public String getCoachName() {
        return mCoachName;
    }

    public List<Player> getPlayers() {
        return mPlayers;
    }

    public void addPlayer(Player player) {
        mPlayers.add(player);
    }

    public void removePlayer(int index) {
        mPlayers.remove(index);
    }

    public String getPlayersAsString() {
        String playersString = "Players on team: There are no players for this team yet";
        for (Player player : mPlayers) {
            if (player == mPlayers.get(0)) {
                playersString = "Players on team: " + player.getFirstName() + " " + player.getLastName();
            } else {
                playersString += ", " + player.getFirstName() + " " + player.getLastName();
            }
        }

        return playersString + "\n\n";
    }

    

    @Override
    public String toString() {
        return String.format("Team %s coatched by %s", mTeamName, mCoachName);
    }

}