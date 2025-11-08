package Course.Classes.C;

public class BinaryTree {

    Node root;


    public void insert(int x){
        this.root = insert(x,root);
    }

    public Node insert(int x, Node i){
        if (root == null){
            i = new Node(x);
        }
        else if (root.getElement() > x){
            i.setLeft(insert(x, i.getLeft()));
        }
        else if (root.getElement() < x){
            i.setRight(insert(
                    x,
                    i.getRight()
            ));
        }else {
            throw new RuntimeException("Error!");
        }
        return i;
    }
}
