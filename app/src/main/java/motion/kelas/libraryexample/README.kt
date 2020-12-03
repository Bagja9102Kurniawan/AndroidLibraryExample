package motion.kelas.libraryexample

/*
* TUTORIAL GUIDE
*
* [MPAndroid CHART]
* 1. Go To build.gradle(Module: app) add this at depedencies -> implementation 'com.mysugr.MPAndroidChart:MPAndroidChart:3.1.0-mysugr-1'
* 2. Go To fragment_mpchart add this code inside linear layout
*
    <com.github.mikephil.charting.charts.BarChart
        android:id="@+id/bcMPChart"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
*
* 3. Go to MPChartFragment add Global Variable
*
    val entries = arrayListOf<BarEntry>()
    val listOfMonth = arrayListOf<String>("Jan","Feb","Mar","Apr","Mei","Jun","Jul","Aug","Oct","Nov","Des")
*
* 4. Then add Barchart data at @initBarchart() function. like this :
*
        entries.add(BarEntry(1f, 10f))
        entries.add(BarEntry(2f, 20f))
        entries.add(BarEntry(3f, 10f))
        entries.add(BarEntry(4f, 30f))
        entries.add(BarEntry(5f, 80f))
        entries.add(BarEntry(6f, 10f))
*
* 5. Then inside same function create dataset like this :
*
        val dataset = BarDataSet(entries,"Person In Month")
        dataset.color = Color.parseColor("#FF5722")
        dataset.valueTextColor = Color.parseColor("#888888")

*
* 6. Then inside same function create bardata for MPAndroidChart like this :
*
        val data = BarData(dataset)
        data.barWidth = 0.9f
*
* 7. Then create configuration for MPchart like this :
*
        view.bcMPChart.animateY(5000)
        view.bcMPChart.setFitBars(true)
        view.bcMPChart.description.isEnabled = true
        view.bcMPChart.xAxis.valueFormatter = IndexAxisValueFormatter(listOfMonth)
        view.bcMPChart.xAxis.granularity = 1f
        view.bcMPChart.xAxis.isGranularityEnabled = true
*
* 8. Then put data to mpchart like this :
*
        view.bcMPChart.data = data
        view.bcMPChart.invalidate()
*
* 9. Create MPChart Done
*
* [QRCODE SCANNER]
* 1. Add Library For QRCODE SCANNER at build.gradle (Module:app)
*
   implementation ('me.dm7.barcodescanner:zxing:1.9.8'){
        exclude group: 'com.android.support'
    }
*
* 2. Then add FrameLayout at fragment_qrcode.xml
*
    <FrameLayout
        android:id="@+id/flBarcode"
        android:layout_width="256dp"
        android:layout_height="256dp"
        android:background="@android:color/black"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
*
* 3. Then implement class to ZXingScannerView.ResultHandler like this :
*
    class QRCodeFragment : Fragment(), ZXingScannerView.ResultHandler  {
*
*   Don't Forget to implement when error !
*
* 4. Put Variable Global at below class, like this :
*
    lateinit var mScannerView: ZXingScannerView
*
* 5. Then Create ZXingScanner view at function initScannerView() like this
*
        mScannerView = ZXingScannerView(activity!!)
        mScannerView.setAutoFocus(true)
        mScannerView.setResultHandler(this)
        view?.flBarcode?.addView(mScannerView)
*
* 6. Then Override Handle Result like this :
*
    override fun handleResult(p0: Result?) {
        view?.tvResult?.text = "Result : ${p0?.text}"
    }
*
* 7. Then Override function onStart like this :
*
    override fun onStart() {
        mScannerView.startCamera()
        doRequestPermission()
        super.onStart()
    }
*
* 8. Then Override function onPause() like this :
*
    override fun onPause() {
        mScannerView.stopCamera()
        super.onPause()
    }
*
* 9. Fill function doRequestPermission for camera access, fill with this :
*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(activity!!,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.CAMERA), 100)
            }
        }
*
* 10. Override onRequestPermissionResult with this :
*
        when (requestCode) {
            100 -> {
                initScannerView()
            }
            else -> { }
        }
*
* 11. Last Add Uses Permission at Manifest, like this :
*
    <uses-permission android:name="android.permission.CAMERA" />
*
* 12. Finally Your QRCode Scanner Done
*
*
* [Circle Image View Library]
* 1. Add Library For Circle Image View Library at build.gradle (Module:app)
*
    implementation 'de.hdodenhof:circleimageview:3.1.0'
*
* 2. Add CircleImageViewComponent at fragment_pictures.xml
*
    <de.hdodenhof.circleimageview.CircleImageView
        android:id="@+id/civPictures"
        android:layout_width="96dp"
        android:layout_height="96dp"
        android:layout_marginBottom="24dp"
        app:layout_constraintBottom_toTopOf="@id/tvPersonName"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent" />
*
* 3. Finally your circle image view ready to use. Just add "android:src" attribute to add image default
*
* [Glide Library]
* 1. Add Library For QRCODE SCANNER at build.gradle (Module:app)
*
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
*
* 2. Add Add Uses Permission at Manifest, like this :
*
    <uses-permission android:name="android.permission.INTERNET"/>
*
* 3. Fill LoadImage() functions with Glide and put url to ImageView/CircleImageView Component
*
        Glide
            .with(activity!!)
            .load("https://media.giphy.com/media/7kn27lnYSAE9O/giphy.gif")
            .centerCrop()
            .placeholder(R.color.colorPrimaryDark)
            .into(view.civPictures)
*
* 4. Finally you can load image from url
*
*
* [FINALLY RUN YOUR APPS]
* If Error you can contact me, i will help you :)
* Thank you
*
* * Reference :
* https://medium.com/nusanet/qr-code-scanner-view-di-android-dengan-zxing-1df8914f1ef5
* https://learntodroid.com/how-to-display-a-bar-chart-in-your-android-app/
* https://weeklycoding.com/mpandroidchart-documentation/setting-data/
* https://github.com/bumptech/glide
* https://github.com/hdodenhof/CircleImageView
* */