package com.sortega.rcaptcha;

public interface Node {

    public long getValue();

    /**
     * Operator precedence. Lower is more associative.
     * @return
     */
    public int precedence();

    @Override
    public String toString();
    
    public String toParenlessString();
}
