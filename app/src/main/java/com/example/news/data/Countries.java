package com.example.news.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Countries {
    private static final String TAG = Countries.class.getSimpleName();
    public List<String> getCountryList(){
        String countries = "ae ar at au be bg br ca ch cn co cu cz de eg fr gb gr hk hu id ie il in it jp kr lt lv" +
                " ma mx my ng nl no nz ph pl pt ro rs ru sa se sg si sk th tr tw ua us ve za";
        List<String> countryList = Arrays.asList(countries.split(" "));
        return countryList;
    }



}
