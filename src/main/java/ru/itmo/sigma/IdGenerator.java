package ru.itmo.sigma;

import java.util.UUID;

public class IdGenerator {
    public static long generateId() {
        return Math.abs(UUID.randomUUID().getMostSignificantBits());
    }
}
