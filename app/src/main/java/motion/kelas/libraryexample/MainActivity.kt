package motion.kelas.libraryexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import motion.kelas.libraryexample.mpchart.MPChartFragment
import motion.kelas.libraryexample.pictures.PicturesFragment
import motion.kelas.libraryexample.qrcode.QRCodeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadFragment(PicturesFragment())
        bnvMain.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menuCamera -> {
                    loadFragment(QRCodeFragment())
                }
                R.id.menuChart -> {
                    loadFragment(MPChartFragment())
                }
                R.id.menuProfile -> {
                    loadFragment(PicturesFragment())
                }
            }
            return@setOnNavigationItemSelectedListener false
        }

    }

    fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.flMain,fragment).commit()
    }
}
