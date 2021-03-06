package motion.kelas.libraryexample.pictures

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        // TODO : Add glide here to load image from url then put at CircleImageView
    }

}
