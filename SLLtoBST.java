//in place
TNode sortedListToBST() 
    {
        /*Count the number of nodes in Linked List */
        int n = countNodes(head);
 
        /* Construct BST */
        return sortedListToBSTRecur(n);
    }
 
    /* The main function that constructs balanced BST and
       returns root of it.
       n  --> No. of nodes in the Doubly Linked List */
    TNode sortedListToBSTRecur(int n) 
    {
        /* Base Case */
        if (n <= 0) 
            return null;
 
        /* Recursively construct the left subtree */
        TNode left = sortedListToBSTRecur(n / 2);
 
        /* head_ref now refers to middle node, 
           make middle node as root of BST*/
        TNode root = new TNode(head.data);
 
        // Set pointer to left subtree
        root.left = left;
 
        /* Change head pointer of Linked List for parent 
           recursive calls */
        head = head.next;
 
        /* Recursively construct the right subtree and link it 
           with root. The number of nodes in right subtree  is 
           total nodes - nodes in left subtree - 1 (for root) */
        root.right = sortedListToBSTRecur(n - n / 2 - 1);
 
        return root;
    }
