package com.example.thumbnailcarousel.ui.gallery

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thumbnailcarousel.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private var binding: FragmentGalleryBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentGalleryBinding.inflate(inflater, container, false)
        root = binding!!.getRoot()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var root: View? = null
    }
}