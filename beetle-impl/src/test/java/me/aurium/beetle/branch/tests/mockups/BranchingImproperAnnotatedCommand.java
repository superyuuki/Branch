package me.aurium.beetle.branch.tests.mockups;

import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.annotate.BranchCommand;
import me.aurium.beetle.branch.annotate.marker.BranchingNode;
import me.aurium.beetle.branch.annotate.marker.SingleNode;

//rule of thumb: If 1 alonenode is found in the class, it is considered an alone-node based class.
//if more than 1 commandnode is found in the class, it is considered a branching node based class
//if there is one branching node in the class, it is considered a branching node based class sans that branching node (it's identifier doesn't matter)

@BranchCommand
public class BranchingImproperAnnotatedCommand {

    @SingleNode(identifier = "branch1")
    public void branch1(NodeContext<String> nodeContext) {
        nodeContext.getSender();
    }

    @SingleNode(identifier = "branch2")
    public void branch2(NodeContext<String> nodeContext) {
        nodeContext.getSender();
    }

    @BranchingNode(identifier = "branching1")
    public static class branching1 {

        @SingleNode(identifier = "fuckOffPissBoy")
        public void lol() {

        }

        @SingleNode(identifier = "cringe")
        public void haha() {

        }

    }

}