package com.teamtreehouse;

import com.teamtreehouse.model.Team;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Manager {

    private Map<String, String> mMenu;
    private BufferedReader mReader;
    private List<Team> mTeams;
    private Player[] players = Players.load();

    public Manager() {
        mMenu = new HashMap<String, String>();
        mReader = new BufferedReader(new InputStreamReader(System.in));
        mTeams = new ArrayList<Team>();


        mMenu.put("Create", "Create a new team");
        mMenu.put("Add", "Add players to a team");
        mMenu.put("Remove", "Remove a player from a team");
        mMenu.put("Report", "View a report of a team by height");
        mMenu.put("Balance", "View the league balance report");
        mMenu.put("Roster", "View the roster");
        mMenu.put("Quit", "Exit the program");

    }

    private String promptAction() throws IOException {
        System.out.printf("Menu%n%n");
        for (Map.Entry<String, String> option : mMenu.entrySet()) {
            System.out.printf("%s - %s %n",
                                option.getKey(),
                                option.getValue());
        }
        System.out.print("What do you want to do:  ");
        String choice = mReader.readLine();
        return choice.trim().toLowerCase();
    }

    public void run() {
        String choice = "";
        do {
            try {
                choice = promptAction();
                switch(choice) {
                    case "create":
                        makeNewTeam();
                        break;
                    case "add":
                        System.out.printf("Available Players:%n%n");
                        int count = 1;
                        for (Player player : players) {
                            String experience;
                            if (player.isPreviousExperience()) {
                                experience = "experienced";
                            } else {
                                experience = "inexperienced";
                            }
                            System.out.printf("%d.) %s %s (%d inches - %s)%n", count, player.getFirstName(), player.getLastName(), player.getHeightInInches(), experience);
                            count++;
                        }
                        break;
                    case "remove":
                        System.out.printf("You chose the remove players option!%n%n");
                        break;
                    case "report":
                        availableTeams();
                        break;
                    case "balance":
                        System.out.printf("You chose the balance option!%n%n");
                        break;
                    case "roster":
                        System.out.printf("You chose the roster option!%n%n");
                        break;
                    case "quit":
                        System.out.printf("Have a good season!%n%n");
                        break;
                    default:
                        System.out.printf("'%s' wasn't an option. please try again%n%n%n",
                                            choice);
                    }
                } catch(IOException ioe) {
                    System.out.println("Problem with input");
                    ioe.printStackTrace();
                }
            } while (!choice.equals("quit"));
        }


        public void makeNewTeam() throws IOException {
            System.out.print("What is the team name?  ");
            String teamName = mReader.readLine();
            System.out.print("What is the coach name?  ");
            String coachName = mReader.readLine();
            Team team = new Team(teamName, coachName);
            mTeams.add(team);
            System.out.printf("Team %s coached by %s added!%n%n", team.getTeamName(), team.getCoachName());

        }

        public void availableTeams() throws IOException {
            System.out.printf("------------------------%n");
            System.out.printf("Available Teams:  %n");
            int count = 1;
            for (Team team : mTeams) {
                System.out.printf(count + ".)  " + team + "%n");
                count++;
            }
            System.out.printf("------------------------%n");
            String choice = mReader.readLine();
            System.out.print(choice);
        }

}