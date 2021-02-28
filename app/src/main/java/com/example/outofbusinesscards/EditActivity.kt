package com.example.outofbusinesscards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.example.outofbusinesscards.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //値の取得
        val pref = PreferenceManager.getDefaultSharedPreferences(this).apply {
            //applu関数を使うとより簡潔に書くことができる。
            val company = getString("company","")
            val postal = getString("postal","")
            val address = getString("address","")
            val tel = getString("tel","")
            val fax = getString("fax","")
            val email = getString("email","")
            val url = getString("url","")
            val position = getString("position","")
            val name = getString("name","")

            binding.companyEdit.setText(company)
            binding.positionEdit.setText(postal)
            binding.addressEdit.setText(address)
            binding.telEdit.setText(tel)
            binding.faxEdit.setText(fax)
            binding.emailEdit.setText(email)
            binding.urlEdit.setText(url)
            binding.positionEdit.setText(position)
            binding.nameEdit.setText(name)
        }




        binding.saveBtn.setOnClickListener {
            //共有プリファレンスに登録
            saveData()
            //アクティビティを終了する
            finish()
        }

        binding.cancelBtn.setOnClickListener {
            finish()
        }
    }

    //共有プリファレンスを使ったデータ保存
    private fun saveData(){
        //SharedPreferencesオブジェクトを取得
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        //SharedPreferences.Editorオブジェクトを取得する
        val editor = pref.edit()
        //K-V方式でデータを保存。最後にapplyで非同期保存
        editor.putString("company",binding.companyEdit.text.toString())
            .putString("postal",binding.postalEdit.text.toString())
            .putString("address",binding.addressEdit.text.toString())
            .putString("tel",binding.telEdit.text.toString())
            .putString("fax",binding.faxEdit.text.toString())
            .putString("email",binding.emailEdit.text.toString())
            .putString("url",binding.urlEdit.text.toString())
            .putString("position",binding.positionEdit.text.toString())
            .putString("name",binding.nameEdit.text.toString())
            .apply()
    }
}