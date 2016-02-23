package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/12/15.
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<Integer> path = new ArrayList();

        List<List<Integer>> paths = traverse(root,path,sum);
        List<List<Integer>> resultPath = null;
        int pathSum = 0;

        if(paths!=null){

            for(List<Integer> tuple : paths){
                pathSum  = 0;
                for(Integer elem : tuple){
                    pathSum = pathSum + elem;
                }

                if(pathSum==sum){
                    if(resultPath ==null)
                        resultPath = new ArrayList();
                    resultPath.add(tuple);
                }
            }
        }

        return resultPath;
    }

    private List<List<Integer>> traverse(TreeNode node,List<Integer> path,int sum){
        List<List<Integer>> tempPath = null;

        if(node==null){
            tempPath = new ArrayList();
            tempPath.add(path);
            return tempPath;
        }

        ArrayList newPath = (ArrayList)((ArrayList)path).clone();
        newPath.add(node.val);
        List<List<Integer>> pathL = traverse(node.left,newPath,sum);
        List<List<Integer>> pathR = traverse(node.right,newPath,sum);

        if(node.left!=null && node.right!=null){

            for(List<Integer> tuple : pathL){
                pathR.add(tuple);
            }
            return pathR;
        }
        else if(node.left==null && node.right!=null){
            return pathR;
        }
        else if(node.left!=null && node.right==null){
            return pathL;
        }
        else
            return pathL;

    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        PathSum instance = new PathSum();
        List<List<Integer>> paths = instance.pathSum(root,1);

        if(paths!=null) {
            for (List<Integer> tuple : paths) {
                System.out.println(tuple);
            }
        }
    }

}
