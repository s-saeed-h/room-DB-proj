package com.example.roomproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.roomproject.databinding.ActivityMainBinding
import com.example.roomproject.db.DBHandler
import com.example.roomproject.db.Model.UserEntity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = DBHandler.getDatabase(this)

        binding.buttonsave.setOnClickListener{
            lifecycleScope.launch {
                 withContext(Dispatchers.IO){
                    db.UserDao().DeleteAllUsers()
                    /* db.UserDao().DeleteUsers(UserEntity(2,"","","",0 ))

                      db.UserDao().UpdateUser(
                         UserEntity(
                             id = 2,
                             name = "saeedupdate",
                             family = "hoseiniupdate",
                             phon = "09111111",
                             age = 33
                         )
                     )
                      db.UserDao().insertUser(
                         UserEntity(
                             name = "saeed",
                             family = "hoseini",
                             phon = "09111111",
                             age = 25
                         )
                     )*/
                 }
            }
            Toast.makeText(this, "creat user", Toast.LENGTH_SHORT).show()
        }
       binding.buttonget.setOnClickListener{
                    lifecycleScope.launch {

                        withContext(Dispatchers.IO){
                            val users = db.UserDao().getUsers
                            withContext(Dispatchers.Main){
                                users.collect{
                                    var text = ""
                                    it.forEach{usersList ->
                                        text += "$it\n\n"
                                    }
                                binding.textView.text = text
                                }

                            }
                        }
                    }
                    }
        }


}





