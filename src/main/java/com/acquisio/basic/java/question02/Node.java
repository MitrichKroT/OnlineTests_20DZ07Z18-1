package com.acquisio.basic.java.question02;

class Node {
    String name;
    Node children[];

    public Node(String name, Node... children) {
        this.name = name;
        if (children != null) {
            this.children = new Node[children.length];
            System.arraycopy(
                    children, 0, this.children, 0, children.length);
        }
    }
    public String getNodeName(){
        return this.name;
    }
    public Node[] getChildren(){
        return this.children;
    }
    public void printTree(Node curNode,String tmpSpacer){
        if (curNode!=null){
            System.out.println(tmpSpacer + curNode.getNodeName());
            tmpSpacer=tmpSpacer+TreeNavigation.spacer;
            Node[] tmp = curNode.getChildren();
            for(int i = 0; i < tmp.length; i++) {
                printTree(tmp[i], tmpSpacer);
            }
        }
    }
}


