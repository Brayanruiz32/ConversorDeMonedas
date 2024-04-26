package com.conversor;

import java.util.Map;

public record MonedaRecord(String base_code, Map<String,Double> conversion_rates) {

}
