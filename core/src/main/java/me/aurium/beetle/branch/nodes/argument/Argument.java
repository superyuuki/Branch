package me.aurium.beetle.branch.nodes.argument;

import me.aurium.beetle.branch.block.Block;

import java.util.List;
import java.util.Optional;

/**
 * Represents a kind of parser that converts blocks into a typed argument.
 * @param <T>
 *
 *     TODO: maybe let arguments consume more than one Block.
 */
public interface Argument<T> {

    String getLabel();
    List<String> getBounds();

    boolean check(Block toParse);
    T parse(Block block);

    Optional<T> getDefault();

}