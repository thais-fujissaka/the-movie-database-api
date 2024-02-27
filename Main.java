import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.io.IOException;

public class Main {

    public static void main (String[] args){

        try {
            // Cria um cliente HTTP
            HttpClient client = HttpClient.newBuilder()
                .build();

            // Cria uma solicitacao do tipo GET
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.themoviedb.org/3/movie/550?api_key=38531fdef5c36271f43015e364e63ff1")) /*
                Uniform Resourse Identifier - identifica unicamente o recurso solicitado. Define o endereço da API do TMDB
                 que estamos solicitando. Necessida da API Key para autenticação*/
                .GET() // Define o tipo de solicitação desse builder como GET (padrão). Devolve o builder
                .build(); // Constrói e devolve um HttpRequest. Devolve um novo HttpRequest

            // Envia a solicitação e receber a resposta de forma síncrona como String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // Verifica o status da resposta
            int statusCode = response.statusCode();
            System.out.println("Status Code: " + statusCode);

            // Imprime o corpo da resposta no console
            System.out.println("Resposta: ");
            System.out.println(response.body());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
