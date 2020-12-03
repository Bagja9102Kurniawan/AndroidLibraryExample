package motion.kelas.libraryexample.pictures

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_pictures.view.*

import motion.kelas.libraryexample.R

/**
 * A simple [Fragment] subclass.
 */
class PicturesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pictures, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadImage(view)
    }

    private fun loadImage(view: View) {
        Glide
            .with(activity!!)
            .load("https://media.giphy.com/media/7kn27lnYSAE9O/giphy.gif")
            .centerCrop()
            .placeholder(R.color.colorPrimaryDark)
            .into(view.civPictures)
    }

}
