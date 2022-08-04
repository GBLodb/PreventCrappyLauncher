package gblodb.preventCrappyLauncher;

import cpw.mods.modlauncher.api.ITransformer;
import cpw.mods.modlauncher.api.ITransformerVotingContext;
import cpw.mods.modlauncher.api.TransformerVoteResult;
import org.objectweb.asm.tree.ClassNode;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DummyTransformer implements ITransformer<ClassNode> {
    @Nonnull
    @Override
    public ClassNode transform(ClassNode input, ITransformerVotingContext context) {
        return input;
    }

    @Nonnull
    @Override
    public TransformerVoteResult castVote(ITransformerVotingContext context) {
        return TransformerVoteResult.YES;
    }

    @Nonnull
    @Override
    public Set<Target> targets() {
        return new HashSet<>(Arrays.asList(Target.targetClass("not.exist.class.anyway")));
    }
}
