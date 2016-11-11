/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfun;

/**
 *
 * @author benne_000
 */
public class User {

    private long score;
    private int health;
    private String username;
    private long highScore;

    User(String username, int startHealth, long startScore) {
        score = startScore;
        health = startHealth;
        this.username = username;
        highScore = score;
    }

    User(String undecoded) {
        System.out.println("New data: " + undecoded + "\n");
        String[] split = undecoded.split(" ");
        decode(split);
        highScore = score;
    }
    
    private void decode(String[] split) {
        boolean nextIsUsername = false;
        boolean userAquired = false;
        for (String s : split) {
            System.out.println("Code: " + s);
            if (nextIsUsername) {
                username = s;
                nextIsUsername = false;
                userAquired = true;
            } else if (s.charAt(0) == "U".charAt(0) && !userAquired && !nextIsUsername) {
                nextIsUsername = true;
            } else if (s.startsWith("S") && !nextIsUsername) {
                score = Long.valueOf(s.replace("S", ""));
            } else if (s.startsWith("H") && !nextIsUsername) {
                health = Integer.valueOf(s.replace("H", ""));
            }
            if (score != 0) {
                System.out.println("Score: " + score);
            }
            if (health != 0) {
                System.out.println("Health: " + health);
            }
            if (username != null) {
                System.out.println("Username: " + username);
            }
            if (nextIsUsername) {
                System.out.println("NextisUsername: " + nextIsUsername + "\n");
            } else {
                System.out.println();
            }
        }
    }
    
    public void changeScore(String mode, long amount) {
        if (null != mode) {
            switch (mode) {
                case "+":
                    score += amount;
                    break;
                case "-":
                    score -= amount;
                    break;
                case "=":
                    score = amount;
                    break;
                default:
                    System.err.println("invalid mode " + mode);
                    break;
            }
        }

    }

    public long getScore() {
        return score;
    }
    
    public long getHighScore() {
        return highScore;
    }
    
    public void setHighScore(String mode, long amount) {
        if (null != mode) {
            switch (mode) {
                case "+":
                    highScore += amount;
                    break;
                case "-":
                    highScore -= amount;
                    break;
                case "=":
                    highScore = amount;
                    break;
                default:
                    highScore = amount;
                    break;
            }
        }
    }

    public int getHealth() {
        return health;
    }
    
    public void setHealth(String mode, int amount) {
        if (null != mode) {
            switch (mode) {
                case "+":
                    health += amount;
                    break;
                case "-":
                    health -= amount;
                    break;
                case "=":
                    health = amount;
                    break;
                default:
                    System.err.println("invalid mode " + mode);
                    break;
            }
        }
    }

    public String getUser() {
        return username;
    }
    
    public void setUser(String setTo) {
        username = setTo;
    }
    
    public boolean isAlive() {
        return health != 0;
    }
    
    public boolean hasPlayed() {
        return highScore != 0;
    }
    
}
