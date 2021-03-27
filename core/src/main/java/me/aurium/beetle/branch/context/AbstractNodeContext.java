package me.aurium.beetle.branch.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.CommandNode;

public abstract class AbstractNodeContext<T> extends AbstractContext<T> implements NodeContext<T> {

    private final CommandNode<T> executed;
    private final CommandNode<T> base;
    private final BlockPath executedPath;
    private final BlockPath fullPath;

    protected AbstractNodeContext(T t, String alias, String[] args, CommandNode<T> executed, CommandNode<T> base, BlockPath executedPath, BlockPath fullPath) {
        super(t, alias, args);
        this.executed = executed;
        this.base = base;
        this.executedPath = executedPath;
        this.fullPath = fullPath;
    }

    @Override
    public CommandNode<T> getExecutedNode() {
        return executed;
    }

    @Override
    public CommandNode<T> getBaseExecutedNode() {
        return base;
    }

    @Override
    public BlockPath executedPath() {
        return executedPath;
    }

    @Override
    public BlockPath fullPath() {
        return fullPath;
    }
}
