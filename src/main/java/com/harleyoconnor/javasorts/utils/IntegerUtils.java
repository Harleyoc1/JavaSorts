package com.harleyoconnor.javasorts.utils;

import com.harleyoconnor.javasorts.GlobalObjects;

/**
 * @author Harley O'Connor
 */
public final class IntegerUtils {

    /**
     * Gets a random number between the two parameters, inclusive.
     *
     * @param min The minimum value.
     * @param max The maximum value.
     * @return A random number between the parameters.
     */
    public static int getRandomIntBetween (final int min, final int max) {
        return GlobalObjects.RANDOM.nextInt((max - min) + 1) + min;
    }

}
