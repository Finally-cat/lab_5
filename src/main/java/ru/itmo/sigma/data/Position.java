package ru.itmo.sigma.data;

public enum  Position {
    LABORER,
    HUMAN_RESOURCES,
    LEAD_DEVELOPER;

    public static Position getByOrdinal(int ordinal) {
        Position[] values = Position.values();
        if (ordinal < 0 || ordinal >= values.length) {
            throw new IllegalArgumentException("Неверный индекс: " + ordinal);
        }
        return values[ordinal];
    }
}
