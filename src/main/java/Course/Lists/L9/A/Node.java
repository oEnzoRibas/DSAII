package Course.Lists.L9.A;

public class Node {
    private int element;
    private Node right, left;

    public Node(int x) {
        this.setElement(x);
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}

