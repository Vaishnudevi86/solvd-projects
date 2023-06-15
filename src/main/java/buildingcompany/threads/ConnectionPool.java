package buildingcompany.threads;
import java.util.concurrent.*;

public class ConnectionPool extends CompletableFuture implements CompletionStage {
    private BlockingQueue<Connection> connections;
    public ConnectionPool(int poolSize) {
        connections = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            connections.add(new Connection());
        }
    }
    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }
    public void releaseConnection(Connection connection) {
        connections.offer(connection);
    }
}