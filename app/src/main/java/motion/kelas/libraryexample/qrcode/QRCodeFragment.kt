package motion.kelas.libraryexample.qrcode

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.checkSelfPermission
import com.google.zxing.Result
import kotlinx.android.synthetic.main.fragment_qrcode.*
import kotlinx.android.synthetic.main.fragment_qrcode.view.*
import kotlinx.android.synthetic.main.fragment_qrcode.view.tvResult
import me.dm7.barcodescanner.zxing.ZXingScannerView

import motion.kelas.libraryexample.R

/**
 * A simple [Fragment] subclass.
 */
class QRCodeFragment : Fragment(), ZXingScannerView.ResultHandler  {
    // Variable Global
    lateinit var mScannerView: ZXingScannerView

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
        mScannerView = ZXingScannerView(activity!!)
        mScannerView.setAutoFocus(true)
        mScannerView.setResultHandler(this)
        view?.flBarcode?.addView(mScannerView)
    }

    override fun handleResult(p0: Result?) {
        view?.tvResult?.text = "Result : ${p0?.text}"
    }

    override fun onStart() {
        mScannerView.startCamera()
        doRequestPermission()
        super.onStart()
    }

    override fun onPause() {
        mScannerView.stopCamera()
        super.onPause()
    }

    private fun doRequestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(activity!!,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.CAMERA), 100)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            100 -> {
                initScannerView()
            }
            else -> {
                /* nothing to do in here */
            }
        }
    }
}
