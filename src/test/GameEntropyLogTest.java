package test;

import core.game.StateObservationMulti;
import gamelog.GameLogger;
import ontology.Constants;

import java.util.Arrays;

import static test.GameTest.playOne;
import static test.GameTest.playNAndMean;

/**
 * Created by Simon Lucas on 14/05/2017.
 */
public class GameEntropyLogTest {
    public static void main(String[] args) {
        //    int[] params = { 4, 4, 1, 2, 5, 20}; //ValidParams.optimalParams50[33];
//    int[] params = { 10, 5, 1, 1, 4, 20};
        int[] params = {5, 4, 1, 2, 5, 20};
        Constants.SHIP_MAX_SPEED = params[0];
        Constants.THRUST_SPEED = params[1];
        Constants.MISSILE_COST = params[2];
        Constants.MISSILE_MAX_SPEED = params[3];
        Constants.MISSILE_COOLDOWN = params[4];
        Constants.SHIP_RADIUS = params[5];

        // playOne(0, 2, false, 0);

        double[] x = playNAndMean(10, 2, 2);
        System.out.println(Arrays.toString(x));

        // now print out the entropy log

        StateObservationMulti.playerOneActions.frequencyReport();
        GameLogger logger = StateObservationMulti.playerOneActions;
        System.out.println(logger.frequencyReport());
        System.out.format("Player One Action Entropy: " + GameLogger.entropy(logger.pVec()));

    }
}