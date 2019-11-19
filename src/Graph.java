// Nicole Rodrigues - nmr170001

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
    private Stack<Integer> integerStack;
    private int[][] adjacencyMatrix;
    private int maxSizeOfGraph;
    private int currentSizeOfGraph;

    Graph() { // empty constructor
        maxSizeOfGraph = 10; // set to 10
        adjacencyMatrix = new int[10 + 1][10 + 1];
        integerStack = new Stack<>();
    }

    public Graph(int maxSizeOfGraph) { // overloaded constructor
        this.maxSizeOfGraph = maxSizeOfGraph; // size of graph - passed in
        this.adjacencyMatrix = new int[maxSizeOfGraph + 1][maxSizeOfGraph + 1];
        integerStack = new Stack<>();
    }


    // Creating graph i.e adjacency matrix
    void createGraph(String fileName) throws Exception {
        Scanner scanner = new Scanner(new File(fileName)); // Reading graph file
        maxSizeOfGraph = Integer.parseInt(scanner.nextLine()); // get the size from the file
        String fileData; // stores a line of data
        String values[]; // stores the values in the line
        currentSizeOfGraph = 0; // graph is currently empty
        while (scanner.hasNext()) { // while the file still has data
            fileData = scanner.nextLine(); // gets the data
            values = fileData.split(" "); // splitting into values
            for (String value : values) {
                adjacencyMatrix[currentSizeOfGraph + 1][Integer.parseInt(value)] = 1;
                adjacencyMatrix[Integer.parseInt(value)][currentSizeOfGraph + 1] = 1;
            }
            currentSizeOfGraph++; // increasing the size of the graph
        }
    }

    private boolean isEmpty(Stack<Integer> stack) {
        if (stack.size() == 0) { // checks the size of the stack
            return true;
        } else
            return false;
    }

    void isConnected() {
        int vertex = 1;
        int i;
        int elt;
        int[] visitedNodes = new int[maxSizeOfGraph + 1];
        visitedNodes[vertex] = 1;
        integerStack.push(vertex); // add it to the stack
        while (!isEmpty(integerStack)) { // while the stack is not empty
            elt = integerStack.pop();
            i = 1;
            while (i <= maxSizeOfGraph) {
                if (adjacencyMatrix[elt][i] == 1 && visitedNodes[i] == 0) {
                    integerStack.push(i);
                    visitedNodes[i] = 1;
                }
                i++;
            }
        }
        int visitedNodesCount = 0; // counts the visited nodes
        for (i = 1; i <= maxSizeOfGraph; i++) { // for the size of the graph
            if (visitedNodes[i] == 1) {
                System.out.println(i); // print the node
                visitedNodesCount++; // increment count
            }
        }
        // check if connected
        System.out.print("The Graph is: ");
        if (visitedNodesCount == maxSizeOfGraph) {
            System.out.print("Connected.");
        } else {
            System.out.print("not Connected.");
        }
    }

}