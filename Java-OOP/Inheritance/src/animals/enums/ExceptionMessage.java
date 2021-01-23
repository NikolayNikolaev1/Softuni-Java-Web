package animals.enums;

public enum ExceptionMessage {
    ILLEGAL_ARGUMENT_EXCEPTION("Invalid input!");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
