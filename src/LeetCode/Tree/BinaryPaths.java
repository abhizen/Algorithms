package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/11/15.
 */
public class BinaryPaths {
    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> route = traverse(root,"");
        return route;
    }

    private static List<String> traverse(TreeNode node,String path){
        List<String> route = null;
        String tempPath = null;

        if(node==null && path!=null){
            route = new ArrayList<String>();
            route.add(path);
            return route;
        }
        else if(node==null && path==""){
            return null;
        }

        if(path!=null && path=="")
            tempPath = path + node.val;
        else if(path!=null && path!=null)
            tempPath = path + "->"+node.val;

        List<String> routeL = traverse(node.left,tempPath);

        List<String> routeR = traverse(node.right,tempPath);

        if(node.left!=null && node.right!=null && routeR!=null && routeL!=null){
            for(String elem : routeL){
                routeR.add(elem);
            }
            return routeR;
        }
        else if(node.left!=null && node.right==null){
            return routeL;
        }
        else if(node.right!=null && node.left==null){
            return routeR;
        }
        else
            return routeR;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right= new TreeNode(2);
        List<String> route = binaryTreePaths(root);

        for(String elem : route){
            System.out.println(elem+" ");
        }
    }
}
