package br.com.douglasmotta.githubdagger2.data.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    private static final String BASE_URL = "https://api.github.com/";

    private static ApiEndPoint service;

    public static ApiEndPoint getApiService() {
        if (service == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            service = retrofit.create(ApiEndPoint.class);
        }

        return service;
    }
}
