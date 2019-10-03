package dto;

import java.util.List;

public class Node {

    private String value;
    private List<Node> childList;
    protected TypeNode typeNode;
    protected String classifyValue;

    public Node() {
        super();
    }

    public Node(String value, List<Node> childList, TypeNode typeNode, String classifyValue) {
        super();
        this.value = value;
        this.childList = childList;
        this.typeNode = typeNode;
        this.classifyValue = classifyValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String attributeLabelName) {
        this.value = attributeLabelName;
    }

    public List<Node> getChildList() {
        return childList;
    }

    public void setChildList(List<Node> childList) {
        this.childList = childList;
    }

    public TypeNode getTypeNode() {
        return typeNode;
    }

    public void setTypeNode(TypeNode typeNode) {
        this.typeNode = typeNode;
    }

    public String getClassifyValue() {
        return classifyValue;
    }

    public void setClassifyValue(String classifyValue) {
        this.classifyValue = classifyValue;
    }

    @Override
    public String toString() {
        return "Node{" +
                "classifyValue='" + classifyValue + '\'' +
                ", value='" + value + '\'' +
                ", typeNode=" + typeNode +
                ", childList=" + childList +
                '}';
    }
}
