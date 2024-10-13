package build.solution.today

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import build.solution.today.UI.freagment.AdminPannelFragment
import build.solution.retrofit.R
import build.solution.today.UI.freagment.ManagerFragment
import build.solution.today.UI.freagment.UserFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LoginAccountActivity : AppCompatActivity() {

    private lateinit var adminRender: ViewPager2
    private lateinit var adminTabScreen: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_account)
        variableInit()
        setupViewPagerWithTabLayout()
    }

    private fun variableInit() {
        adminRender = findViewById(R.id.loginArea)
        adminTabScreen = findViewById(R.id.tab_layout)
    }

    private fun setupViewPagerWithTabLayout() {
        val adapter = AdminAreaScreenShow(this)
        adminRender.adapter = adapter
        TabLayoutMediator(adminTabScreen, adminRender) { tab, position ->
            when (position) {
                0 -> tab.setIcon(R.drawable.baseline_admin_panel_settings_24)
                1 -> tab.setIcon(R.drawable.baseline_insert_emoticon_24)
                2 -> tab.setIcon(R.drawable.baseline_manage_accounts_24)
                else -> tab.setIcon(R.drawable.baseline_disabled_by_default_24) // Fallback icon
            }
        }.attach()
    }

    private inner class AdminAreaScreenShow(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3 // Number of tabs

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> AdminPannelFragment() // Replace with your actual fragment class
                1 -> UserFragment()
                2 -> ManagerFragment() // Replace with your actual fragment class
                else -> throw IllegalArgumentException("Invalid position")
            }
        }
    }
}
