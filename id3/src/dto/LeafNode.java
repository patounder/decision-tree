package dto;

import java.util.List;

public class LeafNode extends Node {

    public LeafNode() {
        super();
    }

    public LeafNode(String attributeLabelName, List<Node> childList, TypeNode typeNode, String classifyValue) {
        super(attributeLabelName, childList, typeNode, classifyValue);
    }

    public boolean testCond(){
        return false;
    }
}
