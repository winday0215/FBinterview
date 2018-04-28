//recursive O(n)
Node constructTreeUtil(int pre[], Index preIndex, int key,
            int min, int max, int size) {
 
        // Base case
        if (preIndex.index >= size) {
            return null;
        }
 
        Node root = null;
 
        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) {
 
            // Allocate memory for root of this subtree and increment *preIndex
            root = new Node(key);
            preIndex.index = preIndex.index + 1;
 
            if (preIndex.index < size) {
 
                // Contruct the subtree under root
                // All nodes which are in range {min .. key} will go in left
                // subtree, and first such node will be root of left subtree.
                root.left = constructTreeUtil(pre, preIndex, pre[preIndex.index],
                        min, key, size);
 
                // All nodes which are in range {key..max} will go in right
                // subtree, and first such node will be root of right subtree.
                root.right = constructTreeUtil(pre, preIndex, pre[preIndex.index],
                        key, max, size);
            }
        }
 
        return root;
    }

//iterative O(n)
/*
1. Create an empty stack.

2. Make the first value as root. Push it to the stack.
3. Keep on popping while the stack is not empty and the next value is greater than stack’s top value. Make this value as the right child of the last popped node. Push the new node to the stack.

4. If the next value is less than the stack’s top value, make this value as the left child of the stack’s top node. Push the new node to the stack.

5. Repeat steps 2 and 3 until there are items remaining in pre[].
*/

 Node constructTree(int pre[], int size) {
 
        // The first element of pre[] is always root
        Node root = new Node(pre[0]);
 
        Stack<Node> s = new Stack<Node>();
 
        // Push root
        s.push(root);
 
        // Iterate through rest of the size-1 items of given preorder array
        for (int i = 1; i < size; ++i) {
            Node temp = null;
 
            /* Keep on popping while the next value is greater than
             stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().data) {
                temp = s.pop();
            }
 
            // Make this greater value as the right child and push it to the stack
            if (temp != null) {
                temp.right = new Node(pre[i]);
                s.push(temp.right);
            } 
             
            // If the next value is less than the stack's top value, make this value
            // as the left child of the stack's top node. Push the new node to stack
            else {
                temp = s.peek();
                temp.left = new Node(pre[i]);
                s.push(temp.left);
            }
        }
 
        return root;
    }
