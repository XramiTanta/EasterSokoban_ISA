package Structure;

public enum Color {
    RESET("\u001B[0m"),
    RED("\u001B[31m"), //for egg
    GREEN("\u001B[32m"), //for goal cell with egg
    YELLOW("\u001B[33m"), //for goal cell without egg
    WHITE("\u001B[37m"), // for stone
    PURPLE("\u001B[35m"), // for bunny
    Black("\u001B[30m"), //for empty Cell
    ;

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}
