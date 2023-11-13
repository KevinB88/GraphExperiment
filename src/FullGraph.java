import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class FullGraph<T> {

   /*
        [The adjacency list for this graph]

        3-D ArrayList reference:

        OuterMost:  ArrayList
        contains ArrayLists that correspond to individual nodes in the graph relative to indices in the array.

        Middle-Array:  ArrayList
        contains ArrayLists for each directional pointer in the GraphNode; left, right, up, and down.
        The left corresponds to index 0, right = 1, up = 2, and down = 3

        Directional-pointer arrays: ArrayList
        Each directional pointer array will hold Pair objects, such that each pair object will contain
        information about the weight and destination node relative to the directional-pointer node.

        Pair:   Pair Object
        The first value stored within the Pair object will be the associated weight between the source node
        and the destination node. The second value will be the value living at the destination node
    */


    private GraphNode last_pointer; //in case we want to add something to the first node of the graph
    private GraphNode first_pointer; //this points to the last node added to the graph
    private ArrayList<ArrayList<ArrayList<Pair>>>adjacencyList = new ArrayList<>();

    public FullGraph(){
        GraphNode root = new GraphNode(null);
        first_pointer = last_pointer = root;
    }

    private String position_text(int i){
        switch(i){
            case 0:
                return "LEFT";
            case 1:
                return "RIGHT";
            case 2:
                return "DOWN";
            case 3:
                return "UP";
        }
            return null;
    }

    //This method is used to randomly attach graph nodes in random directions.


    private void randomly_attach(GraphNode new_entry) {
        List<Integer> availableConnections = new ArrayList<>();
        if (last_pointer.getLeft() == null) availableConnections.add(0);
        if (last_pointer.getRight() == null) availableConnections.add(1);
        if (last_pointer.getDown() == null) availableConnections.add(2);
        if (last_pointer.getUp() == null) availableConnections.add(3);

        if (!availableConnections.isEmpty()) {
            Random random = new Random();
            int randomIndex = availableConnections.get(random.nextInt(availableConnections.size()));

            switch (randomIndex) {
                case 0:
                    last_pointer.update_left(new_entry);
                    new_entry.update_right(last_pointer);
                    break;
                case 1:
                    last_pointer.update_right(new_entry);
                    new_entry.update_left(last_pointer);
                    break;
                case 2:
                    last_pointer.update_down(new_entry);
                    new_entry.update_up(last_pointer);
                    break;
                case 3:
                    last_pointer.update_up(new_entry);
                    new_entry.update_down(last_pointer);
                    break;
            }
        }
        last_pointer = new_entry;
    }



    //The value of the graph nodes are fixed with integer primitives
    public void produce_graph(int node_count){
        ArrayList<GraphNode>node_list = new ArrayList<>();
        for(int i = 0; i < node_count; i++){
            GraphNode new_node = new GraphNode(i+1);
            node_list.add(new_node);
        }

        for(int i = 0; i < node_list.size(); i++){
            randomly_attach(node_list.get(i));
        }
    }

    public void printGraph() {
        Set<GraphNode> visited = new HashSet<>();
        printGraphRecursive(first_pointer, visited);
    }

    private void printGraphRecursive(GraphNode node, Set<GraphNode> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        // Mark the current node as visited
        visited.add(node);

        // Print the current node data
        System.out.print("Node " + node.getData() + " connects to: ");

        // Check each direction and print connected nodes
        if (node.getLeft() != null) {
            System.out.print("Left(" + node.getLeft().getData() + ") ");
        }
        if (node.getRight() != null) {
            System.out.print("Right(" + node.getRight().getData() + ") ");
        }
        if (node.getDown() != null) {
            System.out.print("Down(" + node.getDown().getData() + ") ");
        }
        if (node.getUp() != null) {
            System.out.print("Up(" + node.getUp().getData() + ") ");
        }

        System.out.println(); // New line after printing all connections

        // Recursive calls for each direction
        printGraphRecursive(node.getLeft(), visited);
        printGraphRecursive(node.getRight(), visited);
        printGraphRecursive(node.getDown(), visited);
        printGraphRecursive(node.getUp(), visited);
    }




}

/*
    the initial print function

    public void print_graph(){
        GraphNode curr = first_pointer;

        while(curr.available_connections()) {

            ArrayList<GraphNode> directions = curr.get_connection_status_list();
            int direction = 0;
            for (GraphNode check : directions) {
                if (GraphNode.connection_test(check)) break;
                direction++;
            }
            System.out.println(curr.getData());

            GraphNode mutual = null;

            switch (direction) {
                case 0:
                    curr = curr.getLeft();
                    //mutual = curr.getRight();
                    break;
                case 1:
                    curr = curr.getRight();
                    //mutual = curr.getLeft();
                    break;
                case 2:
                    curr = curr.getDown();
                    //mutual = curr.getUp();
                    break;
                case 3:
                    curr = curr.getUp();
                    //mutual = curr.getDown();
                    break;
            }
            //System.out.println(mutual.getData());
        }
    }
*/
