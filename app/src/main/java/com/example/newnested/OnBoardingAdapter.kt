package com.example.newnested

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.textview.MaterialTextView

class OnBoardingAdapter (var context:Context):PagerAdapter(){
    private lateinit var pageList : ArrayList<Model>

    fun setDataList(list: ArrayList<Model>){
        this.pageList = list
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return pageList.size
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var pg = pageList.get(position)
        val view =
            LayoutInflater.from(this.context).inflate(R.layout.pager_layout, container, false)
        val imageView = view.findViewById<ImageView>(R.id.pager_image)
        val textView = view.findViewById<MaterialTextView>(R.id.pager_text)
        imageView.setImageResource(pg.image)
        textView.text = pg.text
        container.addView(view)
        return view
    }
    override fun destroyItem(container: ViewGroup, position: Int, dObject: Any) {
        container.removeView(dObject as View?)
    }
}
