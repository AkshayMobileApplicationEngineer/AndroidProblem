package build.solution.today

import AdminPannelFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import build.solution.retrofit.R

import build.solution.today.UI.freagment.ManagerFragment
import build.solution.today.UI.freagment.UserFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LoginAccountActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_account)
        initializeViews()
        setupViewPagerWithTabLayout()
    }

    private fun initializeViews() {
        viewPager = findViewById(R.id.loginArea)
        tabLayout = findViewById(R.id.tab_layout)
    }

    private fun setupViewPagerWithTabLayout() {
        val adapter = AdminAreaScreenAdapter(this)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.baseline_admin_panel_settings_24)
                    tab.text = "Admin"
                }
                1 -> {
                    tab.setIcon(R.drawable.baseline_insert_emoticon_24)
                    tab.text = "User"
                }
                2 -> {
                    tab.setIcon(R.drawable.baseline_manage_accounts_24)
                    tab.text = "Manager"
                }
                else -> {
                    tab.setIcon(R.drawable.baseline_disabled_by_default_24) // Fallback icon
                }
            }
        }.attach()
    }

    private inner class AdminAreaScreenAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = 3 // Number of tabs

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> AdminPannelFragment()
                1 -> UserFragment()
                2 -> ManagerFragment()
                else -> throw IllegalArgumentException("Invalid position")
            }
        }
    }
}
