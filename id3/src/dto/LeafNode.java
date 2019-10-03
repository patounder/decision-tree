package dto;

import java.util.List;

public class LeafNode extends Node {

    private String valueLabel;

    public LeafNode() {
        super();
    }

    public LeafNode(String valueLabel, List<Node> childList, String branchValue) {
        super(childList, branchValue);
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
                "valueLabel='" + valueLabel + '\'' +
                ", branchValue='" + branchValue + '\'' +
                ", childList=" + childList +
                '}';
    }
}
