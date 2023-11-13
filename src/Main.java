import java.util.ArrayList;
import javax.swing.*;

//11/12/23: report
/*
    Notes: there might be some errors within the "randomly attach" algorithm, or within the
    print logic of the print methods. There are "null-pointer" exceptions occurring.

    The "randomly attach" algorithm may not be attaching the nodes properly
*/

public class Main {

    public static void main(String[] args) {

          FullGraph<Integer>graph = new FullGraph<>();
          graph.produce_graph(100);
          graph.printGraph();

        //this is a test for the commit!! dawd


        }
}

//testing the connection with the individual graph nodes
   /*     GraNode<String>nation_1 = new GraphNode<>("USA");
          GraphNode<String>nation_2 = new GraphNode<>("Canada");
          GraphNode<String>nation_3 = new GraphNode<>("Mexico");
          GraphNode<String>nation_4 = new GraphNode<>("Spain");
          GraphNode<String>nation_5 = new GraphNode<>("Portugal");

          nation_1.update_up(nation_2);
          nation_2.update_down(nation_1);
          nation_1.update_down(nation_3);
          nation_3.update_up(nation_1);
          nation_1.update_right(nation_5);
          nation_5.update_left(nation_1);
          nation_5.update_up(nation_4);
          nation_4.update_down(nation_5);

        */

