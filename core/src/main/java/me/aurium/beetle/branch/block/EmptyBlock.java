package me.aurium.beetle.branch.block;

import me.aurium.beetle.api.util.NotImplementedException;

import java.util.LinkedList;

public class EmptyBlock implements Block{

    @Override
    public String getIdentifier() {
        throw new NotImplementedException("Empty block should not exist in path!");
    }

    @Override
    public BlockPath asSingleBlockpath() {
        return StringBlockPath.ofEmpty();
    }

    @Override
    public void addFirst(LinkedList<Block> list) {
        //nooops
    }

    @Override
    public void addLast(LinkedList<Block> list) {
        //noops
    }

    public static EmptyBlock of() {
        return new EmptyBlock();
    }


}