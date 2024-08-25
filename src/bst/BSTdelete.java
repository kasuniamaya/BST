package bst;

public class BSTdelete {

	static class BinarySearchTree {
        Node root;

        // Inner class for Node
        static class Node {
            int value;
            Node left, right;

            Node(int item) {
                value = item;
                left = right = null;
            }
        }

        // Function to find the minimum value node in a given subtree
        Node findMin(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        // Function to delete a node from the BST
        Node deleteNode(Node root, int key) {
            if (root == null) {
                return root;
            }

            // Recur down the tree to find the node to delete
            if (key < root.value) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.value) {
                root.right = deleteNode(root.right, key);
            } else {
                // Node with the key is found
                if (root.left == null) {
                    Node temp = root.right;
                    return temp;
                } else if (root.right == null) {
                    Node temp = root.left;
                    return temp;
                }

                // Node with two children
                Node temp = findMin(root.right);
                root.value = temp.value;
                root.right = deleteNode(root.right, temp.value);
            }

            return root;
        }

        // Function for in-order traversal of the BST
        void inorderTraversal(Node root) {
            if (root != null) {
                inorderTraversal(root.left);
                System.out.print(root.value + " ");
                inorderTraversal(root.right);
            }
        }

        // Wrapper function for deleteNode
        void delete(int key) {
            root = deleteNode(root, key);
        }

        // Wrapper function for inorderTraversal
        void inorder() {
            inorderTraversal(root);
            System.out.println();
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree bst = new BinarySearchTree();

        // Constructing the BST
        bst.root = new BinarySearchTree.Node(10);
        bst.root.left = new BinarySearchTree.Node(5);
        bst.root.right = new BinarySearchTree.Node(15);
        bst.root.left.left = new BinarySearchTree.Node(3);
        bst.root.left.right = new BinarySearchTree.Node(7);
        bst.root.right.left = new BinarySearchTree.Node(12);
        bst.root.right.right = new BinarySearchTree.Node(18);

        System.out.println("Original BST In-order Traversal:");
        bst.inorder();

        // Delete node with two children
        int keyToDelete = 10;
        bst.delete(keyToDelete);

        System.out.println("BST After Deleting Node with Key 10:");
        bst.inorder();

	}
}
