package za.ac.iie.assignmentfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val scoreView = findViewById<TextView>(R.id.scoreView)
        val msgtextView = findViewById<TextView>(R.id.msgtextView)
        val reviewView = findViewById<TextView>(R.id.reviewView)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val retryButton = findViewById<Button>(R.id.retryButton)
        val score = intent.getIntExtra("score", 0)
        val totalquestions = intent.getIntExtra("Total-Questions", 10)

        scoreView.text = " Your score is: ${score} out of ${totalquestions}"

        if ( score >= 7){
            msgtextView.text = "That was a great performance!!"
        } else{

            msgtextView.text = " Do not give up you will get it next time."
        }

        val questionsList = listOf(
            "Nelson Mandela became South Africa's president in 1994",
            "The Cold War was a direct military conflict between USA and USSR",
            "World War I began in 1914",
            "The Great Fire of London happened in 1666",
            "The Berlin Wall was built in 1989",
            "World War II ended in 1945",
            "The Roman Empire fell in 476 AD",
            "The Great Wall of China was built in the 20th century",
            "The Pyramids of Giza were built during the Roman Empire",
            "Nelson Mandela won the Nobel Peace prize in 1993"
        )

        val answerList = listOf(
            true, // Nelson Mandela became South Africa's president in 1994
            false, // The Cold War was a direct military conflict between USA and USSR
            true, // World War I began in 1914
            true, // The Great Fire of London happened in 1666
            false, // The Berlin Wall was built in 1989
            true, // World War II ended in 1945
            true, // The Roman Empire fell in 476 AD
            false, // The Great Wall of China was built in the 20th century
            false, // The Pyramids of Giza were built during the Roman Empire
            true // Nelson Mandela won the Nobel Peace prize in 1993
        )

        reviewButton.setOnClickListener {

            val reviewtextview = StringBuilder()
            for (i in questionsList.indices){
                reviewtextview.append("Question ${i + 1}: ${questionsList[i]}\n")
                reviewtextview.append("Correct answer: ${if (answerList[i]) "True" else "False"}\n")
                reviewView.text = reviewtextview.toString()
            }


        }

        retryButton.setOnClickListener {
            val intent = Intent(this, WelcomePage::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }

    }
}
