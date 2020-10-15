package br.com.gabrielidsm.correios.Util;

import br.com.gabrielidsm.correios.Model.Request;
import br.com.gabrielidsm.correios.Model.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public abstract class CalculaFrete {

    @SuppressWarnings("rawtypes")
    public static Response calculaFrete(Request request) {
        //Instância da resposta
        Response response = new Response();

        //Atributos
        String nCdEmpresa = "";
        String sDsSenha = "";
        String nCdServico = "41106"; //O tipo de envio é fixo: PAC - 41106
        String tipo = "PAC"; //O tipo de envio é fixo: PAC - 41106
        String sCepOrigem = request.getCepOrigem();
        String sCepDestino = request.getCepDestino();
        String nVlPeso = Float.toString(request.getPeso());
        String nCdFormato = "1"; //
        String nVlComprimento = Float.toString(request.getComprimento());
        String nVlAltura = Float.toString(request.getAltura());
        String nVlLargura = Float.toString(request.getLargura());
        String nVlDiametro = "0";
        String sCdMaoPropria = "n";
        String nVlValorDeclarado = "0";
        String sCdAvisoRecebimento = "n";
        String StrRetorno = "xml";
        
        //URL do webservice Correio
        String urlString = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx";

        //Parâmetros
        Properties parameters = new Properties();

        parameters.setProperty("nCdEmpresa", nCdEmpresa);
        parameters.setProperty("sDsSenha", sDsSenha);
        parameters.setProperty("nCdServico", nCdServico);
        parameters.setProperty("sCepOrigem", sCepOrigem);
        parameters.setProperty("sCepDestino", sCepDestino);
        parameters.setProperty("nVlPeso", nVlPeso);
        parameters.setProperty("nCdFormato", nCdFormato);
        parameters.setProperty("nVlComprimento", nVlComprimento);
        parameters.setProperty("nVlAltura", nVlAltura);
        parameters.setProperty("nVlLargura", nVlLargura);
        parameters.setProperty("nVlDiametro", nVlDiametro);
        parameters.setProperty("sCdMaoPropria", sCdMaoPropria);
        parameters.setProperty("nVlValorDeclarado", nVlValorDeclarado);
        parameters.setProperty("sCdAvisoRecebimento", sCdAvisoRecebimento);
        parameters.setProperty("StrRetorno", StrRetorno);
        
        //Iterador, para criar a URL
        Iterator i = parameters.keySet().iterator();
        
        //Contador
        int counter = 0;
        
        //Percorrer parâmetros
        while (i.hasNext()) {

            //Nome
            String name = (String) i.next();
            
            //Valor
            String value = parameters.getProperty(name);

            //Adicionar um conector (? ou &)
            urlString += (++counter == 1 ? "?" : "&") + name + "=" + value;

        }
        
        try {
            //Cria objeto URL
            URL url = new URL(urlString);

            //Cria objeto httpurlconnection
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();

            //Method set
            connection.setRequestProperty("Request-Method", "GET");

            //Prepara a variável para ler o resultado
            connection.setDoInput(true);
            connection.setDoOutput(false);

            //Conecta a url destino
            connection.connect();

            //Abre a conexão pra input
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            //Lê
            StringBuffer newData = new StringBuffer();
            String s = "";
            while (null != ((s = br.readLine()))) {
                newData.append(s);
            }
            br.close();

            //Prepara o XML que está em string para executar leitura por nodes
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(newData.toString()));
            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("cServico");

            //Faz a leitura dos nodes
            for (int j = 0; j < nodes.getLength(); j++) {
                Element element = (Element) nodes.item(j);

                NodeList valor = element.getElementsByTagName("Valor");
                NodeList prazoEntrega = element.getElementsByTagName("PrazoEntrega");

                Element line = (Element) valor.item(0);
                Element prazo = (Element) prazoEntrega.item(0);

                response.setPrazo(getCharacterDataFromElement(prazo));
                response.setValor(getCharacterDataFromElement(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
        //Retorno
        return response;
    }
    
    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }
    
}