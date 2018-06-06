package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String input;
        String output = "";
        ArrayList<String> hedges = new ArrayList<>();
        ArrayList<String> qualifiers = new ArrayList<>();
        HashMap<String, String> hmap = new HashMap<String, String>();

        hedges.add("Please tell me more");
        hedges.add("Many of my patients tell me the same thing");
        hedges.add("It is getting late, maybe we had better quit");

        qualifiers.add("Why do you say that");
        qualifiers.add("You seem to think that");
        qualifiers.add("So, you are concerned that");

        hmap.put("I", "you");
        hmap.put("my", "your");
        hmap.put("me", "you");
        hmap.put("am", "are");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Good day. What is your problem?");
        System.out.println("Enter your response here or Q to quit: ");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        input = buf.readLine();

        while (!input.equalsIgnoreCase("q")) {
            if (input.contains("play game")) {
                System.out.println("Play game started");
                PlayGame();
                break;
            }

            String[] splited = input.split(" ");
            Iterator it = hmap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                if (Arrays.asList(splited).contains(pair.getKey().toString())) {
                    int index = Arrays.asList(splited).indexOf(pair.getKey().toString());
                    splited[index] = pair.getValue().toString();
                }
            }
            for (int i = 0; i < splited.length; i++) {
                output = output + " " + splited[i];
                //System.out.println("^^^^^^^^^^my output " + output);
            }

            if (output.contains("pig")) {
                output = output.replaceAll("pig", "porcus");
            }

           // System.out.println("!!!! my output " + output);

            Random rand = new Random();
            int x = rand.nextInt(2);
            switch (x) {
                case 0:
                    int i = rand.nextInt(3);
                    if (output.contains("caps")&&!output.contains("red")) {
                        System.out.println(hedges.get(i).toUpperCase());
                       // System.out.println("1");
                    }
                    else if(output.contains("red")&&!output.contains("caps")) {
                        final String ANSI_RED = "\u001B[31m";
                        System.out.println(ANSI_RED+ hedges.get(i));
                       // System.out.println("2");
                    }
                    else if (output.contains("caps")&&output.contains("red"))
                    {
                        final String ANSI_RED = "\u001B[31m";
                        System.out.println(ANSI_RED+ hedges.get(i).toUpperCase());
                        //System.out.println("3");
                    }
                    else {
                        System.out.println(hedges.get(i));
                        //System.out.println("4");
                    }
                    output = "";
                    break;
                case 1:
                    int n = rand.nextInt(3);
                    if (output.contains("caps")&&!output.contains("red")){
                        System.out.println(qualifiers.get(n).toUpperCase() + output.toUpperCase());
                        //System.out.println("5");
                    }
                    else if (output.contains("red")&&!output.contains("caps")) {
                        final String ANSI_RED = "\u001B[31m";
                        System.out.println(ANSI_RED+ qualifiers.get(n) + output);
                        //System.out.println("6");
                    }
                    else if (output.contains("caps")&&output.contains("red"))
                    {
                        final String ANSI_RED = "\u001B[31m";
                        System.out.println(ANSI_RED+ qualifiers.get(n).toUpperCase() + output.toUpperCase());
                        //System.out.println("7");
                    }
                    else {
                        System.out.println(qualifiers.get(n) + output);
                        //System.out.println("8");
                    }
                    output = "";
                    break;
            }
            final String ANSI_BLACK = "\u001B[30m";
            System.out.println(ANSI_BLACK+"Enter your response here or Q to quit: ");
            buf = new BufferedReader(new InputStreamReader(System.in));
            input = buf.readLine();
        }
    }

    public static void PlayGame()
    {

        String choice1, choice2, choice3 = null;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("WELCOME TO MITCHELL'S TINY ADVENTURE!");
            System.out.println("You are in a creepy house!  Would you like to go \"upstairs\" " +
                    "or into the\n" + "\"kitchen\"?");
            choice1 = scanner.next();
        } while(!choice1.equalsIgnoreCase("kitchen") && !choice1.equalsIgnoreCase("upstairs"));

        if (choice1.equalsIgnoreCase("kitchen")) {
            do {
                System.out.println("There is a long countertop with dirty dishes everywhere. Off to one side\n" +
                        "there is, as you'd expect, a refrigerator. You may open the \"refrigerator\"\n" +
                        "or look in a \"cabinet\".");
                choice2 = scanner.next();
            } while (!choice2.equalsIgnoreCase("refrigerator") && !choice2.equalsIgnoreCase("cabinet"));
            //System.out.println(choice2);
            if (choice2.equalsIgnoreCase("cabinet")) {
                do {
                    System.out.println("Inside the cabinet you see a container. It looks pretty old.\n" +
                            "Would you like to open it? (\"yes\" or \"no\")");
                    choice3 = scanner.next();
                } while (!choice3.equalsIgnoreCase("yes") && !choice3.equalsIgnoreCase("no"));

                if (choice3.equalsIgnoreCase("yes")) {
                    System.out.println("You will get very precious treasure.");
                } else {
                    System.out.println("You will be very curious on what is in the container.");
                }
            } else {
                do {
                    System.out.println("Inside the refrigerator you see food and stuff.  It looks pretty nasty.\n" +
                            "Would you like to eat some of the food? (\"yes\" or \"no\")");
                    choice3 = scanner.next();
                } while (!choice3.equalsIgnoreCase("yes") && !choice3.equalsIgnoreCase("no"));
                if (choice3.equalsIgnoreCase("yes") || choice3.equalsIgnoreCase("no")) {
                    if (choice3.equalsIgnoreCase("yes")) {
                        System.out.println("You will get very delicious new food.");
                    } else {
                        System.out.println("You die of starvation... eventually.");
                    }
                }
            }
        }
        //upstairs
        else
        {
            do {
                System.out.println("Upstairs you see a hallway.  At the end of the hallway is the master\n"+
                        "\"bedroom\".  There is also a \"bathroom\" off the hallway.  Where would you like\n"+
                        "to go?");
                choice2 = scanner.next();
            }while(!choice2.equalsIgnoreCase("bedroom") && !choice2.equalsIgnoreCase("bathroom"));
            //System.out.println(choice2);
            if (choice2.equalsIgnoreCase("bedroom"))
            {
                do {
                    System.out.println("You are in a plush bedroom, with expensive-looking hardwood furniture.  The\n"+
                            "bed is unmade.  In the back of the room, the closet door is ajar.  Would you\n"+
                            "like to open the door? (\"yes\" or \"no\")");
                    choice3 = scanner.next();
                }while(!choice3.equalsIgnoreCase("yes") && !choice3.equalsIgnoreCase("no"));
                if (choice3.equalsIgnoreCase("yes")) {
                    System.out.println("You will meet someone who lived there long time ago");
                } else {
                    System.out.println("Well, then I guess you'll never know what was in there.  Thanks for playing,\n" +
                            "I'm tired of making nested if statements.");
                }
            }
            else
            {
                do {
                    System.out.println("You are in creepy bathroom, with a unique mirror on the wall. \nWould you "+
                            "like to look at the mirror? (\"yes\" or \"no\")");
                    choice3 = scanner.next();
                }while(!choice3.equalsIgnoreCase("yes") && !choice3.equalsIgnoreCase("no"));
                if (choice3.equalsIgnoreCase("yes")) {
                    System.out.println("You will meet a ghost behind you.");
                } else  {
                    System.out.println("You can get some gold coins inside the toilet");
                }
            }
        }
    }
}

