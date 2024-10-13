package build.solution.today.UI.ViewPagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import build.solution.today.UI.freagment.DoubtFragment
import build.solution.today.UI.freagment.LastQuizeLeaderBoardFragment
import build.solution.today.UI.freagment.MyRewardsFragment
import build.solution.today.UI.freagment.ProblemClassAppFragment


class PageViewAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = listOf(
        MyRewardsFragment(),
        LastQuizeLeaderBoardFragment(),
        DoubtFragment(),
        ProblemClassAppFragment(),

    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        if (position < 0 || position >= fragments.size) {
            throw IndexOutOfBoundsException("Invalid position: $position")
        }
        return fragments[position]
    }
}
