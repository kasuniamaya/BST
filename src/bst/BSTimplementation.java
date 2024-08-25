package bst;

public class BSTimplementation {
	static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int item) {
            value = item;
            left = right = null;
        }
    }

    public static class BST {
        TreeNode root;

        // Constructor
        public BST() {
            root = null;
        }

        // Insert method
        void insert(int value) {
            root = insertRec(root, value);
        }

        // Recursive insert method
        TreeNode insertRec(TreeNode root, int value) {
            if (root == null) {
                root = new TreeNode(value);
                return root;
            }

            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }

            return root;
        }

        // Search method
        boolean search(int value) {
            return searchRec(root, value);
        }

        // Recursive search method
        boolean searchRec(TreeNode root, int value) {
            if (root == null) {
                return false;
            }

            if (root.value == value) {
                return true;
            }

            return value < root.value
                ? searchRec(root.left, value)
                : searchRec(root.right, value);
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BST bst = new BST();

         // Insert nodes into the BST
         bst.insert(8);
         bst.insert(3);
         bst.insert(10);
         bst.insert(1);
         bst.insert(6);
         bst.insert(4);
         bst.insert(7);
         bst.insert(14);
         bst.insert(13);

         // Search for a node
         int key = 7; // Change this value to search for a different node
         if (bst.search(key)) {
             System.out.println(key + " is present in the BST.");
         } else {
             System.out.println(key + " is not present in the BST.");
         }

	}

}
