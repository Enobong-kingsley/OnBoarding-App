package com.example.newnested

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    private lateinit var pager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var skipBtn: MaterialTextView
    private var pages: ArrayList<Model> = ArrayList()
    private lateinit var adapter: OnBoardingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.slider)
        tabLayout = findViewById(R.id.item_tab)
        skipBtn = findViewById(R.id.skip_skip)

        adapter = OnBoardingAdapter(this)
        adapter = OnBoardingAdapter(this)
        val page1 = Model(R.drawable.undraw, getString(R.string.first_text))
        val page2 = Model(R.drawable.undraw2, getString(R.string.second_text))
        val page3 = Model(R.drawable.undraw3, getString(R.string.third_text))

        pages.add(page1)
        pages.add(page2)
        pages.add(page3)

        adapter.setDataList(pages)
        pager.adapter = adapter
        tabLayout.setupWithViewPager(pager)

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                var current = pager.currentItem

                if (current == (((pager.adapter as OnBoardingAdapter).count) -1)) {
                    skipBtn.text = getString(R.string.next)
                }else {
                    skipBtn.text = getString(R.string.skip)
                }
            }
        })
        skipBtn.setOnClickListener {
            startActivity(  Intent(this, StartActivity::class.java))
            finish()
        }
    }
}