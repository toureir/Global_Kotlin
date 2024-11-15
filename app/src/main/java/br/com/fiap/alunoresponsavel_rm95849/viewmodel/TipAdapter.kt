package br.com.fiap.alunoresponsavel_rm95849.viewmodel

import android.annotation.SuppressLint
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.alunoresponsavel_rm95849.R
import br.com.fiap.alunoresponsavel_rm95849.data.Tip

class TipAdapter : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {
    private var tips = emptyList<Tip>()

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.textTitle)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.textDescription)
        private val container: LinearLayout = itemView as LinearLayout

        fun bind(tip: Tip) {
            titleTextView.text = tip.title
            descriptionTextView.text = tip.description

            // Adiciona efeito de clique ao item
            container.apply {
                isClickable = true
                isFocusable = true
                val outValue = TypedValue()
                context.theme.resolveAttribute(
                    android.R.attr.selectableItemBackground,
                    outValue,
                    true
                )
                setBackgroundResource(outValue.resourceId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        // Aplica o background personalizado
        view.background = ContextCompat.getDrawable(parent.context, R.drawable.tip_item_background)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(tips[position])
    }

    override fun getItemCount() = tips.size

    @SuppressLint("NotifyDataSetChanged")
    fun setTips(tips: List<Tip>) {
        this.tips = tips
        notifyDataSetChanged()
    }
}