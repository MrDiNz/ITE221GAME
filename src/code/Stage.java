package code;

import java.util.Arrays;

public class Stage implements stageInterface{
    //    x and y for location and stage use to store monster
    private int x, y;
    private Monster[][] stage;
//difficulty for 3 stage Easy Medium Hard in generate stage method


    public Stage(String difficulty) {
        this.x = 1;
        this.y = 1;
//        switch case for difficulty and double loop to auto generate monster for each stage
//        each case is a loop to create 8 "monster" with different level per stage if the room != 1,1 which is the spawn room, lvl and damage is random
//        stage created in the code.main class not this class!!!
        int countMonsNum;
        switch (difficulty.toLowerCase()) {
            case "easy":
                stage = new Monster_easy[3][3];
                countMonsNum = 1;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        //j and i cannot be 1 because it is the area that character will respawn
                        if (!(i == 1 && j == 1)) {
                            //random the level of the monster
                            int randomlvl = Randomizer.Randomizer(1, 4);
                            //get a monster in to the array (hp = 50 , level by random, )
                            stage[i][j] = new Monster_easy(50, randomlvl * Randomizer.Randomizer(1, 3), "Monster No." + countMonsNum, randomlvl);
                            countMonsNum++;
                        }
                    }
                }
                break;
            case "medium":
                stage = new Monster_Medium[3][3];
                countMonsNum = 1;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(i == 1 && j == 1)) {
                            int randomlvl = Randomizer.Randomizer(5, 8);
                            stage[i][j] = new Monster_Medium(100, randomlvl * Randomizer.Randomizer(1, 3), "Monster No." + countMonsNum, randomlvl);
                            countMonsNum++;
                        }
                    }
                }
                break;
            case "hard":
                stage = new Monster_Hard[3][3];
                countMonsNum = 1;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(i == 1 && j == 1)) {
                            int randomlvl = Randomizer.Randomizer(9, 12);
                            stage[i][j] = new Monster_Hard(150, randomlvl * Randomizer.Randomizer(1, 3), "Monster No." + countMonsNum, randomlvl);
                            countMonsNum++;
                        }
                    }
                }
                break;
        }
    }


    //use to print monster in each room "dev" only player cannot do this
    public void printStageWithMonster() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("["+stage[i][j]+"]");
            }
            System.out.println();
        }
    }
//print hero location
    public void printStageHeroLocation() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (x == i && y == j) {
                    System.out.print("[*]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
        System.out.println("You are here -> *");
    }
    @Override
    public String toString() {
        return "Stage{" +
                "x=" + x +
                ", y=" + y +
                ", stage=" + Arrays.deepToString(stage) +
                '}';
    }

//    player move location
//    w = up s = down a = left d = right same as FPS game
    public void playerMove(String move) {
        switch (move.toLowerCase()) {
            case "w":
                setX(getX() - 1);
                break;
            case "s":
                setX(getX() + 1);
                break;
            case "a":
                setY(getY() - 1);
                break;
            case "d":
                setY(getY() + 1);
                break;
            default:
                System.out.println("You did a wrong move");
        }
        printStageHeroLocation();
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Monster getStage(int x, int y) {
        if (stage[x][y] != null) {
            return stage[x][y];
        } else return null;
    }

    public Monster[][] getStage() {
        return stage;
    }

    public void setStage(int x, int y, Monster monster) {
        this.stage[x][y] = monster;
    }

    public void setMonsgterDie(int x, int y) {
        this.stage[x][y] = null;
    }

}
