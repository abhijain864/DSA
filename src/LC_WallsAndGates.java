import java.util.*;

/*
    THINGS I LEARNED ->
    1) LinkedList implementation of queue
 */
public class LC_WallsAndGates {

    public static final int INF = 2147483647;

    public static int[][] rooms;

    public static int[][] getRooms() {
        return rooms;
    }

    public void setRooms(int[][] rooms) {
        LC_WallsAndGates.rooms = rooms;
    }

    public static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public List<Pair> getNeighbours() {
            int[][] rooms = getRooms();
            List<Pair> neighbours = new ArrayList<>();
            int rows = rooms.length;
            int cols = rooms[0].length;
            if (this.x >=0 && this.y>=0 && this.x<rows && this.y<cols) {
                if((this.x + 1 < rows) && rooms[this.x+1][this.y] == INF) {
                    neighbours.add(new Pair(this.x+1, this.y));
                }
                if((this.y + 1 < cols) && rooms[this.x][this.y+1] == INF) {
                    neighbours.add(new Pair(this.x, this.y+1));
                }
                if((this.x - 1 >= 0) && rooms[this.x-1][this.y] == INF) {
                    neighbours.add(new Pair(this.x-1, this.y));
                }
                if((this.y - 1 >= 0) && rooms[this.x][this.y-1] == INF) {
                    neighbours.add(new Pair(this.x, this.y-1));
                }
            }
            return neighbours;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
//        System.out.println(Arrays.deepToString(arr));
        new LC_WallsAndGates().wallsAndGates(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public void wallsAndGates(int[][] rooms) {
        this.setRooms(rooms);
        if (rooms.length > 0) {
            Queue<Pair> queue = new LinkedList<>();
            // initializing of queue
            for(int x=0; x< rooms.length; x++){
                for(int y=0; y<rooms[x].length; y++){
                    if (rooms[x][y]==0) {
                        queue.add(new Pair(x, y));
                    }
                }
            }
            queue.add(new Pair(-1, -1));

            // iteration of queue
            int level = 1;
            while (!queue.isEmpty()) {
                Pair p = queue.peek();
                if(p.getX()==-1 && p.getY()==-1 && queue.size()>1) {
                    queue.add(new Pair(-1, -1));
                    level++;
                }

                // first find valid neighbours of p, if (-1,-1) comes no effect as it will have no valid neighbours.
                for(Pair neighbour : p.getNeighbours()) {
                    rooms[neighbour.getX()][neighbour.getY()] = level;
                    queue.add(neighbour);
                }

                // pop the top element from queue
                queue.poll();
            }
        }

    }

}
