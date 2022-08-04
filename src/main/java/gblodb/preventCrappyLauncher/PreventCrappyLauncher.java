package gblodb.preventCrappyLauncher;

import java.io.*;
import java.util.List;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class PreventCrappyLauncher implements ITweaker {
    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) throws CrappyLauncherError {
        int count = 0;

        if (!System.getProperty("os.name").toLowerCase().contains("win")) return;

        try {
            String line;
            String cmd = System.getenv("windir") + "\\system32\\" + "tasklist.exe" + " /FO csv /FI \"WINDOWTITLE eq Plain Craft Launcher 2\u3000\"";
            Process pr = new ProcessBuilder(cmd).start();
            SequenceInputStream sis = new SequenceInputStream(pr.getInputStream(), pr.getErrorStream());
            InputStreamReader inst = new InputStreamReader(sis);
            BufferedReader br = new BufferedReader(inst);
            while ((line = br.readLine()) != null) {
                if (line.startsWith("\"")) count++;
            }
        } catch (Exception ignored) {
            // lol
        }

        if (count > 1) throw new CrappyLauncherError("You're using an unsupported launcher.");
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {}

    @Override
    public String getLaunchTarget() { return "net.minecraft.client.main.Main"; }

    @Override
    public String[] getLaunchArguments() { return new String[0]; }
}
