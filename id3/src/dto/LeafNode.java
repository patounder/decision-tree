package dto;

import java.util.List;

public class LeafNode extends Node {

    private String valueLabel;

    public LeafNode() {
        super();
    }

    public LeafNode(String valueLabel, List<Node> childList, TypeNode typeNode, String branchValue) {
        super(childList, typeNode, branchValue);
        this.valueLabel = valueLabel;
    }

    public String getValueLabel() {
        return valueLabel;
    }

    public void setValueLabel(String valueLabel) {
        this.valueLabel = valueLabel;
    }

    @Override
    public String toString() {
        return "LeafNode{" +
                "typeNode=" + typeNode +
                ", valueLabel='" + valueLabel + '\'' +
                ", branchValue='" + branchValue + '\'' +
                ", childList=" + childList +
                '}';
    }
}
