package Course.Lists.L6.A;

import Course.Lists.L6.Cell;

public class Stack {

    private Cell<Integer> top;
    private int size = 0;

    public Stack() {
        this.top = null;
    }

    public void push(Integer i) {
        Cell tmp = new Cell(i);
        tmp.setNext(this.top);
        this.top = tmp;
        tmp = null;
        this.size++;
    }

    public void pop() throws Exception {
        if (this.top == null) {
            throw new Exception("Stack is already empty!");
        }
        int element = this.top.getElement();
        Cell tmp = this.top;
        this.top = this.top.getNext();
        tmp.setNext(null);
        tmp = null;
        this.size--;
    }

    public void showStack() {
        System.out.println("[");
        for (Cell c = this.top; c != null; c = c.getNext()) {
            System.out.println(c.getElement() + " ");
        }
        System.out.println("]");
    }

    public boolean isEmpty(){
        return (this.top == null);
    }

    public int getSize(){
        return this.size;
    }

    public int sum(Cell<Integer> top){
        if (top == null) return 0;
        return top.getElement() + sum(top.getNext());
    }


    public int max(){
        int max = this.top.getElement();
        for (Cell<Integer> c = this.top.getNext(); c != null; c = c.getNext()){
            if (c.getElement() > max){
                max = c.getElement();
            }
        }
        return max;
    }

    public void popOrder(Cell<Integer> top) {
        System.out.println(top.getElement());
        if (top.getNext() == null) {
            return;
        }
        popOrder(top.getNext());
    }

    public void bubbleSort(Cell<Integer> top){
        for (Cell<Integer> head = top; top != null; head= head.getNext()) {
                while (head != null) {
                    if (head.getNext() != null) {
                        int topElement = top.getElement();
                        int nextTopElement = (top.getNext()).getElement();
                        if (topElement > nextTopElement) {
                            head.setElement(nextTopElement);
                            head.getNext().setElement(topElement);
                        }
                    }
                }
        }
    }

    public Cell<Integer> getTop() {
        return top;
    }

    public static void main(String[] args) {
        Stack pilha = new Stack();

        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        pilha.push(5);
        pilha.push(6);
        pilha.showStack();

        pilha.bubbleSort(pilha.top);

        pilha.showStack();


    // System.out.printf("Size = %d", pilha.getSize());
    //     try{
    //     pilha.pop();
    // }
    // catch (Exception e){
    //     System.out.println(e.getMessage());
    // }

    // pilha.showStack();
    // System.out.println(pilha.isEmpty());

    // System.out.printf("Size = %d", pilha.getSize());

    // try{
    //     pilha.pop();
    //     pilha.pop();
    //     pilha.pop();
    //     pilha.pop();
    // }
    // catch (Exception e){
    //     System.out.println(e.getMessage());
    // }
    
    // System.out.printf("Size = %d", pilha.getSize());

    // pilha.showStack();
    // System.out.println(pilha.isEmpty());
        
    }
}
