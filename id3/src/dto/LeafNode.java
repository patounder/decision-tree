package dto;

import java.util.List;

public class LeafNode extends Node {
    public LeafNode() {
        super();
    }

    public LeafNode(String attributeLabelName, List<Node> childList) {
        super(attributeLabelName, childList);
    }

    public boolean testCond(){
        return false;
    }
}
