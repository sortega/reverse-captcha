package com.sortega.rcaptcha;

/**
 *
 * @author sortega
 */
public class ValueNode implements Node {
    private final long value;

    public ValueNode(long value) {
        this.value = value;
    }

    public long getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Long.toString(this.value, 10);
    }

    public int precedence() {
        return 0;
    }

}
