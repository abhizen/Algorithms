package Iterators;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by abhinit on 10/31/15.
 * This iterator takes input iterator and returns an iterator which
 * returns sequentially unique elements.
 * Input: 3,3,3,1,2,3  Output: 3,1,2,3
 */
public class SequentiallyUniqueIterator<T> implements Iterator{
    private Iterator<T> iterator = null;
    private int flag = 0;
    private T currentElem = null;
    private T nextElem = null;

    public SequentiallyUniqueIterator(Iterator iterator){
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if(this.flag==0
                && iterator.hasNext()){
            return true;
        }
        else if(this.flag==1){

            if(iterator.hasNext()) {
                this.nextElem = this.iterator.next();
                while (this.nextElem != null
                        && this.nextElem == this.currentElem) {
                    this.nextElem = this.iterator.next();
                }

                if(this.nextElem!=null)
                    return true;
                else
                    return false;
            }
            else
                return false;

        }
        return false;
    }

    @Override
    public Object next() {
        if(this.flag==0
                && iterator.hasNext()){
            this.currentElem = this.iterator.next();
            this.flag=1;
            return this.currentElem;
        }
        else if(this.flag==1){

            if(this.nextElem!=null){
                this.currentElem = this.nextElem;
                return this.currentElem;
            }
            else
                return false;
        }
        return null;
    }

    @Override
    public void remove() {

    }

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(3);

        SequentiallyUniqueIterator iterator =
                new SequentiallyUniqueIterator(list.iterator());

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
