package com.conversor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Api {

    private String monedaBase;

    private String apiKey;

    private String link;

    public Api(String monedaBase, String apiKey) {
        this.monedaBase = monedaBase;
        this.apiKey = apiKey;
        this.link = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase;
        ;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String peticion() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();
        // obtencion de respuesta a travez del paquete HTTP response
        HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());
        return response.body();
    }

}
