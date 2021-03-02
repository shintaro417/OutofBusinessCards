package com.example.outofbusinesscards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
import com.example.outofbusinesscards.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()
        PreferenceManager.getDefaultSharedPreferences(this).apply {
            val company = getString("company","")
            val postal = getString("postal","")
            val address = getString("address","")
            val tel = getString("tel","")
            val fax = getString("fax","")
            val email = getString("email","")
            val url = getString("url","")
            val position = getString("position","")
            val name = getString("name","")

            binding.companyText.text = company
            binding.postalText.text = postal
            binding.addressText.text = address
            binding.telText.text = "tel:" + tel
            binding.faxText.text = "fax:" + fax
            binding.emailText.text = email
            binding.urlText.text = url
            binding.positionText.text = position
            binding.nameText.text = name

        }
    }

    /**
     * メニューを表示するために使う
     * @param menu オプションメニューのインスタンス
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        /**
         * メニュー表示する
         * @param XMLファイルのリソースID
         * @param 追加先のmenu
         */
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    /**
     * メニューが選択されたときの処理を書く
     * MenuItemのIDによって処理を分岐させる
     * @param item MenuItemのインスタンス
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.edit ->{
                //Kotlinではクラス名::class.javaでクラスのインスタンスを取得する
                /**
                 * アクティビティを開く
                 * ①開きたいアクティビティを引数に指定して、Intentクラスのインスタンスを生成する
                 * ②①で生成したインスタンスをstartActivityに渡す(明示的なインテント)
                 * @param this Context:アプリ自体に関する情報を保持しているオブジェクト(アクティビティなどのコンポーネントはContextのサブクラス)
                 */
                val intent = Intent(this,EditActivity::class.java)
                //
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}