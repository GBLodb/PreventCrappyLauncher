package gblodb.preventCrappyLauncher;

public class CrappyLauncherError extends RuntimeException {
    public CrappyLauncherError(String errorMessage) {
        super(errorMessage);
    }
}
