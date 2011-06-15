package com.sortega.rcaptcha;

public class OpNode implements Node {
    private final char op;
    private final Node left;
    private final Node right;

    public OpNode(char op, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public long getValue() {
        long l = left.getValue(), r = right.getValue();

        switch(op) {
            case '+':
                return l+r;

            case '-':
                return l-r;

            case '*':
                return l*r;

            case '/':
                return l/r;

            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public int precedence() {
        switch(op) {
            case '*':
            case '/':
                return 1;

            case '+':
            case '-':
                return 2;

            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public String toString() {
        return "(" + left.toString() + this.op + right.toString() + ")";
    }

    private String protectWithParens(Node node) {
        if (node.precedence() >= this.precedence()) {
            return "(" + node.toParenlessString() + ")";
        } else {
            return node.toParenlessString();
        }
    }

    @Override
    public String toParenlessString() {
        String l = protectWithParens(left),
                r = protectWithParens(right);
        return l + op + r;
    }
}
