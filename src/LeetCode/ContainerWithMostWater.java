import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinit on 12/9/15.
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        List<Integer> heightList  = new ArrayList<Integer>();
        int current = 0;
        int itr =0;
        int volume = 0;
        int volumes[] = new int[height.length];

        for(int i=0;i<height.length;i++){

            current = height[i];
            if(i==0){
                heightList.add(i);
            }
            else {

                for(itr=0;itr<heightList.size();itr++){
                    if(height[heightList.get(itr)]>current)
                        break;
                    else{
                        if(itr==0){
                            volumes[i] = Math.min(height[heightList.get(itr)],current)
                                    *(i-heightList.get(itr));
                        }
                        else{
                            volume = Math.min(height[heightList.get(itr)],current)
                                    *(i-heightList.get(itr));
                            volumes[i] = Math.max(volumes[i],volume);
                        }
                    }

                }

                if(itr==0){
                    volumes[i] = Math.min(height[heightList.get(itr)],current)
                            *(i-heightList.get(itr));
                }
                if(current>height[0])
                    heightList.add(i);
            }
        }

        for(int i=0;i<volumes.length;i++){
            if(i==0){
                volume = volumes[i];
            }
            else if(volumes[i]>volume){
                volume = volumes[i];
            }
        }

        return volume;
    }

    public static void main(String[] args){
        int[] vol = {2,1};
        int area = maxArea(vol);
        System.out.println(area);
    }
}
