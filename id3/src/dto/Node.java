package dto;

import java.util.List;

public class Node {

    private String attributeLabelName;
    private List<Node> childList;

    public Node() {
        super();
    }

    public Node(String attributeLabelName, List<Node> childList) {
        super();
        this.attributeLabelName = attributeLabelName;
        this.childList = childList;
    }

    public String getAttributeLabelName() {
        return attributeLabelName;
    }

    public void setAttributeLabelName(String attributeLabelName) {
        this.attributeLabelName = attributeLabelName;
    }

    public List<Node> getChildList() {
        return childList;
    }

    public void setChildList(List<Node> childList) {
        this.childList = childList;
    }

    @Override
    public String toString() {
        return "Node{" +
                "attributeLabelName='" + attributeLabelName + '\'' +
                ", childList=" + childList +
                '}';
    }
}
