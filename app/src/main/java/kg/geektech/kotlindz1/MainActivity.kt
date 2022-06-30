package kg.geektech.kotlindz1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.kotlindz1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val SECOND_DATA = "key"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        methodOne()
    }

    private fun methodOne() {

        val launcherData =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.data != null) {
                    val ceo = result.data?.getStringExtra(MainActivity2.EXTRA_DATA_NAME)
                    binding.edActivity1.setText(ceo)
                }
            }
        binding.edBtn.setOnClickListener {
            if (binding.edActivity1.text.trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.app_name), Toast.LENGTH_SHORT).show()

            } else {
                Intent(this, MainActivity2::class.java).apply {
                    putExtra(SECOND_DATA, binding.edActivity1.text.toString())
                    launcherData.launch(this)
                }
            }
        }
    }
}

