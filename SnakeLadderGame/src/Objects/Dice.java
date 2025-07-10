package Objects;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    static final int min = 1;
    static final int max = 6;

    public Dice(int diceCount){
        this.diceCount = diceCount;
    }


    public int rollDice(){
        int totalSum = 0;
        int diceUsed = 0;
        while(diceUsed<diceCount){
            totalSum += ThreadLocalRandom.current().nextInt(min,max+1);
            diceUsed++;
        }
        System.out.println("Dice rolled - " + totalSum);
        return totalSum;
    }
}
