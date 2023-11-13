import java.util.ArrayList;

public class GraphNode<T> {

    private T data;
    private GraphNode left;
    private GraphNode right;
    private GraphNode down;
    private GraphNode up;
    private ArrayList<GraphNode>connection_status = new ArrayList<>();

    public GraphNode(T data){
        this.data = data;
        left = null;
        right = null;
        down = null;
        up = null;

        //this structure should be fixed
        connection_status.add(left);  //0
        connection_status.add(right); //1
        connection_status.add(down);  //2
        connection_status.add(up);    //3
    }

    public static boolean connection_test(GraphNode current){
        if(current != null) return false;
        else return true;
    }


    //Used to test if a connection exists somewhere on the node

    public boolean available_connections(){
        for(GraphNode current : connection_status){
            if(GraphNode.connection_test(current)) return true;
        }
            return false;
    }

    public T getData(){
        return data;
    }

    public GraphNode getLeft(){
        return left;
    }
    public GraphNode getRight(){
        return right;
    }
    public GraphNode getDown(){
        return down;
    }
    public GraphNode getUp() {
        return up;
    }

    public GraphNode direction_from_index(int index){
        switch(index){
            case 0:
                return getLeft();
            case 1:
                return getRight();
            case 2:
                return getDown();
            case 3:
                return getUp();
        }
            return null;
    }



    public ArrayList<GraphNode> get_connection_status_list(){
        return connection_status;
    }

    public void update_left(GraphNode entry){
        left = entry;
        connection_status.set(0,entry);
    }

    public void update_right(GraphNode entry){
        right = entry;
        connection_status.set(1,entry);
    }

    public void update_down(GraphNode entry){
        down = entry;
        connection_status.set(2,entry);
    }

    public void update_up(GraphNode entry){
        up = entry;
        connection_status.set(3,entry);
    }

    public int find_available_connection(){
        int position = 0;
        for(GraphNode direction : connection_status){
            if(GraphNode.connection_test(direction))break;
            else position++;
        }
            return position;
    }




}

//check if all the nodes are null.

