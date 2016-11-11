/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfun;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author benne_000
 */
public class ForFun {

    private static Object next;
    private static String[] split;
    public static List<User> users = new ArrayList();
    
    protected static String hi() {
        return
        "█    _     _   _   _    █\n" +
        "█   | |   | | |_| [#]   █\n" +
        "█   | |___| |  _  [#]   █\n" +
        "█   |  ___  | | | [#]   █\n" +
        "█   | |   | | | |       █\n" +
        "█   |_|   |_| |_| [#]   █\n" +
        "█                       █\n";
    }
    protected static String logo() {
        return
        "█   _____           █\n" +
        "█  (  ___|=======}  █\n" +
        "█  | [___ + _____|  █\n" +
        "█  (_____| |___  )  █\n" +
        "█  |      + ___] |  █\n" +
        "█  {=======|_____)  █\n" +
        "█                   █\n";
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(hi());
        Scanner reader = new Scanner(new FileInputStream("Scores.txt"));
        long score;
        int health;
        while (reader.hasNextLine()) {
            next = reader.nextLine();
            split = String.valueOf(next).split(" ");
            if (split[0].equals("U")) {
                users.add(new User(String.valueOf(next)));
            } else if (split[0].equals("C")) {
                change(split[1],split[2],split[3],split[4]);
            }
        }
        System.out.println(logo());
        
        for (User u : users) {
            if (u.isAlive()) {
                System.out.printf(u.getUser()+"("+u.getHealth()+") has %,d points.\n", u.getScore());
            } else if (u.hasPlayed()) {
                System.out.printf(u.getUser()+" has a high score of %,d.\n", u.getHighScore());
            } else {
                System.out.println(u.getUser()+" has never played before.");
            }
        }
        
    }
    
    public static void change(String name, String what, String how, String to) {
        for (User u : users) {
            if (u.getUser().equals(name)) {
                switch (what) {
                    case "score":
                        u.changeScore(how, Long.valueOf(to));
                        break;
                    case "health":
                        u.setHealth(how, Integer.valueOf(to));
                        break;
                    case "name":
                        u.setUser(to);
                        break;
                    case "highscore":
                        u.setHighScore(how, Long.valueOf(to));
                        break;
                    default:
                        System.err.println("Invalid thing to change "+what);
                        break;
                }
            }
        }
    }
    
}
