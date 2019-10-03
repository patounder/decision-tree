package dto;

import java.util.List;

public class Node {

    protected List<Node> childList;
    protected TypeNode typeNode;
    protected String branchValue;

    public Node() {
        super();
    }

    public Node(List<Node> childList, TypeNode typeNode, String branchValue) {
        super();
        this.childList = childList;
        this.typeNode = typeNode;
        this.branchValue = branchValue;
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

    public String getBranchValue() {
        return branchValue;
    }

    public void setBranchValue(String branchValue) {
        this.branchValue = branchValue;
    }

    @Override
    public String toString() {
        return "Node{" +
                "typeNode=" + typeNode +
                ", branchValue='" + branchValue + '\'' +
                ", childList=" + childList +
                '}';
    }
}
