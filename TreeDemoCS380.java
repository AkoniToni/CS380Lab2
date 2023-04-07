// Name: Tony Coraggio
// Date: 4/12/2023
// Description: Preparing a file for git version control

class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      //base case
      if(root == null){
         return;
      }
      
      System.out.print(root.value+" ");
      //go left recursively
      preOrderTraversal(root.left);
      //go right recursively
      preOrderTraversal(root.right);
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      //base case
      if(root == null){
         return;
      }
      
      //go left recursively
      inOrderTraversal(root.left);
      //process the root
      System.out.print(root.value+" ");
      //go right recursively
      inOrderTraversal(root.right);
   }
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      //base case
      if(root == null){
         return;
      }
      
      //go left recursively
      postOrderTraversal(root.left);
      //go right recursively
      postOrderTraversal(root.right);
      //process the root
      System.out.print(root.value+" ");
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	  if(root == null){
         return false;
      }
      
      // if the root == value, return true, otherwise go left or right
      if(root.value == key){
         return true;      
      }else if(key < root.value){
         return find(root.left, key);
      }else{
         return find(root.right, key);
      }          
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      // if the starting point is null, the tree is empty
      if (root == null) {
         System.out.println("The Tree is empty");
         return -1;
      } 
      
      // keep going left until left is null
      if (root.left == null) {
         return root.data;
      }
      return getMin(root.left);
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  // if the starting point is null, the tree is empty
      if (root == null) {
         System.out.println("The Tree is empty");
         return -1;
      } 
      
      // keep going right until right is null
      if (root.right == null) {
         return root.data;
      }
      return getMin(root.right);
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemoCS380{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
      
      System,out.print"pre-order : ");
      t1.preOrderTraversal(t1.root);
      System.out.println()
      
      System,out.print"post-order : ");
      t1.postOrderTraversal(t1.root);
      System.out.println()   
      
   }  
}