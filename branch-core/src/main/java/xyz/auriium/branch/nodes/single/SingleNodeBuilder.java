package xyz.auriium.branch.nodes.single;

import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.api.ExecutionHandler;
import xyz.auriium.branch.fallback.permissions.EmptyPermission;
import xyz.auriium.branch.fallback.permissions.Permission;
import xyz.auriium.branch.interfacing.information.description.Description;
import xyz.auriium.branch.interfacing.information.description.StringDescription;

import java.util.Objects;

public final class SingleNodeBuilder<T> {


    private final Block identifier;
    private Permission<T> permission;
    private Description description;
    private ExecutionHandler<T> handler;

    SingleNodeBuilder(Block identifier) {
        this.identifier = identifier;
    }

    public static <T> SingleNodeBuilder<T> builder(Block identifier) {
        return new SingleNodeBuilder<>(identifier);
    }

    public SingleNodeBuilder<T> withPermission(Permission<T> permission) {
        this.permission = permission;
        return this;
    }

    public SingleNodeBuilder<T> withDescription(Description description) {
        this.description = description;
        return this;
    }

    public SingleNodeBuilder<T> withHandler(ExecutionHandler<T> handler) {
        this.handler = handler;
        return this;
    }

    public SingleNode<T> build() {

        return new SingleNode<T>(
                identifier,
                Objects.requireNonNullElse(permission, new EmptyPermission<>()),
                Objects.requireNonNullElse(description, new StringDescription("Default description")),
                handler
        );
    }
}
