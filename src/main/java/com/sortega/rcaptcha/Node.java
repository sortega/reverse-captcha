package com.sortega.rcaptcha;

public interface Node {

    public abstract long getValue();

    /**
     * Operator precedence. Lower is more associative.
     * @return
     */
    public int precedence();

    @Override
    public abstract String toString();

}
