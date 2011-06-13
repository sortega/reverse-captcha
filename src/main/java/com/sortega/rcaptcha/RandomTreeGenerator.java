package com.sortega.rcaptcha;

import java.util.Random;

/**
 *
 * @author sortega
 */
public class RandomTreeGenerator {
    private final Random random;
    private final static char[] OPS = new char[] { '+', '-', '*', '/'};

    public RandomTreeGenerator() {
        this.random = new Random();
    }

    public Node generateTree(int numNodes) {
        if (numNodes > 1) {
            char op = generateOp();
            int leftNodes = random.nextInt(numNodes - 1);
            int rightNodes = numNodes - 1 - leftNodes;
            
            return new OpNode(op, generateTree(leftNodes), generateTree(rightNodes));
        } else {
            return new ValueNode(random.nextInt(100));
        }
    }

    private char generateOp() {
        return OPS[random.nextInt(OPS.length)];
    }
}
