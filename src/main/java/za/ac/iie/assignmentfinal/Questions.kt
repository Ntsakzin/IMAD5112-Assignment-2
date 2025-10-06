package za.ac.iie.assignmentfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val questionsView = findViewById<TextView>(R.id.questionsView)
        val feedbackView = findViewById<TextView>(R.id.feedbackView)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val questionsButton = findViewById<Button>(R.id.questionsButton)



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
            true,
            false,
            true,
            true,
            false,
            true,
            true,
            false,
            false,
            true
        )

        var currentquestionNum = 0
        var  scores = 0
        questionsView.text = questionsList[currentquestionNum]

        trueButton.setOnClickListener {
            if (answerList[currentquestionNum]== true){

                scores++
                feedbackView.text= "Congrats! You are correct!!"

            }
        }


        falseButton.setOnClickListener {
            if (answerList[currentquestionNum] == false){

                scores++
                feedbackView.text = "Congrats! You are correct!!"
            }else{
                feedbackView.text = "Oops you are wrong try again!!"
            }
        }

        questionsButton.setOnClickListener {

            currentquestionNum++
            if(currentquestionNum < questionsList.size){
                questionsView.text = questionsList[currentquestionNum]
            }

            else{
                val intent = Intent(this, Score::class.java)
                intent.putExtra("score", scores)
                intent.putExtra("total", 10)
                startActivity(intent)

            }
        }





    }
}
