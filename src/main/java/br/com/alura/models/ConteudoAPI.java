package br.com.alura.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record ConteudoAPI(
        @SerializedName("base_code")
        String base,
        @SerializedName("conversion_rates")
        Map<String, Double> conversionRates
) {
}
