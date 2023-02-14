package ui;

import model.*;
import exceptions.InvalidNumberOfHealthPointsException;
import exceptions.InvalidTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static model.MonsterType.*;

// Monstermon application
public class MonstermonApp {
    private Scanner input;
    private List<Monster> allMonsters;
    private List<Team> allTeams;

    // The following colors are from: https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIescapecodes.html
    private final String colorReset = "\u001b[0m";
    private final String colorPink = "\u001B[35m";
    private final String colorRed = "\033[0;31m";
    private final String colorYellow = "\u001b[33m";


    // EFFECTS: runs the monstermon application
    public MonstermonApp() {
        try {
            runMonstermon();
        } catch (Exception e) {
            System.out.println(colorRed + "It seems that something went wrong! "
                    + "We have taken you back to the main menu!" + colorReset);
            displayMenu();
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runMonstermon() {
        String command;

        init();

        playIntro();
        while (true) {
            displayMenu();
            command = input.nextLine();
            command = command.toLowerCase();

            if (command.equals("/quit")) {
                System.out.println("We hope you had a great adventure today. Goodbye!");
                break;
            }

            processCommand(command);
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes allTeams, allMonsters and creates an object to obtain user input from console
    private void init() {
        allTeams = new ArrayList<>();
        allMonsters = new ArrayList<>();
        input = new Scanner(System.in);
    }

    // EFFECTS: displays the intro to user
    private void playIntro() {
        // IDEA: can have background music playing. This would be done by calling another method in order to stick to
        //       the 25 line limit per method. playBackgroundMusic();

        // IDEA: can have the user enter some details about themselves that are used to greet them
        //       every time the app is opened. Not sure how I would do this though.

        System.out.println(colorYellow + "Greetings! It's a pleasure to make your acquaintance.");
        System.out.println("Welcome to the captivating realm of Monstermon, where humans and creatures known as "
                + "Monstermon coexist as friends.");
        System.out.println("I am Mahogany, but you may call me the Monstermon Professor.");
        System.out.println("In this world, some people engage in battles with their Monstermon to strengthen their"
                + " bond, while others simply play and work together.");
        System.out.println("It's time for your own epic adventure to commence.");
        System.out.println("As you embark on your journey, be prepared to encounter a diverse array of Monstermon "
                + "and to uncover mysteries and secrets along the way.");
        System.out.println("So, without further ado, dive into the world of Monstermon and let the adventure begin!"
                + colorReset);
        System.out.println("\n\n");
    }

    // EFFECTS: displays the menu of options to user
    private void displayMenu() {
        System.out.println("Choose an option: \t[If you haven't already, please take a look at the rules before you"
                + " begin!]");
        System.out.println("/rules -> Rules");
        System.out.println("/newmonster -> Create New Monster");
        System.out.println("/getstats -> Get Monster's Characteristics");
        System.out.println("/newteam -> Create New Team");
        System.out.println("/addmonster -> Add Monster to a Team");
        System.out.println("/removemonster -> Remove Monster from a Team");
        System.out.println("/renamemonster -> Rename Monster");
        System.out.println("/renameteam -> Rename Team");
        System.out.println("/viewteams -> View all Teams");
        System.out.println("/viewmonsters -> View all Monsters");
        System.out.println("/clearmonsters -> Clear all Monsters");
        System.out.println("/clearteams -> Clear all Teams");
        System.out.println("/quit -> Quit\n");
    }

    // EFFECTS: displays the rules to user
    private void displayRules() {
        System.out.println("Thank you for taking the time to look at the rules of Monstermon!");
        System.out.println("The first step in playing Monstermon is to create a monster.");
        System.out.println("In order to create a monster, you must decide its name, type and number of health points!");
        System.out.println("A monster can be of one of three types: Fire, Water and Grass. "
                + "\t\t\t[alpha: more types coming soon!]");
        System.out.println("Your monster must have a minimum of 1 health point, and a maximum of 400."
                + "\t[alpha: attack, defense and speed coming soon!]");
        System.out.println("That's about it! Now, go on and leap into the world of Monstermon!\n");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("/rules")) {
            displayRules();
        } else if (command.equals("/newmonster")) {
            createMonster();
        } else if (command.equals("/addmonster")) {
            addMonsterToTeam();
        } else if (command.equals("/removemonster")) {
            removeMonsterFromTeam();
        } else if (command.equals("/renamemonster")) {
            renameMonster();
        } else if (command.equals("/renameteam")) {
            renameTeam();
        } else if (command.equals("/viewmonsters")) {
            viewAllMonsters();
        } else if (command.equals("/viewteams")) {
            viewAllTeams();
        } else if (command.equals("/newteam")) {
            createTeam();
        } else if (command.equals("/getstats")) {
            getMonsterCharacteristics();
        } else {
            processMoreCommands(command);
        }
    }

    // MODIFIES: this
    // EFFECTS: processes more user commands
    private void processMoreCommands(String command) {
        if (command.equals("/clearmonsters")) {
            clearAllMonsters();
        } else if (command.equals("/clearteams")) {
            clearAllTeams();
        } else {
            System.out.println("Invalid input\n");
        }
    }

    // EFFECTS: displays all monsters that have been made, if none have been made, tells user that none have been made
    private void viewAllMonsters() {
        if (allMonsters.size() == 0) {
            System.out.println("You have not created any monsters yet!");
        } else {
            System.out.println("All your cherished monsters in one place!");
            printMonsters();
        }
        System.out.println();
    }

    // EFFECTS: displays all teams that have been made, if none have been made, tells user that none have been made
    private void viewAllTeams() {
        if (allTeams.size() == 0) {
            System.out.println("You have not created any teams yet!");
        } else {
            System.out.println("All your fabulous teams in one place!");
            printTeams();
        }
        System.out.println();
    }

    // EFFECTS: displays all monsters that have been made
    private void printMonsters() {
        System.out.print("[");
        for (Monster m : allMonsters) {
            if (allMonsters.indexOf(m) == allMonsters.size() - 1) {
                System.out.print(m.getName());
            } else {
                System.out.print(m.getName() + ", ");
            }
        }
        System.out.println("]");
    }

    // EFFECTS: displays all teams that have been made
    private void printTeams() {
        for (Team t : allTeams) {
            System.out.print(t.getTeamName() + ": [");
            printMonstersInTeam(t);
            System.out.println("]");
        }
    }

    // EFFECTS: displays all the monsters in the given team
    private void printMonstersInTeam(Team t) {
        for (Monster m : t.getAllMonsters()) {
            List<Monster> allMonstersInTeam = t.getAllMonsters();
            if (allMonstersInTeam.indexOf(m) == allMonstersInTeam.size() - 1) {
                System.out.print(m.getName());
            } else {
                System.out.print(m.getName() + ", ");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: prints all teams available, renames a particular team. If no team of the inputted name is made,
    //          prints that the team doesn't exist
    private void renameTeam() {
        System.out.println("Which team would you like to rename?");
        viewAllTeams();
        if (allTeams.size() == 0) {
            createTeam();
            viewAllTeams();
            System.out.println("Which team would you like to rename?");
        }
        String teamName = input.nextLine();
        System.out.println("What would you like to rename " + teamName + " to?");
        String newName = input.nextLine();
        for (Team t : allTeams) {
            if (t.getTeamName().equals(teamName)) {
                t.renameTeam(newName);
                System.out.println("Team successfully renamed!");
                return;
            }
            return;
        }
        System.out.println("That team doesn't exist!");
        System.out.println();
    }

    // MODIFIES: this
    // EFFECTS: prints all monsters available, renames a particular monster. If no monster of the inputted name is made,
    //          prints that the monster doesn't exist
    private void renameMonster() {
        System.out.println("Which monster would you like to rename?");
        viewAllMonsters();
        if (allMonsters.size() == 0) {
            createMonster();
            viewAllMonsters();
            System.out.println("Which monster would you like to rename?");
        }
        String monsterName = input.nextLine();
        System.out.println("What would you like to rename " + monsterName + " to?");
        String newName = input.nextLine();
        for (Monster m : allMonsters) {
            if (m.getName().equals(monsterName)) {
                m.renameMonster(newName);
                System.out.println("Successfully renamed!");
                return;
            }
            return;
        }
        System.out.println("That monster doesn't exist!");
        System.out.println();
    }

    // MODIFIES: this
    // EFFECTS: gets a monster to remove, if no monsters exist, redirects user to create a monster
    private Monster getParticularMonsterToRemove() {
        checkMonstersNotEmpty();
        System.out.println("What is the name of the monster to remove?");
        viewAllMonsters();
        String monsterName = input.nextLine();
        return findMonster(monsterName);
    }

    // MODIFIES: this
    // EFFECTS: gets a particular team that a monster is attempted to be removed from
    private Team getParticularTeam() {
        checkAtLeastOneTeamExists();
        System.out.println("What is the name of the team to remove the monster from?");
        viewAllTeams();
        String teamName = input.nextLine();
        return findTeam(teamName, "removeTeam");
    }

    // MODIFIES: this
    // EFFECTS: gets the team that the monster is attempted to be added to
    private Team getTeam() {
        checkAtLeastOneTeamExists();
        System.out.println("Which team would you like to add this monster to?");
        viewAllTeams();
        String teamName = input.nextLine();
        return findTeam(teamName, "getTeam");
    }

    // MODIFIES: this
    // EFFECTS: gets the monster that is attempted to be added
    private Monster getMonster() {
        viewAllMonsters();
        if (allMonsters.size() == 0) {
            System.out.println("Since you haven't created any monsters, you now have the opportunity to make one!");
            createMonster();
            viewAllMonsters();
        }
        System.out.println("Which monster would you like to add to a team?");
        String monsterName = input.nextLine();
        for (Monster m : allMonsters) {
            if (monsterName.equals(m.getName())) {
                return m;
            }
        }
        if (monsterName.equals("%20%Mew%20%")) {
            return triggerEvent();
        }
        System.out.println("No monsters with that name were found! Please try again!");
        System.out.println();
        return getMonster();
    }

    // MODIFIES: this
    // EFFECTS: finds the monster by monsterName, if no monster with that name exists, prints allMonsters and
    //          redirects the user to re-input the monster name that is to be removed.
    private Monster findMonster(String monsterName) {
        for (Monster m : allMonsters) {
            if (monsterName.equals(m.getName())) {
                return m;
            }
        }
        System.out.println("No monsters with that name were found! Please try again!");
        viewAllMonsters();
        System.out.println();
        return getParticularMonsterToRemove();
    }

    // MODIFIES: this
    // EFFECTS: gets the team that is being looked for by teamName, if not found, retries. If no team has been created,
    //          will direct user to first create a team
    private Team findTeam(String teamName, String calledBy) {
        for (Team t : allTeams) {
            if (teamName.equals(t.getTeamName())) {
                return t;
            }
        }
        System.out.println("No teams with that name were found! Please try again!");
        viewAllTeams();
        System.out.println();
        if (calledBy.equals("getTeam")) {
            return getTeam();
        }
        return getParticularTeam();
    }

    // MODIFIES: this
    // EFFECTS: adds a particular monster to a team
    private void addMonsterToTeam() {
        Monster m = getMonster();
        Team t = getTeam();
        checkTeamUnderCapacity(t);
        if (!checkMonsterInTeamAlready(t, m)) {
            t.addMonsterToTeam(m);
            System.out.println(m.getName() + " has been successfully added to " + t.getTeamName() + "!\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: removes a particular monster from a particular team, if it exists in that team, otherwise prints that
    //          the team is empty or that monster is not in that team
    private void removeMonsterFromTeam() {
        Monster m = getParticularMonsterToRemove();
        Team t = getParticularTeam();
        if (t.getAllMonsters().size() == 0) {
            System.out.println("This team is empty! Try another team!");
            return;
        } else if (!t.getAllMonsters().contains(m)) {
            System.out.println("That monster is not in this team!");
            return;
        }
        t.removeMonsterFromTeam(m);
        System.out.println(m.getName() + " has been successfully removed from " + t.getTeamName() + "!\n");
    }

    // MODIFIES: this
    // EFFECTS: checks that there is at least one team that exists, if not, redirects user to create a new team
    private void checkAtLeastOneTeamExists() {
        if (allTeams.size() == 0) {
            System.out.println("You do not have any existing teams, please create one first!");
            createTeam();
        }
    }

    // MODIFIES: this
    // EFFECTS: checks that at least one monster exists, if not, redirects user to make a new monster
    private void checkMonstersNotEmpty() {
        if (allMonsters.size() == 0) {
            System.out.println("You have not created any monsters, please create one first!");
            createMonster();
        }
    }

    // EFFECTS: checks whether a team is under capacity
    private void checkTeamUnderCapacity(Team t) {
        if (t.getAllMonsters().size() == 5) {
            System.out.println("This team is full! Try another team!\n");
        }
    }

    // EFFECTS: checks whether the monster has already been added to the team
    private boolean checkMonsterInTeamAlready(Team t, Monster m) {
        if (t.getAllMonsters().contains(m)) {
            System.out.println("This monster has already been added to this team!\n");
            return true;
        }
        return false;
    }

    // EFFECTS: displays secret event
    private Monster triggerEvent() {
        System.out.println("You feel dizzy... s.m..hing is ha..eni.g...");
        System.out.println("BOOM!!!");
        System.out.println();
        Monster mew = new Monster("Mew", PSYCH, 999);
        return interaction(mew);
    }

    // EFFECTS: displays mysterious interaction
    private Monster interaction(Monster mew) {
        System.out.println("You have been magically transported to the land of Pokémon!");
        System.out.println("You encounter a majestic beast! It looks ... divine.");
        System.out.println(colorPink
                + "???: "
                + "\"S̴͔̬̺̯̓́̔̉̈̒̈͝C̴̨̮̟̝͙͕̓̅̓R̷̴̡̛̛̬̖͈̼̹̜͉͙̭͎͖͇͖̬̟͚̫̫͂̄̓̐͋̐̈́̋̽͊̋̀̃̋̐̉́̔́̈́̾̆̄͛̄̈́̌̚̕͝E̸E̵̩̭̬͓̻̘̓̑̈́̚\""
                + colorReset);
        System.out.println("You have no idea what it's trying to say!");
        System.out.println("You: \"What are you!\"");
        System.out.println(colorPink + "???: \"I am Mew. This is my world. You are "
                + "not welcome.\"" + colorReset);
        System.out.println("You: \"I don't even know how I got here!\"");
        System.out.println(colorPink + "Mew: \"You were transported to this land for breaking the rules of Monstermon."
                + "\"" + colorReset);
        System.out.println("You: \"I apologize! It was a typo I swear to God, I mean, I swear to ... "
                + "you?\"");
        System.out.println(colorPink + "Mew: \"I believe you. You seem interesting... "
                + "I wonder, could you be the one...\"");
        System.out.println("Mew: \"Tell me child, was it you that solved CPSC-110's PSet 9?\"" + colorReset
                + "\t\t\t [Y/N]");
        return (initiateDiscussion(mew));
    }

    // EFFECTS: displays mysterious discussion (since Mew is a "glitch-only" monster, it doesn't appear in allMonsters)
    private Monster initiateDiscussion(Monster mew) {
        String answer = input.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println(colorPink + "Mew: \"...\"" + colorReset);
            System.out.println("You captured Mew!");
            return mew;
        } else if (answer.equals("n")) {
            System.out.println(colorPink + "Mew: \"Perhaps you aren't the hero of legend...\"" + colorReset);
            System.out.println();
            System.out.println(colorRed + "Monstermon Adventures has suddenly stopped responding!" + colorReset);
            System.exit(0);
        } else {
            System.out.println("You're talking to the literal God of Pokémon, pay your respects!");
            System.out.println("Mew: \"Hm?\"");
        }
        return initiateDiscussion(mew);
    }

    // MODIFIES: this
    // EFFECTS: creates a monster
    private void createMonster() {
        System.out.println("Wonderful! You've decided to create a monster!");
        System.out.println("What is your monster's name?");
        String name = input.nextLine();
        String type = getType();
        int hp = getHealthPoints();
        Monster m;
        if (type.equals("fire")) {
            m = new Monster(name, FIRE, hp);
        } else if (type.equals("water")) {
            m = new Monster(name, WATER, hp);
        } else if (type.equals("grass")) {
            m = new Monster(name, GRASS, hp);
        } else {
            System.out.println("Invalid input! Please try again!\n");
            return;
        }
        input.nextLine();
        allMonsters.add(m);
        System.out.println(m.getName() + " has been successfully created!\n");
    }

    // EFFECTS: gets the type from the user for the monster
    private String getType() {
        String type;
        while (true) {
            try {
                System.out.println("What is your monster's type? \t\t[FIRE/GRASS/WATER]");
                type = input.nextLine().toLowerCase();
                if ((type.equals("grass")) || (type.equals("fire")) || (type.equals("water"))) {
                    return type;
                } else {
                    throw new InvalidTypeException();
                }
            } catch (InvalidTypeException e) {
                System.out.println("That is not a valid type.");
            }
        }
    }

    // EFFECTS: gets the health points from the user for the monster
    private int getHealthPoints() {
        int hp;
        while (true) {
            try {
                System.out.println("How many health points does your monster have? \t[1-400]");
                hp = input.nextInt();
                if (hp <= 0 || hp > 400) {
                    throw new InvalidNumberOfHealthPointsException();
                }
                break;
            } catch (InvalidNumberOfHealthPointsException e) {
                System.out.println("That is not a valid number of health points.");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Health points must be a number between 0 and 400.");
                input.nextLine();
            }
        }
        return hp;
    }

    // MODIFIES: this
    // EFFECTS: creates a new team
    private void createTeam() {
        System.out.println("Wonderful! You have decided to make a new team!");
        System.out.println("What is this team's name?");
        String teamName = input.nextLine();
        Team t = new Team(teamName);
        allTeams.add(t);
        System.out.println("Team successfully created!");
        System.out.println();
    }

    // FROM HERE ON, IMPLEMENTATIONS ARE FOR STRETCH GOALS

    // MODIFIES: this
    // EFFECTS: displays the characteristics of the chosen monster by the user. if no monsters exist yet, redirects
    //          user to first create a monster.
    private void getMonsterCharacteristics() {
        System.out.println("Which monster's characteristics would you like to view?");
        viewAllMonsters();
        if (allMonsters.size() == 0) {
            System.out.println("You have not created any monsters yet! Please create one first.");
            createMonster();
            viewAllMonsters();
            System.out.println("Which monster's characteristics would you like to view?");
        }
        String monsterName = input.nextLine();
        Monster m = findMonster(monsterName);
        MonsterType monsterType = m.getType();

        String monsterTypeInString;
        if (monsterType == FIRE) {
            monsterTypeInString = "Fire";
        } else if (monsterType == WATER) {
            monsterTypeInString = "Water";
        } else {
            monsterTypeInString = "Grass";
        }
        int monsterHealthPoints = m.getHealthPoints();
        System.out.println(m.getName() + "'s characteristics: ");
        System.out.println("\t Type: " + monsterTypeInString);
        System.out.println("\t HP: " + monsterHealthPoints);
    }

    // MODIFIES: this
    // EFFECTS: removes all monsters from allMonsters
    private void clearAllMonsters() {
        System.out.println("Are you ABSOLUTELY CERTAIN, with every fiber of your being, that you desire to\n"
                + "ERADICATE and ANNIHILATE each and every one of those TINY, INNOCENT creatures that you TOILED\n"
                + "OVER, pouring HEART and SOUL into CREATING with UNBELIEVABLE AMOUNTS of TIME and EFFORT?!!! "
                + "\t [Y/N]");
        String choice = input.nextLine().toLowerCase();
        if (choice.equals("y")) {
            System.out.println(colorRed + "All your monsters have been erased." + colorReset + "\n");
            allMonsters.clear();
        } else if (choice.equals("n")) {
            System.out.println("Phew!\n");
        } else {
            System.out.println("Invalid input! Please try again!");
        }
    }

    // MODIFIES: this
    // EFFECTS: removes all teams from allTeams
    private void clearAllTeams() {
        System.out.println("Are you POSITIVELY, UNEQUIVOCALLY, IRREVOCABLY SURE that you wish to ERASE every last\n"
                + "one of those GLORIOUS, MASTERFULLY ASSEMBLED teams of WONDERFUL monsters, crafted with LOVING CARE\n"
                + "and EXQUISITE STRATEGY?!! \t [Y/N]");
        String choice = input.nextLine().toLowerCase();
        if (choice.equals("y")) {
            System.out.println(colorRed + "All your teams have been erased." + colorReset + "\n");
            allTeams.clear();
        } else if (choice.equals("n")) {
            System.out.println("Phew!\n");
        } else {
            System.out.println("Invalid input! Please try again!");
        }
    }

}