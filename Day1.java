import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.io.IOException;

public class Day1 {

    public static void main (String[] args){

        try {
            // Cria um cliente HTTP
            HttpClient client = HttpClient.newBuilder()
                .build();

            // Cria uma solicitacao do tipo GET
            String header = "API Access Token";
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + header)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

            // Envia a solicitação e receber a resposta de forma síncrona como String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // Verifica o status da resposta
            int statusCode = response.statusCode();
            System.out.println("Status Code: " + statusCode);

            // Imprime o corpo da resposta no console
            System.out.println("Resposta: ");
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
