package build.solution.today

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import build.solution.retrofit.R
import build.solution.today.UI.TabConceptActivity
import build.solution.today.rewards.RewardsItem

class RewardsAdapter(
    private val context: Context,
    private val leaderboardItems: ArrayList<RewardsItem>
) : RecyclerView.Adapter<LeaderboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rank, parent, false)
        return LeaderboardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LeaderboardViewHolder, position: Int) {
        val item = leaderboardItems[position]

        holder.rankTextView.text = "${item.Rank}."
        holder.unameTextView.text = item.UserName // Display actual username
        holder.scoreTextView.text = "Score: ${item.Score}"
        holder.prizeTextView.text = item.Prize?.toString() ?: "N/A"

        holder.mainLayout.setOnClickListener {
            if (item.Rank == 1) { // Check if the item's rank is 1
                val intent = Intent(context, TabConceptActivity::class.java)
                context.startActivity(intent)
            } else if (item.Rank == 2) { // Use == for comparison
                Toast.makeText(context, "Second class", Toast.LENGTH_SHORT).show()
            }
        }
    }




    override fun getItemCount(): Int {
        return leaderboardItems.size
    }
}

class LeaderboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val rankTextView: TextView = itemView.findViewById(R.id.rankTextView)
    val photoImageView: ImageView = itemView.findViewById(R.id.photoImageView)
    val unameTextView: TextView = itemView.findViewById(R.id.unameTextView)
    val scoreTextView: TextView = itemView.findViewById(R.id.scoreTextView)
    val prizeTextView: TextView = itemView.findViewById(R.id.prizeTextView)
    val mainLayout: LinearLayout = itemView.findViewById(R.id.main)
}
