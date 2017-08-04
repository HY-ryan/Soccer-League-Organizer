package com.teamtreehouse.model;

import java.util.ArrayList;
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

    public void addPlayer(Player player) {
        mPlayers.add(player);
    }

    @Override
    public String toString() {
        return String.format("Team %s coatched by %s", mTeamName, mCoachName);
    }

}