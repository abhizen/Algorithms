import java.util.*;

/**
 * Created by abhinit on 10/9/15.
 */
public class horizontalwar_graph<T> {
    private Graph<Integer> romanGraph = null;
    private Graph<Integer> persianGraph = null;
    private int dimension;
    private static enum teams  {ROMANS,PERSIANS;}
    private ArrayList<Integer> lowerBoundaryList = null;
    private ArrayList<Integer> leftBoundaryList = null;

    horizontalwar_graph(int dimension){
        this.dimension = dimension;
        this.romanGraph = new Graph<>();
        this.persianGraph = new Graph<>();
        this.lowerBoundaryList = new ArrayList<>();
        this.leftBoundaryList = new ArrayList<>();
    }

    public class Node<T>{
        private T x;
        private T y;
        private LinkedList<Node<T>> adjList = null;
        private String colour = null;

        public Node(T x,T y){
            this.x = x;
            this.y = y;
            this.adjList = new LinkedList<>();
            this.colour = new String("white");
        }

        public LinkedList<Node<T>> getAdjList(){
            return this.adjList;
        }
        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }


        public T getXValue(){
            return this.x;
        }

        public T getYValue(){
            return this.y;
        }

        public void addNode(Node node){
            this.adjList.addLast(node);
        }

        public Node<T> getAdjNode(int index){
            if(this.adjList.size()>index)
                return this.adjList.get(index);
            else
                return null;
        }

        public boolean hasNode(int index){
            if(this.adjList.size()>index && index>=0)
                return true;
            else
                return false;
        }

        public void deleteNode(int index){
            if(this.adjList.size()>index)
                this.adjList.remove(index);
        }

    }
    private class Graph<T> {
        private ArrayList<Node<T>> nodeList = null;

        public Graph() {
            this.nodeList = new ArrayList<>();
        }

        public ArrayList<Node<T>> getNodeList() {
            return nodeList;
        }

        public Node<T> getNode(int index) {
            if (this.nodeList.size() > index && index >= 0)
                return this.nodeList.get(index);
            else
                return null;
        }

        public boolean addNode(T x,T y) {


            int index = 0;
            for (Node<T> tempNode : this.nodeList) {
                if (tempNode.getXValue() == x &&
                        tempNode.getYValue() == y) {
                    return false;
                }
            }

            Node<T> node = new Node<>(x,y);
            this.nodeList.add(node);

            return true;
        }

        public void addEdge(T fromX,T fromY, T toX,T toY) {
            Node<T> fromNode = null;
            Node<T> toNode = null;

            for (Node<T> node : nodeList) {
                if (node.getXValue() == fromX &&
                        node.getYValue()==fromY) {
                    fromNode = node;
                }
                if (node.getXValue() == toX &&
                        node.getYValue()==toY) {
                    toNode = node;
                }
            }

            if(toNode==null || fromNode==null)
                return;

            int index = 0;
            Node<T> node = null;
            while (fromNode.hasNode(index)) {
                node = fromNode.getAdjNode(index);
                if (node.getXValue() == toX &&
                        node.getYValue()==toY) {
                    return;
                }
                index++;
            }

            if(fromNode!=null && toNode!=null)
                fromNode.addNode(toNode);
        }
    }

    public void populate(Integer x,Integer y,int turn,int index){

        if(turn%2==0) {
            this.romanGraph.addNode(x, y);
            if(y.equals(0))
                leftBoundaryList.add(index);

            getConnected(x,y,this.romanGraph);
        }
        else{
            this.persianGraph.addNode(x, y);
            if(x.equals(0))
                lowerBoundaryList.add(index);
            getConnected(x, y, this.persianGraph);
        }
    }

    public boolean search(Graph<T> inputGraph,teams team,Node<T> node){
        Graph<T> graph = inputGraph;
        Stack<Node<T>> stack = new Stack<>();
        int index = 0;

        if(node==null)
            return false;

        Node adjNode = null;
        stack.push(node);
        node.setColour("grey");

        while(!stack.isEmpty()){
            node = stack.pop();

            if(team.equals(teams.ROMANS) && (node.getYValue().equals(dimension-1))){
                return true;
            }
            if(team.equals(teams.PERSIANS) && (node.getXValue().equals(dimension-1))){
                return true;
            }

            index = 0;
            while(node.hasNode(index)) {
                adjNode = node.getAdjNode(index);
                if(adjNode.getColour().equals("white")) {
                    adjNode.setColour("grey");
                    stack.push(adjNode);
                }
                index++;
            }

            node.setColour("black");

        }
        return false;
    }
    private void getConnected(int x,int y,Graph<Integer> graph){
        /*int[] rows = {-1,1,0,1,-1,0};
        int[] columns = {0,0,-1,-1,1,1};*/
        int[] rows =    {-1, 0, 1, 1,0,-1};
        int[] columns = {0, -1,-1, 0,1,1};
        int row = 0;
        int col = 0;

        for(int i=0;i<6;i++){
            row = rows[i];
            col = columns[i];

            if(x+row>=0 && y+col>=0 &&
                    x+row<this.dimension &&
                    y+col<this.dimension){
                graph.addEdge(x,y,x+row,y+col);
                graph.addEdge(x+row,y+col,x,y);
            }
        }
    }
     public void printGraph(Graph<T> graph){
         ArrayList<Node<T>> list = graph.getNodeList();
         LinkedList<Node<T>> nodeList = null;

         for(Node<T> node : list) {
             nodeList = node.getAdjList();
             System.out.println("Parent "+node.getXValue()
                     +" "+node.getYValue());

             for (Node<T> elem : nodeList){
                 System.out.println(elem.getXValue() +
                         " " + elem.getYValue());
            }
         }

     }

     public boolean findWinner(Graph graph,teams team){
         ArrayList<Node<T>> romanVillageList = graph.getNodeList();
         ArrayList<Node<T>> persianVillageList = graph.getNodeList();

         if(team.equals(teams.ROMANS)) {
             for (Integer index : leftBoundaryList) {

                 if (search(graph,
                         team.ROMANS,
                         romanVillageList.get(index))) {

                     return true;
                 }
             }
         }

         if(team.equals(teams.PERSIANS)) {
             for (Integer index : lowerBoundaryList) {

                 if (search(graph,
                         teams.PERSIANS,
                         persianVillageList.get(index)))
                     return true;

             }
         }

         return false;
     }
        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int dimension = in.nextInt();
        int moves = in.nextInt();
        int x = 0;
        int y = 0;
            int persianVillageCount = 0;
            int romanVillageCount = 0;


        horizontalwar_graph  war = new horizontalwar_graph(dimension);

            for(int i=0;i<moves;i++){
                x = in.nextInt();
                y = in.nextInt();
                war.populate(x-1,y-1,i,
                        i%2==0?romanVillageCount:persianVillageCount);
                if(i%2==0)
                    romanVillageCount++;
                else
                    persianVillageCount++;
            }

        if(war.findWinner(war.romanGraph,teams.ROMANS))
            System.out.println("ROMANS");
        else if(war.findWinner(war.persianGraph,teams.PERSIANS))
            System.out.println("PERSIANS");
        else
            System.out.println("NEITHER");
    }
}
