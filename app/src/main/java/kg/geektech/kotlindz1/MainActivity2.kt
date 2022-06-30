package kg.geektech.kotlindz1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.kotlindz1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    companion object {
        const val SECOND_DATA_NAME = "second_data_name"
        const val SECOND_DATA = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        methodeTwo()
    }
    private fun methodeTwo(){
        val desc = intent.getStringExtra(SECOND_DATA)
        binding.edActivity2.setText(desc)

        binding.btn2.setOnClickListener {
            val data = binding.edActivity2.text.toString()
            val intent = Intent()
            intent.putExtra(SECOND_DATA_NAME, data)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}

