package br.com.douglasmotta.githubdagger2.ui.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import br.com.douglasmotta.githubdagger2.navigation.Navigator;
import dagger.android.AndroidInjection;

@SuppressLint("Registered")
public class BaseAcitivty extends AppCompatActivity {

    @Inject
    protected Navigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidInjection.inject(this);
    }
}
