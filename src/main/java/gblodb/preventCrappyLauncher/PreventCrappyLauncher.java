package gblodb.preventCrappyLauncher;

import java.io.File;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class PreventCrappyLauncher implements ITweaker {
    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) throws CrappyLauncherError {
        File pclDir = new File(gameDir.getPath() + "\\PCL");
        if (pclDir.exists()) {
            throw new CrappyLauncherError("You're using an unsupported launcher.");
        }
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {}

    @Override
    public String getLaunchTarget() { return "net.minecraft.client.main.Main"; }

    @Override
    public String[] getLaunchArguments() { return new String[0]; }
}
