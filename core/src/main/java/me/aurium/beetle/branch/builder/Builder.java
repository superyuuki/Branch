package me.aurium.beetle.branch.builder;

import me.aurium.beetle.branch.CommandNode;

public interface Builder<C>{

    CommandNode<C> build();

}