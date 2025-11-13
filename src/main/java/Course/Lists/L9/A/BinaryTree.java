package Course.Lists.L9.A;

public class BinaryTree {
    Node root;

    public BinaryTree(){
        this.root = null;
    }

    void insert(int x){
        this.root = insert(x, this.root);
    }

    Node insert(int x, Node i) {
        if (i == null) {
            i = new Node(x);
        } else if (i.getElement() < x) {
            i.setRight(insert(
                    x,
                    i.getRight()
            ));
        } else if (i.getElement() > x) {
            i.setLeft(insert(
                    x,
                    i.getLeft())
            );
        }
        return i;
    }

        boolean search ( int x){
            return true;
        }
        void walkMiddle () {
        }
        void walkPre () {
        }
        void walkPos () {
        }
        void delete ( int x){
        }

}