package dto;

import java.util.List;

public class InternNode extends Node {

    public InternNode() {
        super();
    }

    public InternNode(String value, List<Node> childList, TypeNode typeNode, String classifyValue) {
        super(value, childList, typeNode, classifyValue);
    }
}
