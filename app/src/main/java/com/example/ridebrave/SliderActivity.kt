package com.example.ridebrave

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener

class SliderActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var layoutDots: LinearLayout
    private lateinit var introPreferences: IntroPreferences
    private lateinit var layout: Array<Int>
    private lateinit var tvNext: ImageView
    private lateinit var dots: Array<TextView?>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

        viewPager = findViewById(R.id.slider_pager)
        layoutDots= findViewById(R.id.layout_dots)
        introPreferences= IntroPreferences(this)
        layout = arrayOf(R.layout.screen1, R.layout.screen2, R.layout.screen3)
        tvNext= findViewById(R.id.tv_next)
        dots = arrayOfNulls<TextView>(layout.size)

        if (!introPreferences.isFirstTimeLaunch()) {
            launchHomeScreen()
            finish()
        }

        tvNext.setOnClickListener(View.OnClickListener { _ ->
            run {
                val current = getItem(1)
                if (current < layout.size) {
                    viewPager.currentItem = current
                } else {
                    launchHomeScreen()
                }
            }
        })

        val viewPagerAdapter = MyViewPagerAdapter(this, layout)
        viewPager.adapter = viewPagerAdapter
        viewPager.addOnPageChangeListener(object: OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageSelected(position: Int) {
                addBottomDots(position)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }
        })

        addBottomDots(0)

    }



    private fun getItem(index: Int): Int {
        return viewPager.currentItem + 1
    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls<TextView>(layout.size)
        val activeColors = resources.getIntArray(R.array.active)
        val inactiveColors = resources.getIntArray(R.array.inactive)
        layoutDots.removeAllViews()

        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]?.text = Html.fromHtml("&#8226", Html.FROM_HTML_MODE_LEGACY)
            dots[i]?.textSize = 50F
            dots[i]?.setTextColor(inactiveColors[currentPage])
            layoutDots.addView(dots[i])
        }

        if (dots.isNotEmpty()) {
            dots[currentPage]?.setTextColor(activeColors[currentPage])
        }
    }

    private fun launchHomeScreen() {
        introPreferences.setFirstTimeLaunch(false)
        startActivity(Intent(this, Sos::class.java))
    }

    class MyViewPagerAdapter(val context: Context, val layout: Array<Int>) : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var layoutInflater: LayoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: View = layoutInflater.inflate(layout[position], container, false)
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return layout.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view: View = `object` as View
            container.removeView(view)
        }

    }
}