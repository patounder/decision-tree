package dto;

import java.util.List;

public class Node {

    protected List<Node> childList;
    protected String branchValue;

    public Node() {
        super();
    }

    public Node(List<Node> childList, String branchValue) {
        super();
        this.childList = childList;
        this.branchValue = branchValue;
    }


    public List<Node> getChildList() {
        return childList;
    }

    public void setChildList(List<Node> childList) {
        this.childList = childList;
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
                "branchValue='" + branchValue + '\'' +
                ", childList=" + childList +
                '}';
    }
}
