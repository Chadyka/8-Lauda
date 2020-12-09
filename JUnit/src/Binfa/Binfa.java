package Binfa;

public class Binfa {
    public Binfa() {
        tree = root;
    }

    public void processBit(char b) {
        if (b == '0') {

            if (tree.zeroChild() == null) {
                Node current = new Node('0');
                tree.newZeroChild(current);
                tree = root;
            } else {
                tree = tree.zeroChild();
            }
        } else {
            if (tree.oneChild() == null) {
                Node current = new Node('1');
                tree.newOneChild(current);
                tree = root;
            } else {
                tree = tree.oneChild();
            }
        }
    }

    public void writeTree(java.io.PrintWriter os) {
        depth = 0;
        writeTree(root, os);
    }

    private Node tree = null;
    private int depth, averageSum, averageNum;
    private double meanSum;

    public void writeTree(Node nd, java.io.PrintWriter os) {
        if (nd != null) {
            ++depth;
            writeTree(nd.oneChild(), os);
            for (int i = 0; i < depth; ++i) {
                os.print("---");
            }
            os.print(nd.getCharIn());
            os.print("(");
            os.print(depth - 1);
            os.println(")");
            writeTree(nd.zeroChild(), os);
            --depth;
        }
    }

    protected Node root = new Node('/');
    int maxDepth;
    double average, mean;

    public int getDepth() {
        depth = maxDepth = 0;
        rDepth(root);
        return maxDepth - 1;
    }

    public double getAverage() {
        depth = averageSum = averageNum = 0;
        rAverage(root);
        average = ((double) averageSum) / averageNum;
        return average;
    }

    public double getMean() {
        average = getAverage();
        meanSum = 0.0;
        depth = averageNum = 0;
        rMean(root);
        if (averageNum - 1 > 0) {
            mean = Math.sqrt(meanSum / (averageNum - 1));
        } else {
            mean = Math.sqrt(meanSum);
        }
        return mean;
    }

    public void rDepth(Node elem) {
        if (elem != null) {
            ++depth;
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            rDepth(elem.oneChild());
            rDepth(elem.zeroChild());
            --depth;
        }
    }

    public void rAverage(Node elem) {
        if (elem != null) {
            ++depth;
            rAverage(elem.oneChild());
            rAverage(elem.zeroChild());
            --depth;
            if (elem.oneChild() == null && elem.zeroChild() == null) {
                ++averageNum;
                averageSum += depth;
            }
        }
    }

    public void rMean(Node elem) {
        if (elem != null) {
            ++depth;
            rMean(elem.oneChild());
            rMean(elem.zeroChild());
            --depth;
            if (elem.oneChild() == null && elem.zeroChild() == null) {
                ++averageNum;
                meanSum += ((depth - average) * (depth - average));
            }
        }
    }

    public static void usage() {
        System.out.println("Usage: lzwtree in_file -o out_file");
    }
}