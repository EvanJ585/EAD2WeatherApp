package com.example.ead2weather;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    public static final String WEATHERAPI_CITY_LINK = "https://ead2weatherapi.azurewebsites.net/api/Weathers/city/";
    Context context;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface ForecastByCityResponse {
        void onError(String message);

        void onResponse(WeatherReportModel weatherReportModel);
    }

    public void getCityForecastByCity(String city, final ForecastByCityResponse forecastByCityResponse) {

            List<WeatherReportModel> report = new ArrayList<>();

            String url = WEATHERAPI_CITY_LINK + city;
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                   // Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                    try {
                        WeatherReportModel weatherReport = new WeatherReportModel();

                        JSONObject weatherInformation = response.getJSONObject(0);
                        weatherReport.setId(weatherInformation.getInt("id"));
                        weatherReport.setWeatherCityName(weatherInformation.getString("city"));
                        weatherReport.setWeatherCurrentCondition(weatherInformation.getString("currentCondition"));
                        weatherReport.setWeatherMinTemp(weatherInformation.getInt("minTemperature"));
                        weatherReport.setWeatherMaxTemp(weatherInformation.getInt("maxTemperature"));
                        weatherReport.setWeatherWindDirection(weatherInformation.getString("windDirection"));
                        weatherReport.setWeatherWindSpeed(weatherInformation.getInt("windSpeed"));
                        weatherReport.setWeatherOutlook(weatherInformation.getString("outlook"));

                        forecastByCityResponse.onResponse(weatherReport);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
            RequestSingleton.getInstance(context).addToRequestQueue(request);
        }
}