package Binfa;

public class Node {
    public Node(char charIn) {
        this.charIn = charIn;
        left = null;
        right = null;
    }

    public Node zeroChild() {
        return left;
    }

    public Node oneChild() {
        return right;
    }

    public void newZeroChild(Node r) {
        left = r;
    }

    public void newOneChild(Node r) {
        right = r;
    }

    public char getCharIn() {
        return charIn;
    }

    private char charIn;
    private Node left;
    private Node right;
}
