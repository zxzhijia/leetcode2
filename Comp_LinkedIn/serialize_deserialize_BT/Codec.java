/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) { return null; }
		StringBuilder sb = new StringBuilder();
		
		// pre order using a stack
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode tmp = st.pop();
			if (tmp == null) {
				sb.append("#,");
			} else {
				st.push(tmp.right);
				st.push(tmp.left);
				sb.append(tmp.val + ",");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) { return null; }
		String[] nodes = data.split(",");
		int[] idx = new int[1];
		TreeNode root = dfs(nodes, idx);
		return root;
    }

	private TreeNode dfs(String[] nodes, int[] idx) {
		if (idx[0] >= nodes.length) { return null; }
		if (nodes[idx[0]].equals("#")) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(nodes[idx[0]]));
		idx[0] += 1;
		root.left = dfs(nodes, idx);
		idx[0] += 1;
		root.right = dfs(nodes, idx);
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
