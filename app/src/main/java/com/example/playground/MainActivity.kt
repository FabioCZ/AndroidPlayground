package com.example.playground

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import toothpick.Scope
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    var scope: Scope? = null
    val references = mutableListOf<StringProvider>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scope = Toothpick.openScopes(application, this)
//        Toothpick.inject(this, scope)
        findViewById<Button>(R.id.button).setOnClickListener {
            createRefs()
            findViewById<Button>(R.id.button).text = "Make more! Now we have ${references.size} instances"
        }
    }

    fun createRefs() {
        for (i in 0..99) {
            val app = scope?.getInstance(StringProvider::class.java) ?: return
            references.add(app)
        }
    }
}