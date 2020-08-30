package com.example.ead2weather;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText cityInput;
    Button cityBtn;
    TextView currentConditionTitle,celcius1,celcius2,minTempTitle,maxTempTitle,windDirectionTitle,Kmh,windSpeedTitle,outlookTitle;
    TextView currentCondition,minTemp,maxTemp,windDirection,windSpeed,outlook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityInput = findViewById(R.id.cityInput);

        //Titles and appendages
        currentConditionTitle = findViewById(R.id.currentConditionTitle);
        celcius1 = findViewById(R.id.celcius1);
        celcius2 = findViewById(R.id.celcius2);
        minTempTitle = findViewById(R.id.minTempTitle);
        maxTempTitle = findViewById(R.id.maxTempTitle);
        windDirectionTitle = findViewById(R.id.windDirectionTitle);
        Kmh = findViewById(R.id.Kmh);
        windSpeedTitle = findViewById(R.id.windSpeedTitle);
        outlookTitle = findViewById(R.id.outlookTitle);

        // Values
        currentCondition = findViewById(R.id.currentCondition);
        minTemp = findViewById(R.id.minTemp);
        maxTemp = findViewById(R.id.maxTemp);
        windDirection = findViewById(R.id.windDirection);
        windSpeed = findViewById(R.id.windSpeed);
        outlook= findViewById(R.id.outlook);

        cityBtn = findViewById(R.id.cityBtn);


        final WeatherDataService weatherDataService = new WeatherDataService(MainActivity.this);

        cityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // https://developer.android.com/training/volley

                weatherDataService.getCityForecastByCity(cityInput.getText().toString(), new WeatherDataService.ForecastByCityResponse() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something has gone wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(WeatherReportModel weatherReportModel) {
                        //Toast.makeText(MainActivity.this, weatherReportModel.toString(), Toast.LENGTH_SHORT).show();
                        currentCondition.setText(weatherReportModel.getWeatherCurrentCondition());
                        minTemp.setText(String.valueOf(weatherReportModel.getWeatherMinTemp()));
                        maxTemp.setText(String.valueOf(weatherReportModel.getWeatherMaxTemp()));
                        windDirection.setText(weatherReportModel.getWeatherWindDirection());
                        windSpeed.setText(String.valueOf(weatherReportModel.getWeatherWindSpeed()));
                        outlook.setText(weatherReportModel.getWeatherOutlook());

                        currentConditionTitle.setVisibility(View.VISIBLE);
                        celcius1.setVisibility(View.VISIBLE);
                        celcius2.setVisibility(View.VISIBLE);
                        minTempTitle.setVisibility(View.VISIBLE);
                        maxTempTitle.setVisibility(View.VISIBLE);
                        windDirectionTitle.setVisibility(View.VISIBLE);
                        Kmh.setVisibility(View.VISIBLE);
                        windSpeedTitle.setVisibility(View.VISIBLE);
                        outlookTitle.setVisibility(View.VISIBLE);
                        currentCondition.setVisibility(View.VISIBLE);
                        minTemp.setVisibility(View.VISIBLE);
                        maxTemp.setVisibility(View.VISIBLE);
                        windDirection.setVisibility(View.VISIBLE);
                        windSpeed.setVisibility(View.VISIBLE);
                        outlook.setVisibility(View.VISIBLE);
                    }
                });

            }
        });

    }

}