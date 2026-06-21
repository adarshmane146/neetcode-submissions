
public class Codec {

    private static final String SEPARATOR = ",";
    private static final String NULL_NODE = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    // Helper method for serialize using pre-order traversal
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_NODE).append(SEPARATOR);
        } else {
            sb.append(node.val).append(SEPARATOR);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] nodesArray = data.split(SEPARATOR);
        Queue<String> nodesQueue = new LinkedList<>(Arrays.asList(nodesArray));
        return buildTree(nodesQueue);
    }

    // Helper method for deserialize using a queue
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals(NULL_NODE)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}