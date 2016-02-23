package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 11/26/15.
 */
public class LevelOrderTrav {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root==null)
            return new ArrayList<List<Integer>>();

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<List<Integer>> resultList = levelOrder(list);

        return resultList;
    }

    private List<List<Integer>> levelOrder(List<TreeNode> list){
        List<TreeNode> childList = new ArrayList();
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        if(list.size()==0)
            return resultList;

        for(TreeNode node : list){
            if(node.left!=null)
                childList.add(node.left);
            if(node.right!=null)
                childList.add(node.right);
        }

        resultList = levelOrder(childList);

        List<Integer> entryList = new ArrayList<>();
        for(TreeNode entry : childList) {
            entryList.add(entry.val);
        }

        resultList.add(entryList);

        return resultList;
    }
}
