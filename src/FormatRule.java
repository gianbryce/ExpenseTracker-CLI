public enum FormatRule {
    /*
    Defines format types and their corresponding RegEx pattern.
    Used for validating correct input formats.
    */
    DATE("\\d{2}-\\d{2}-\\d{4}"),
    PRICE("\\d(\\.\\d)?");

    private String format;
    private String message;

    FormatRule(String format) {
        this.format = format;
    }

    String getFormat() {
        return format;
    }
}
