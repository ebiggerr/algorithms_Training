import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanCode {

    private Node root;
    private Node[] nodes;

    public void createHuffmanTree(int[] weights) {
        Queue<Node> nodeQueue = new PriorityQueue<>();
        nodes = new Node[weights.length];

        //构建森林，初始化nodes数组
        for (int i = 0; i < weights.length; i++) {
            nodes[i] = new Node(weights[i]);
            nodeQueue.add(nodes[i]);

        }

        while (nodeQueue.size() > 1) {
            Node left = nodeQueue.poll();
            Node right = nodeQueue.poll();

            Node parent = new Node(left.weight + right.weight, left, right);
            nodeQueue.add(parent);

        }
        root = nodeQueue.poll();
    }

    public String convertHuffmanCode(int index) {
        return nodes[index].code;
    }

    public void encode(Node node, String code) {
        if (node == null) {
            return;
        }
        node.code = code;
        encode(node.lChild, node.code + "0");
        encode(node.rChild, node.code + "1");
    }

    public static class Node implements Comparable<Node> {
        int weight;
        String code;
        Node lChild;
        Node rChild;

        public Node(int weight, Node lChild, Node rChild) {
            this.weight = weight;
            this.lChild = lChild;
            this.rChild = rChild;
        }

        public Node(int weight) {
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }

        public static void main(String[] args) {
            char[] chars = {'F', 'G', 'H', 'I', 'J', 'K'};
            int[] weights = {5,9,11,36,54,65};

            HuffmanCode huffmanCode = new HuffmanCode();
            huffmanCode.createHuffmanTree(weights);
            huffmanCode.encode(huffmanCode.root, "");

            for (int i = 0; i < chars.length; i++) {
                System.out.println(chars[i] + ":" + huffmanCode.convertHuffmanCode(i));
            }
        }
    }
}
