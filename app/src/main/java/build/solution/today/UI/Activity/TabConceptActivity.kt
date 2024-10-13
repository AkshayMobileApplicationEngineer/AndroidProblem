package build.solution.today.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import build.solution.retrofit.R
import build.solution.today.UI.freagment.DoubtFragment
import build.solution.today.UI.freagment.LastQuizeLeaderBoardFragment
import build.solution.today.UI.freagment.MyRewardsFragment
import build.solution.today.UI.freagment.ProblemClassAppFragment

class TabConceptActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var tabScreenViewPage: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_concept)

        initializeId()
        setupViewPagerWithTabLayout()
    }

    private fun initializeId() {
        tabLayout = findViewById(R.id.tab_layout)
        tabScreenViewPage = findViewById(R.id.tab_screen_view_pager)
    }

    private fun setupViewPagerWithTabLayout() {
        val adapter = ScreenSlidePagerAdapter(this)
        tabScreenViewPage.adapter = adapter

        TabLayoutMediator(tabLayout, tabScreenViewPage) { tab, position ->
            when (position) {
                0 -> tab.text = "My Rewards"
                1 -> tab.text= "App Problem Class "
                2 -> tab.text ="Doubt Class "
            }
        }.attach()
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3// Number of tabs
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> MyRewardsFragment() // Replace with your actual fragment class
                1 -> ProblemClassAppFragment()
                2 -> DoubtFragment()// App Problem Class
                else -> throw IllegalArgumentException("Invalid position")
            }
        }
    }
}
