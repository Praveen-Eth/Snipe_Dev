package com.augx_universe.snipedev

import android.animation.ObjectAnimator
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Layout
import android.view.View
import android.view.WindowManager
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrdeveloper.codeview.Code
import com.amrdeveloper.codeview.CodeView
import com.augx_universe.snipedev.databinding.ActivityHomePageBinding
import com.google.firebase.auth.FederatedAuthProvider
import java.util.regex.Pattern

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityHomePageBinding
    private lateinit var feedViewModel: FeedViewModel
    lateinit var recyclerView:RecyclerView
    lateinit var feedList: List<FeedItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home_page)
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        binding.bind = feedViewModel
        binding.lifecycleOwner = this

        feedList = emptyList()
        var codeView:CodeView = CodeView(applicationContext)
        var exampleCode = getString(R.string.example_code)
        codeView.text = Editable.Factory.getInstance().newEditable(exampleCode)
        var javaKeywords = arrayOf("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while")
        codeView.addSyntaxPattern(Pattern.compile("\\b(" + javaKeywords.joinToString("|") + ")\\b"), ContextCompat.getColor(this,R.color.javaCodeTheme))
        var arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,javaKeywords)

        codeView.setAdapter(arrayAdapter)
        codeView.requestFocus()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)





        feedList = feedList+ FeedItem(R.drawable.close_monkey,"monkey king",1000,codeView)
        var adapter: RvAdapter = RvAdapter(feedList)
        binding.feedRecyclerView.adapter = adapter
        binding.feedRecyclerView.layoutManager = LinearLayoutManager(this)














    }
}