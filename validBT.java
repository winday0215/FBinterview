//1. every node has only one parent
//2. must has a root and there's only one root exist
//3. left and right child must in the children set, no outside node

public boolean isValid(List<TreeNode> nodes){
	  	HashSet<TreeNode> children = new HashSet<> ();
	  	// child node only has one parent node
	  	for (TreeNode node : nodes) {
	  		if (node.left != null) {
	  			if (!children.add(node.left)) return false ;
	  		}
	  		if (node.right != null) {
	  			if (!children.add(node.right)) return false ;
	  		}
	  	}
	  	
	  	TreeNode start = null ;
	  	int count = 0 ;
	  	for (TreeNode node : nodes) {
	  		if (!children.contains(node)) {	  			
	  			start = node ;
	  			count ++ ;
	  		}
	  	}	  	
	  	// BT has only one root node, 1-2-3-1 has 0 
	  	if (count != 1) return false ;
	  		
	  	// running bfs to make sure all nodes can be constructed as a binary tree, all left and right child must in this children set, no outside node 
	  	Queue<TreeNode> q = new LinkedList<> ();
	  	q.add(start) ;	  	
	  	while (!q.isEmpty()) {
	  	   int size = q.size() ;
	  	   for (int i = 0 ; i < size ; ++i) {
	  		   TreeNode cur = q.poll() ;
	  		   if (cur.left != null) {
	  			   q.add(cur.left) ;
	  			   children.remove(cur.left) ;
	  		   }
	  		   if (cur.right != null) {
	  			 q.add(cur.right) ;
	  			 children.remove(cur.right) ;
	  		   }
	  	   }
	  	}	  		  	
	  	return children.size() == 0 ;
	}
