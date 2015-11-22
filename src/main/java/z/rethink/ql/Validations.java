package z.rethink.ql;

final class Validations {
    public static void checkLengthNotZero(String name, int length)
    {
        if (length == 0) {
            throw new IllegalArgumentException(name + " length should be more than 0");
        }
    }
}
