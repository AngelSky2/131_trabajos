import java.util.*;

public class RutasDeEntrega {

    static class Graph {
        private Map<String, List<Edge>> adjacencyList;

        public Graph() {
            adjacencyList = new HashMap<>();
        }

        public void addCity(String city) {
            adjacencyList.putIfAbsent(city, new ArrayList<>());
        }

        public void addEdge(String city1, String city2, int distance) {
            addCity(city1);
            addCity(city2);
            adjacencyList.get(city1).add(new Edge(city2, distance));
            adjacencyList.get(city2).add(new Edge(city1, distance)); // Grafo no dirigido
        }

        public List<Edge> getAdjacencies(String city) {
            return adjacencyList.getOrDefault(city, new ArrayList<>());
        }
    }

    static class Edge {
        String destination;
        int distance;

        public Edge(String destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }
    public static List<String> findRoute(Graph graph, String start, String end) {
        Set<String> visited = new HashSet<>();
        List<String> route = new ArrayList<>();
        if (dfs(graph, start, end, visited, route)) {
            return route;
        }
        return Collections.emptyList(); 
    }
    private static boolean dfs(Graph graph, String current, String end, Set<String> visited, List<String> route) {
        visited.add(current);
        route.add(current);

        if (current.equals(end)) {
            return true;  
        }

        for (Edge edge : graph.getAdjacencies(current)) {
            if (!visited.contains(edge.destination)) {
                if (dfs(graph, edge.destination, end, visited, route)) {
                    return true;
                }
            }
        }

        route.remove(route.size() - 1);  
        return false;
    }

    public static int calculateTotalDistance(Graph graph, List<String> route) {
        int totalDistance = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            String city1 = route.get(i);
            String city2 = route.get(i + 1);
            for (Edge edge : graph.getAdjacencies(city1)) {
                if (edge.destination.equals(city2)) {
                    totalDistance += edge.distance;
                    break;
                }
            }
        }
        return totalDistance;
    }

    public static String evaluateRoute(int distance) {
        if (distance <= 80) {
            return "A+";
        } else if (distance <= 160) {
            return "Corto";
        } else if (distance <= 240) {
            return "Promedio";
        } else if (distance <= 320) {
            return "B";
        } else {
            return "Largo";
        }
    }


    public static void main(String[] args) {
        
        Graph graph = new Graph();
        graph.addEdge("CiudadA", "CiudadB", 50);
        graph.addEdge("CiudadA", "CiudadC", 70);
        graph.addEdge("CiudadA", "CiudadD", 90);
        graph.addEdge("CiudadB", "CiudadC", 60);
        graph.addEdge("CiudadB", "CiudadD", 80);
        graph.addEdge("CiudadC", "CiudadD", 40);
        
        
        graph.addEdge("CiudadA", "CiudadB", 55);
        graph.addEdge("CiudadB", "CiudadC", 65);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la ciudad de origen: ");
        String startCity = scanner.nextLine();
        System.out.print("Ingresa la ciudad de destino: ");
        String endCity = scanner.nextLine();
        System.out.print("Ingresa el rango de distancia mínimo (km): ");
        int minDistance = scanner.nextInt();
        System.out.print("Ingresa el rango de distancia máximo (km): ");
        int maxDistance = scanner.nextInt();

        List<String> route = findRoute(graph, startCity, endCity);
        if (route.isEmpty()) {
            System.out.println("No se encontró una ruta entre " + startCity + " y " + endCity);
        } else {
            int totalDistance = calculateTotalDistance(graph, route);
            System.out.println("Ruta: " + String.join(" -> ", route));
            System.out.println("Distancia total: " + totalDistance + " km");
            if (totalDistance >= minDistance && totalDistance <= maxDistance) {
                System.out.println("Calificación: " + evaluateRoute(totalDistance));
            } else {
                System.out.println("La distancia total no está dentro del rango especificado.");
            }
        }

        scanner.close();
    }
}
