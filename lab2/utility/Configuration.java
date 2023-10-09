package utility;

public class Configuration {
    private static Configuration instance;
    private String appVersion;

    private Configuration() {
        // Private constructor to restrict instantiation
        appVersion = "1.0.0";
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String getAppVersion() {
        return appVersion;
    }

    // Add other configuration settings as needed
}
