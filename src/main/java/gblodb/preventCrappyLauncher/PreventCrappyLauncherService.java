package gblodb.preventCrappyLauncher;

import java.util.Set;
import java.util.List;
import java.util.Arrays;
import javax.annotation.Nonnull;
import cpw.mods.modlauncher.api.IEnvironment;
import cpw.mods.modlauncher.api.ITransformer;
import cpw.mods.modlauncher.api.ITransformationService;

public class PreventCrappyLauncherService implements ITransformationService {

    @Override
    public @Nonnull String name() {
        return "PreventCrappyLauncherService";
    }

    @Override
    public void initialize(IEnvironment environment) {
        String launcherBrand = System.getProperty("minecraft.launcher.brand");
        if (launcherBrand.contains("PCL")) {
            throw new CrappyLauncherError("You're using an unsupported launcher.");
        }
    }

    @Override
    public void beginScanning(IEnvironment environment) {}

    @Override
    public void onLoad(IEnvironment env, Set<String> otherServices) {}

    @Override
    public @Nonnull List<ITransformer> transformers() {
        return Arrays.asList(new DummyTransformer());
    }
}
