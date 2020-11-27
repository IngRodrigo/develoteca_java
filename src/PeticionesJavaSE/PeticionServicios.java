package PeticionesJavaSE;

import PeticionesJavaSE.modelo.RequestJson;
import PeticionesJavaSE.modelo.ResponseUnRegistro;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * REQUIERE LIBRERIA JAR okhttp!!! adicionalmente la libreria okio
 */
public class PeticionServicios {

    public static void ejecutarPeticionGetUnRegistro(String id) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/todos/" + id)
                .method("GET", null)
                //.addHeader("Cookie", "__cfduid=d6217156594e69b46743e61decc1b09a21606485282")
                .build();
        try {
            Response response = client.newCall(request).execute();
            Gson g = new Gson();
            ResponseUnRegistro modeloResponse = g.fromJson(response.body().string(), ResponseUnRegistro.class);
            System.out.println("modeloResponse = " + modeloResponse.getTitle());//ya accedemos al elemento
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }

    public static void ejecutarPeticionGetListaRegistros() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/todos")
                .method("GET", null)
                //.addHeader("Cookie", "__cfduid=d6217156594e69b46743e61decc1b09a21606485282")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String resultadoStringUnico = response.body().string();
            String[] json = resultadoStringUnico.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\{", "").split("\\},");
            String elemento = "";
            for (int i = 0; i < json.length; i++) {
                elemento = json[i].replaceAll("\\}", "");
                Gson g = new Gson();
                ResponseUnRegistro modeloResponse = g.fromJson("{" + elemento + "}", ResponseUnRegistro.class);
                System.out.println("modeloResponse = " + modeloResponse.getId());
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }

    //envaindo formato json
    public static void ejecutarPeticionPostCreateRegistro() {
        RequestJson requestJson = new RequestJson();

        requestJson.setJob("Developer");
        requestJson.setName("Rodrigo Sanchez");

        Gson g = new Gson();

        String json = g.toJson(requestJson);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, json);

        Request request = new Request.Builder()
                .url("https://reqres.in/api/users")
                .method("POST", body)
                //.addHeader("Cookie", "__cfduid=d6217156594e69b46743e61decc1b09a21606485282")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("response = " + response.body().string());
            System.out.println("response = " + response.code());
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }

    public static void ejecutarPeticionPostSoap() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/xml; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType,
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<soap:Envelope "
                + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
                + "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n    "
                + "<soap:Body>\r\n        <f_pedido xmlns=\"http://tempurl.org\">\r\n            "
                + "<ar_user>BK</ar_user>\r\n            <ar_pass>BK125TI</ar_pass>\r\n            "
                + "<ar_ticket>5170</ar_ticket>\r\n            <ar_fecha>2020-11-25</ar_fecha>\r\n            "
                + "<ar_nombre>\"Maru Jacquet\"</ar_nombre>\r\n            "
                + "<ar_documento>\"2289310-5\"</ar_documento>\r\n            "
                + "<ar_telefono>\"021293734\"</ar_telefono>\r\n            "
                + "<ar_direccion>\"\"</ar_direccion>\r\n            "
                + "<ar_formapago>\"Efectivo\"</ar_formapago>\r\n            "
                + "<ar_importe>52000</ar_importe>\r\n            "
                + "<ar_latitud>-25.2265962</ar_latitud>\r\n            "
                + "<ar_longitud>-57.5336827</ar_longitud>\r\n            "
                + "<ar_local>2</ar_local>\r\n        </f_pedido>\r\n    "
                + "</soap:Body>\r\n</soap:Envelope>\r\n");

        Request request = new Request.Builder()
                .url("http://198.12.254.36/web/n_webservice.asmx?op=f_pedido")
                .method("POST", body)
                .addHeader("SOAPAction", "http://tempurl.org/f_pedido")
                .addHeader("Content-Type", "text/xml; charset=utf-8")
                .addHeader("Cookie", "PowerBuilder=CurrentTheme=xp")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println("response = " + response.body().string());
        } catch (IOException ex) {
            Logger.getLogger(PeticionServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
