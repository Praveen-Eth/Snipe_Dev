package com.augx_universe.snipedev.activities

import android.opengl.Visibility
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.amrdeveloper.codeview.CodeView
import com.augx_universe.snipedev.R
import com.augx_universe.snipedev.databinding.FragmentAddPostBinding
import com.augx_universe.snipedev.entities.GoSyntaxManager
import com.augx_universe.snipedev.view_models.FeedViewModel

class AddPostFragment : Fragment() {

    private lateinit var feedViewModel: FeedViewModel
    private lateinit var binding: FragmentAddPostBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_post, container, false)
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        binding.bind = feedViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        var codeView = binding.addPostCodeView


        GoSyntaxManager.applyMonokaiTheme(requireContext(),codeView)

        var languageKeywords = arrayListOf<String>(
            "abstract", "annotation", "as", "break", "by", "catch", "class", "companion", "const",
            "constructor", "continue", "crossinline", "data", "do", "else", "enum", "expect",
            "external", "false", "final", "finally", "for", "fun", "get", "if", "import", "in",
            "infix", "init", "inline", "inner", "interface", "internal", "is", "lateinit", "line",
            "noinline", "null", "object", "open", "operator", "out", "override", "package",
            "param", "private", "property", "protected", "public", "receiver", "reified", "return",
            "sealed", "set", "super", "suspend", "tailrec", "this", "throw", "true", "try", "typealias",
            "typeof", "val", "var", "vararg", "when", "where", "while"
        )

        var layoutId = android.R.layout.simple_list_item_1
        var viewId = android.R.id.text1

        var adapter = ArrayAdapter<String>(requireContext(), layoutId, viewId, languageKeywords);

        codeView.setAdapter(adapter)





        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var codeView =binding.addPostCodeView
        var camera =binding.snapshotWithCamera
        var postPreview =binding.postPreview
        postPreview.setOnClickListener {
            codeView.visibility = View.VISIBLE
            postPreview.visibility = View.GONE
        }






    }
}

private fun Editable.append(filterKeyword: List<String>) {

}
