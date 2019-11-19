// Nicole Rodrigues - nmr170001

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Graph graph = new Graph(); // creating a graph
            Scanner scanner = new Scanner(System.in); // input for file
            System.out.println("Please enter the name of the file of the graph you would like to test."); // prompt for file
            String fileName = scanner.nextLine(); // gets the file name
            graph.createGraph(fileName); // populate the graph based on the file
            graph.isConnected(); // Passing source vertex as 1

            System.out.println();

            Graph graph1 = new Graph(20);
            System.out.println("Please enter the name of the file of the graph you would like to test."); // prompt for file
            fileName = scanner.nextLine();
            graph1.createGraph(fileName);
            graph1.isConnected();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

