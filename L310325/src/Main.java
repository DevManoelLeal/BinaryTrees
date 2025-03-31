public class Main {
    public static void main(String[] args) {
        //Task-1:
        //Write a code to generate a binary search tree and print it in Inorder traversal, Preorder traversal, and Postorder traversal.
        //
        //Instructions:
        //1.	Create a package “bst” and three classes Inordertraversal, postordertraversal, and preordertraversal.
        //2.	Write add method using generics that takes {7, 4, 12, 2, 6, 9, 15} as input for a binary tree.
        //3.	In each class, print them in their respective order.
        //
        //Expected output:
        //Inorder: [2, 4, 6, 7, 9, 12, 15]
        //Preorder: [7, 4, 2, 6, 12, 9, 15]
        //Postorder: [2, 6, 4, 9, 15, 12, 7]
    }

    // Node Class
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // BinaryTree Class
    public static class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }

        // Method to insert a new node with given key
        public void insert(int key) {
            root = insertRec(root, key);
        }

        // A recursive function to insert a new key in BST
        private Node insertRec(Node root, int key) {
            // If the tree is empty, return a new node
            if (root == null) {
                root = new Node(key);
                return root;
            }

            // Otherwise, recur down the tree
            if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);

            // return the (unchanged) node pointer
            return root;
        }

        // Method to print the tree inorder
        public void inorder() {
            inorderRec(root);
        }

        // Method to print the tree postorder
        public void postorder() {
            postOrderStc(root);
        }

        // Method to print the tree preorder
        public void preorder() {
            preOrderStc(root);
        }

        // Inorder traversal of BST
        private void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }

        // Postorder traversal of BST
        private void postOrderStc(Node root) {
            if (root == null) return;
            postOrderStc(root.left);
            postOrderStc(root.right);
            System.out.print(root.key + " ");
        }

        // Pre-order traversal of BST
        static void preOrderStc(Node root) {
            if (root == null) return;
            System.out.print(root.key + " ");
            preOrderStc(root.left);
            preOrderStc(root.right);
        }

        // Method to search for a key in the tree
        public boolean search(int key) {
            return searchRec(root, key);
        }

        // A utility function to search for a key in BST
        private boolean searchRec(Node root, int key) {
            if (root == null)
                return false;

            if (root.key == key)
                return true;

            if (key < root.key)
                return searchRec(root.left, key);
            else
                return searchRec(root.right, key);
        }

        // Method to find the minimum value in the tree
        public int findMin() {
            return findMinRec(root);
        }

        // A utility function to find the minimum value in BST
        private int findMinRec(Node root) {
            if (root == null)
                throw new IllegalStateException("Tree is empty");

            if (root.left == null)
                return root.key;

            return findMinRec(root.left);
        }

        // Method to find the maximum value in the tree
        public int findMax() {
            return findMaxRec(root);
        }

        // A utility function to find the maximum value in BST
        private int findMaxRec(Node root) {
            if (root == null)
                throw new IllegalStateException("Tree is empty");

            if (root.right == null)
                return root.key;

            return findMaxRec(root.right);
        }

        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();
            // Insert the nodes
            tree.insert(7);
            tree.insert(4);
            tree.insert(12);
            tree.insert(2);
            tree.insert(6);
            tree.insert(9);
            tree.insert(15);

            // Print inorder traversal of the tree
            System.out.println("Inorder traversal:");
            tree.inorder();

            // Print postorder traversal of the tree
            System.out.println("\nPostorder traversal:");
            tree.postorder();

            // Print preorder traversal of the tree
            System.out.println("\nPreorder traversal:");
            tree.preorder();


            // Find minimum and maximum values
            System.out.println("\n\nMinimum value in the tree: " + tree.findMin());
            System.out.println("Maximum value in the tree: " + tree.findMax());
        }
    }
}