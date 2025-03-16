package ru.itmo.sigma;

import java.util.UUID;

/**
 * The type Id generator.
 */
public class IdGenerator {
    /**
     * Generate id long.
     *
     * @return the long
     */
    public static long generateId() {
        return Math.abs(UUID.randomUUID().getMostSignificantBits());
    }
}
