import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dados {
    public static void carregarDados(NoArvore tree) {
        String fileName = "dados.txt"; 

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] dados = linha.split(";");
                String rgm = dados[0];
                String nome = dados[1];
                tree.adicionar(rgm, nome);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
