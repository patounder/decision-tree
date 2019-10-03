package dto;

import java.util.List;

public class InternNode extends Node {

    private String testAttribute;

    public InternNode() {
        super();
    }

    public InternNode(String testAttribute, List<Node> childList, TypeNode typeNode, String classifyValue) {
        super(childList, typeNode, classifyValue);
        this.testAttribute = testAttribute;
    }

    public String getTestAttribute() {
        return testAttribute;
    }

    public void setTestAttribute(String testAttribute) {
        this.testAttribute = testAttribute;
    }

    @Override
    public String toString() {
        return "InternNode{" +
                "typeNode=" + typeNode +
                ", testAttribute='" + testAttribute + '\'' +
                ", branchValue='" + branchValue + '\'' +
                ", childList=" + childList +
                '}';
    }
}
