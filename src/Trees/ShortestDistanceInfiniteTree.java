package Trees;

public class ShortestDistanceInfiniteTree {

    static int distance(int X,int Y){
        int count=0;
        while(X!=Y) {
            if (X>Y) {
                X/=2;
            } else {
                Y/=2;
            }
            count++;
        }
        return count;
    }
}
