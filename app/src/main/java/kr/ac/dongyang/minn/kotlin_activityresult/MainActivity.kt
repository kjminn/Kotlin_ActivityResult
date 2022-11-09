package kr.ac.dongyang.minn.kotlin_activityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.dongyang.minn.kotlin_activityresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val message = it.data?.getStringExtra("returnValue")
                Toast.makeText(baseContext, message, Toast.LENGTH_SHORT).show()
            }
        }

        val intent = Intent(baseContext, SecondActivity::class.java)
        intent.putExtra("name", "Main Activiy Dongyang")
        intent.putExtra("year", 2022)

        binding.btn1.setOnClickListener {
            activityResult.launch(intent)
        }

    }
}