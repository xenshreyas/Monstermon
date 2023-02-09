package ui;

import model.Monster;
import model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static model.MonsterType.*;

public class MonstermonApp {
    private Scanner input;
    private List<Monster> allMonsters;
    private List<Team> allTeams;
    
    // EFFECTS: runs the monstermon application
    public MonstermonApp() {
        runMonstermon();
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

    private void init() {
        allTeams = new ArrayList<>();
        allMonsters = new ArrayList<>();
        input = new Scanner(System.in);
    }

    // EFFECTS: displays the intro to user
    private void playIntro() {
        // IDEA: can have background music playing. This would be done by calling another method in order to stick to
        //       the 25 line limit per method. playBackgroundMusic();

        System.out.println("Hello there! It's so very nice to meet you!");
        System.out.println("Welcome to the fascinating world of Monstermon!");
        System.out.println("My name is Mahogany. However, everyone just calls me the Monstermon Professor.");
        System.out.println("This world is widely inhabited by creatures known as Monstermon!");
        System.out.println("We humans live alongside Monstermon as friends. At times we play together, and at other " +
                "times, we work together.");
        System.out.println("Some people use their Monstermon to battle and develop closer bonds with them!");

        System.out.println();
        // IDEA: can have the user enter some details about themselves that are used to greet them
        //       every time the app is opened. Not sure how I would do this though.

        System.out.println("All right. The time has come. Your very own tale of grand adventure is about to unfold!");
        System.out.println("On your journey, you will meet countless monsters. I'm sure that along the way, " +
                "you will discover many things, maybe even things that weren't meant to be discovered!");
        System.out.println("Now, go on and leap into the world of Monstermon!");
        System.out.println();
        System.out.println();
    }

    // EFFECTS: displays the menu of options to user
    private void displayMenu() {
        System.out.println("Choose an option: \t[If you haven't already, please take a look at the rules before you" +
                " begin!]");
        System.out.println("/rules -> Rules");
        System.out.println("/newmonster -> Create New Monster");
        System.out.println("/newteam -> Create New Team");
        System.out.println("/addmonster -> Add Monster to a Team");
        System.out.println("/removemonster -> Remove Monster from a Team");
        System.out.println("/renamemonster -> Rename Monster");
        System.out.println("/renameteam -> Rename Team");
        System.out.println("/viewteams -> View all Teams");
        System.out.println("/viewmonsters -> View all Monsters");
        System.out.println("/quit -> Quit\n");
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
        } else {
            System.out.println("Invalid input! Please try again!\n");
        }
    }

    // EFFECTS: displays all monsters that have been made
    private void viewAllMonsters() {
        System.out.println("All your cherished monsters in one place!");
        if (allMonsters.size() == 0) {
            System.out.println("You have not created any monsters yet!");
        } else {
            for (Monster m : allMonsters) {
                System.out.println(m.getName());
            }
        }
        System.out.println();
    }

    // EFFECTS: displays all teams that have been made
    private void viewAllTeams() {
        System.out.println("All your fabulous teams in one place!");
        if (allTeams.size() == 0) {
            System.out.println("You have not created any teams yet!");
        } else {
            printTeams();
        }
        System.out.println();
    }

    // EFFECTS: displays all teams that have been made
    private void printTeams() {
        for (Team t : allTeams) {
            System.out.print(t.getTeamName() + ": [");
            printMonsters(t);
            System.out.println("]");
        }
    }

    // EFFECTS: displays all the monsters in the given team
    private void printMonsters(Team t) {
        for (Monster m : t.getAllMonsters()) {
            List <Monster> allMonstersInTeam = t.getAllMonsters();
            if (allMonstersInTeam.indexOf(m) == allMonstersInTeam.size()-1) {
                System.out.print(m.getName());
            } else {
                System.out.print(m.getName() + ", ");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a new team
    private void createTeam() {
        System.out.println("What is this team's name?");
        String teamName = input.nextLine();
        Team t = new Team(teamName);
        allTeams.add(t);
        System.out.println("Team successfully created!");
        System.out.println();
    }

    // MODIFIES: this
    // EFFECTS: renames a particular team
    private void renameTeam() {
        System.out.println("Which team would you like to rename?");
        viewAllTeams();
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
    // EFFECTS: renames a particular monster
    private void renameMonster() {
        System.out.println("Which monster would you like to rename?");
        viewAllMonsters();
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
    // EFFECTS: removes a particular monster from a particular team
    private void removeMonsterFromTeam() {
        Monster m = getParticularMonsterToRemove();
        Team t = getParticularTeam();
        if (t.getAllMonsters().size() == 0) {
            System.out.println("This team is empty! Try another team!");
            return;
        }
        else if (!t.getAllMonsters().contains(m)) {
            System.out.println("That monster is not in this team!");
            return;
        }
        t.removeMonsterFromTeam(m);
    }

    // EFFECTS: gets a particular team
    private Team getParticularTeam() {
        checkTeamsNotEmpty();
        System.out.println("What is the name of the team to remove the monster from?");
        String teamName = input.nextLine();
        return findTeam(teamName, "removeTeam");
    }

    // MODIFIES: this
    // EFFECTS: checks that there is at least one team that exists, if not, redirects user to create a new team
    private void checkTeamsNotEmpty() {
        if (allTeams.size() == 0) {
            System.out.println("You have not created any teams, please create one first!");
            createTeam();
        }
    }

    // MODIFIES: this
    // EFFECTS: gets a monster to remove, if no monsters exist, redirects user to create a monster
    private Monster getParticularMonsterToRemove() {
        checkMonstersNotEmpty();
        System.out.println("What is the name of the monster to remove?");
        String monsterName = input.nextLine();
        return findMonster(monsterName);
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
    // EFFECTS: checks that at least one monster exists, if not, redirects user to make a new monster
    private void checkMonstersNotEmpty() {
        if (allMonsters.size() == 0) {
            System.out.println("You have not created any monsters, please create one first!");
            createMonster();
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a particular monster to a team
    private void addMonsterToTeam() {
        Monster m = getMonster();
        Team t = getTeam();
        checkTeamUnderCapacity(t);
        checkMonsterInTeamAlready(t, m);
        t.addMonsterToTeam(m);
    }

    // EFFECTS: checks whether a team is under capacity
    private void checkTeamUnderCapacity(Team t) {
        if (t.getAllMonsters().size() == 5) {
            System.out.println("This team is full! Try another team!\n");
            return;
        }
    }

    // EFFECTS: checks whether the monster has already been added to the team
    private void checkMonsterInTeamAlready(Team t, Monster m) {
        if (t.getAllMonsters().contains(m)) {
            System.out.println("This monster has already been added to this team!\n");
            return;
        }
    }

    // EFFECTS: gets the monster that is attempted to be added
    private Monster getMonster() {
        System.out.println("Which monster would you like to add to a team?");
        viewAllMonsters();
        String monsterName = input.nextLine();
        for (Monster m : allMonsters) {
            if (monsterName.equals(m.getName())) {
                return m;
            }
        }
        if (monsterName.equals("%20Mew%20")) {
            return triggerEvent();
        }
        System.out.println("No monsters with that name were found! Please try again!");
        viewAllMonsters();
        System.out.println();
        return getMonster();
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
        System.out.println("You encounter a majestic beast! It looks almost... divine.");
        System.out.println("???: \"Ş̴̛͔̮̤͙͔̬̺̯̓́̔̉̈̒̈͜͝C̴̨̻̰̞͔̮̟̝͙͕̓̅̓̓͘R̴̡̛̬̖͈̼̭̿̌͊̇͂̄̓͝͝Ȩ̸̯̱̘̭̾̿E̸̹̜͉͙̭͎͖̐͋̐̈́̋̽͊̋̚È̷͇͖̬̟͚̃̋̐̉́̔́̈́̕Ę̴̛̫̫̭̳̣̾̆̄͛̄̈́̌E̸̵̩̭̬͓̻͚̘̾͆́͑͑̆̄̓̑̈́̒͗̋̋̚\"");
        System.out.println("You have no idea what it's trying to say!");
        System.out.println("You: \"What are you!\"");
        System.out.println("???: \"I am Mew. This is my world. You are \uD835\uDD93\uD835\uDD94\uD835\uDD99 " +
                "welcome.\"");
        System.out.println("You: \"I don't even know how I got here!\"");
        System.out.println("Mew: \"You were transported to this land for breaking the rules of Monstermon.\"");
        System.out.println("You: \"I apologize! It was a typo I swear to God, I mean, I swear to ... " +
                "\uD835\uDCCE\uD835\uDC5C\uD835\uDCCA?\"");
        System.out.println("Mew: \"I believe you. You seem interesting... I wonder, could you be the one...\"");
        System.out.println("Mew: \"Tell me child, was it you that solved CPSC-110's PSet 9?\" \t\t\t [Y/N]");
        return (initiateDiscussion(mew));
    }

    // EFFECTS: displays mysterious discussion
    private Monster initiateDiscussion(Monster mew) {
        String answer = input.nextLine().toLowerCase();
        if (answer.equals("y")) {
            System.out.println("Mew: \"...\"");
            System.out.println("You captured Mew!");
            return mew;
        } else if (answer.equals("n")) {
            System.out.println("Mew: \"Perhaps you aren't the hero of legend...\"");
            System.out.println();
            System.out.println("Monstermon Adventures has suddenly stopped responding!");
            System.exit(0);
        } else {
            System.out.println("You're talking to the literal God of Pokémon, pay your respects!");
            System.out.println("Mew: \"Hm?\"");
        }
        return initiateDiscussion(mew);
    }

    // EFFECTS: gets the team that the monster is attempted to be added to
    private Team getTeam() {
        checkAtLeastOneTeamExists();
        System.out.println("Which team would you like to add this monster to?");
        viewAllTeams();
        String teamName = input.nextLine();
        Team t = findTeam(teamName, "getTeam");
        return t;
    }

    // EFFECTS:
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
    // EFFECTS: makes sure that at least one team exists
    private void checkAtLeastOneTeamExists() {
        if (allTeams.size() == 0) {
            System.out.println("You do not have any existing teams, please create one first!");
            createTeam();
        }
    }

    // EFFECTS: displays the rules to user
    private void displayRules() {
        System.out.println("Thank you for taking the time to look at the rules of Monstermon!");
        System.out.println("The first step in playing Monstermon is to create a monster.");
        System.out.println("In order to create a monster, you must decide its name, type and number of health points!");
        System.out.println("A monster can be of one of three types: Fire, Water and Grass. " +
                "\t\t\t[alpha: more types coming soon!]");
        System.out.println("Your monster must have a minimum of 1 health point, and a maximum of 400." +
                "\t[alpha: attack, defense and speed coming soon!]");
        System.out.println("That's about it! Now, go on and leap into the world of Monstermon!\n");
    }

    // MODIFIES: this
    // EFFECTS: creates a monster
    private void createMonster() {
        System.out.println("Wonderful! You've decided to create a monster!");
        System.out.println("What is your monster's name?");
        String name = input.nextLine();
        System.out.println("What is your monster's type? \t\t[FIRE/GRASS/WATER]");
        String type = input.nextLine().toLowerCase();
        System.out.println("How many health points does your monster have? \t[1-400]");
        int hp = input.nextInt();

        if (type.equals("fire") && hp > 0 && hp <= 400) {
            Monster m = new Monster(name, FIRE, hp);
            allMonsters.add(m);
        } else if (type.equals("water") && hp > 0 && hp <= 400) {
            Monster m = new Monster(name, WATER, hp);
            allMonsters.add(m);
        } else if (type.equals("grass") && hp > 0 && hp <= 400) {
            Monster m = new Monster(name, GRASS, hp);
            allMonsters.add(m);
        } else {
            System.out.println("Invalid input! Please try again!\n");
        }
        input.nextLine();
        System.out.println();
    }
}