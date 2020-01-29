package infrastructure;

public enum Configuration {
    instance;

    private final String aesMasterPassword="x7z99kvb6lU";

    public String getAesMasterPassword() {
        return aesMasterPassword;
    }
}
