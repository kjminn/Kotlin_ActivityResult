package kr.ac.dongyang.minn.kotlin_activityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.dongyang.minn.kotlin_activityresult.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.text1.text = intent.getStringExtra("name");
        binding.text2.text = "${intent.getIntExtra("year", 0)}"

        binding.btn2.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("returnValue", binding.edit1.text.toString())
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }
}