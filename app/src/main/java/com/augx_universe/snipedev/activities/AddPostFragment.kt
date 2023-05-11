package com.augx_universe.snipedev.activities

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
import androidx.fragment.app.FragmentActivity
import com.amrdeveloper.codeview.CodeView
import com.augx_universe.snipedev.R

class AddPostFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_add_post, container, false)
        var codeView = view.findViewById<CodeView>(R.id.add_post_codeView)
        var  languageKeywords = arrayListOf<String>("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while")

        var layoutId = android.R.layout.simple_list_item_1
        var viewId = android.R.id.text1

        var adapter = ArrayAdapter<String>(requireContext(), layoutId, viewId, languageKeywords);

        codeView.setAdapter(adapter)

        view.setOnTouchListener(object : OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if (event != null) {
                    when(event.action){
                        MotionEvent.ACTION_DOWN -> {
                            val text = codeView.text.toString()
                            val lastWord = text.split("\\W+".toRegex()).lastOrNull() ?: ""
                            val filterKeyword = languageKeywords.filter { it.startsWith(lastWord) }
                            codeView.text.append(filterKeyword)
                            true
                        }

                    }

                }
                return false

            }

        })


        return  view.rootView
    }







}

private fun Editable.append(filterKeyword: List<String>) {

}
