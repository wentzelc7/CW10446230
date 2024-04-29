package com.example.myimada2

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.provider.ContactsContract.StatusUpdates
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private var Hunger = 100
    private var Cleanliness = 50
    private var Happy = 80

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        updateStatus()

        feedButton.setOnClicklistener {
            feedPet()
        }

        cleanButton.setOnClickListener {
            cleanPet()
        }

        playButton.setOnClickListener{
            playWithPet()
        }
    }

    private fun updateStatus() {
        HungerTextView.text = "Hunger: $health%"
        CleanlinessTextView.text = "Cleanliness: $cleanliness%"
    }

    private fun feedPet() {
        petImageView.setImageResource(R.drawable.img_2)
        Hunger -= 20
        if (hunger < 0) hunger = 0
        updateStatus()
        showToast("You fed your pet")
        resetImageAfterDelay()
    }
    private fun cleanPet() {
        petImageView.setImageResource(R.drawable.img_3)
        Cleanliness += 10
        if (Cleanliness > 100) Cleanliness =100
        StatusUpdates()
        showToast("You cleaned your pet.")
        resetImageAfterDelay()
    }

    private fun playWithPet() {
        petImageView.setImageResource(R.drawable.img_4)
        Hunger +=10
        if (Hunger>100) Hunger = 100
        updateStatus()
        showToast("You played with your pet.")
        resetImageAfterDelay()
    }

    private fun resetImageAfterDelay() {
        Handler().postDelayed(
            petImageView.setImageResource(R.drawable.img_1)
    }, 1500)
}

private fun showToast(message:String) {
    Toast.makeText(this.message,Toast.LENGTH_SHORT).show()
    }
}

