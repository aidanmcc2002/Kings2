package com.example.kings
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rulesmap = mapOf(
            "a" to "Waterfall - Every player begins drinking, and no one can stop until the player before them does",
            "2" to "You - Whoever drew the card assigns a drink",
            "3" to "Me - Whoever drew the card drinks",
            "4" to "Floor - Everyone races to touch the floor, last person to do so drinks",
            "5" to "Guys - All guys drink",
            "6" to "Chicks - All girls drink",
            "7" to "Heaven - All players point towards the sky, last player to do so drinks",
            "8" to "Mate - Pick a person to drink with",
            "9" to "Rhyme - Say a phrase, and everyone else must say phrases that rhyme",
            "1" to " Categories - Pick a category, and say something from that category ",
            "j" to "Never have I ever - Each player puts up 3 fingers, then starting with the person who drew the card",
            "q" to "Questions - The person who drew the card asks a random person a question, and they then turn and ask a random person a question",
            "k" to "Ruler - Make a rule that everyone must follow until the next King is drawn"
        )
        val ruletext = findViewById<TextView>(R.id.ruletext)
        val button = findViewById<Button>(R.id.big_button)
        val card_img = findViewById<ImageView>(R.id.card_img)
        val rulebutton = findViewById<Button>(R.id.rule_button)
        rulebutton.setOnClickListener{
            val intent = Intent(this, Rules::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val cardpicked = randomCard()
            val ruleinit = cardpicked.get(1).toString()
            ruletext.text = rulesmap.getValue(ruleinit)
            val drawableId = resources.getIdentifier(cardpicked, "drawable", packageName)
            card_img.setImageResource(drawableId)
        }
    }
    fun randomCard (): String {
        val cards = (0..3).random()
        val type = (0..12).random()
        val cardarray = arrayOf('c','d','h','s')
        val typearray = arrayOf('a','2','3','4','5','6','7','8','9',"10",'j','q','k')
        val card = "a${typearray[type]}${cardarray[cards]}"
        return card
    }
}