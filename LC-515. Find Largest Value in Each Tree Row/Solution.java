
/**
           * Definition for a binary tree node.
           * public class TreeNode {
           *     int val;
           *     TreeNode left;
           *     TreeNode right;
           *     TreeNode(int x) { val = x; }
           * }
           */
          class Solution {
              public List<Integer> largestValues(TreeNode root) {

                  List<Integer> list=new ArrayList<>();   //This will be our list of all maximum values
                  
                  if(root==null)  //If root is initially null, we will return empty list.
                  {
                      return list;       
                  }
                  
                  //This is general Level Order Traversal with some additions as per the problem.

                  Queue<TreeNode> queue=new LinkedList<>();             //Creating Queue
                  queue.add(root);                                      //Adding root to our Queue:
                  
                  while(!queue.isEmpty())                            
                  {
                      int max=Integer.MIN_VALUE;                        //Intialising max to Global Minimum.
                      int levelSize=queue.size();                       //Here Level Size means the no. of nodes in our current level;
                      for(int i=0;i<levelSize;i++)
                      {
                          TreeNode currentNode=queue.poll();
                          max=Math.max(currentNode.val,max);                   //Comparing the value of currentNode to max value.
                         
                         if(currentNode.left!=null)
                          {
                              queue.add(currentNode.left);
                          }
                          
                          if(currentNode.right!=null)
                          {
                              queue.add(currentNode.right);
                          }
                      }
                      list.add(max);                                      //Adding Maximum of this level to our list;
                  }
                  return list;

              }
          }
