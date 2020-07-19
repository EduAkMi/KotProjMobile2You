package com.kaltu.kotprojmobile2you

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.kaltu.kotprojmobile2you.aMovies.MainHome

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var fm: FragmentManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm = supportFragmentManager
        fm.beginTransaction().add(R.id.fragmentContainerMain, MainHome(), null).commit()
    }
}