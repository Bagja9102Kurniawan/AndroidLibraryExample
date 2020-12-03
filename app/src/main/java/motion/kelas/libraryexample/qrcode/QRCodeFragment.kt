package motion.kelas.libraryexample.qrcode

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import motion.kelas.libraryexample.R

/**
 * A simple [Fragment] subclass.
 */

// TODO : Implement Class to ZXingScannerView.ResultHandler at line below
class QRCodeFragment : Fragment()  {

    // TODO : Put Variable Global Here !!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qrcode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initScannerView()
    }

    private fun initScannerView() {
        // TODO : Create ZXingScannerView Here !!!

    }

    // TODO : OVERRIDE function Handle Result, uncomment this :
//    override fun handleResult(p0: Result?) {
//        view?.tvResult?.text = "Result : ${p0?.text}"
//    }

    // TODO : Override onStart() Here !!!

    // TODO : Override onPause() Here !!!



    private fun doRequestPermission() {
        // TODO : add Request Permission
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        // TODO : fill when permission accept or decline here
    }
}
